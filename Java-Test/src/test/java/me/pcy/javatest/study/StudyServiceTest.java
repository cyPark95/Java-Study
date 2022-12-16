package me.pcy.javatest.study;

import me.pcy.javatest.domain.Member;
import me.pcy.javatest.domain.Study;
import me.pcy.javatest.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    @InjectMocks
    StudyService studyService;

    // Mock 어노테이션을 통해 Mock 객체를 만드는 방법
    @Mock
    MemberService memberService;
    @Mock
    StudyRepository studyRepository;


    @Test
    void createStudyService(
            // 메서드 매개변수를 통해 Mock 객체를 만드는 방법
//            @Mock MemberService memberService,
//            @Mock StudyRepository studyRepository
    ) {

        // 직접 구현하는 방법
//        MemberService memberService = new MemberService() {
//            ...
//            직접 구현
//        };
//        StudyRepository studyRepository = new StudyRepository() {
//            ...
//            직접 구현
//        };

        // mock 메서드를 통해 Mock 객체를 만드는 방법
//        MemberService memberService = mock(MemberService.class);
//        StudyRepository studyRepository = mock(StudyRepository.class);

        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
    }

    @Test
    void stubbingTest() {
        Member member = new Member();
        member.setId(1L);
        member.setEmail("pcy@email.com");

        when(memberService.findById(any())).thenReturn(Optional.of(member));

        assertEquals("pcy@email.com", memberService.findById(1L).get().getEmail());
        assertEquals("pcy@email.com", memberService.findById(2L).get().getEmail());

        when(memberService.findById(3L)).thenThrow(new RuntimeException());
        doThrow(new IllegalArgumentException()).when(memberService).validate(1L);

        assertThrows(RuntimeException.class, () -> memberService.findById(3L));
        assertThrows(IllegalArgumentException.class, () -> memberService.validate(1L));
    }

    @Test
    void mockRepeatResultTest() {
        Member member = new Member();
        member.setId(1L);
        member.setEmail("pcy@email.com");

        when(memberService.findById(any()))
                .thenReturn(Optional.of(member))
                .thenThrow(new RuntimeException())
                .thenReturn(Optional.empty());

        Optional<Member> byId = memberService.findById(1L);
        assertEquals("pcy@email.com", byId.get().getEmail());

        assertThrows(RuntimeException.class, () -> memberService.findById(2L));

        assertEquals(Optional.empty(), memberService.findById(3L));
    }

    @Test
    void stubbingPractice() {
        Member member = new Member();
        member.setId(1L);
        member.setEmail("pcy@email.com");

        Study study = new Study(10, "테스트");

        // TODO memberService 객체에 findById 메소드를 1L 값으로 호출하면 Optional.of(member) 객체를 리턴하도록 Stubbing
        when(memberService.findById(1L)).thenReturn(Optional.of(member));

        // TODO studyRepository 객체에 save 메소드를 study 객체로 호출하면 study 객체 그대로 리턴하도록 Stubbing
        when(studyRepository.save(study)).thenReturn(study);

        studyService.createNewStudy(1L, study);

        assertNotNull(study.getOwner());
        assertEquals(member, study.getOwner());
    }

    @Test
    void mockCheckTest() {
        Member member = new Member();
        member.setId(1L);
        member.setEmail("pcy@email.com");

        Study study = new Study(10, "테스트");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(studyRepository.save(study)).thenReturn(study);

        studyService.createNewStudy(1L, study);

        assertEquals(member, study.getOwner());

        // 1번 호출되어야 한다.
        verify(memberService, times(1)).notify(study);
        verify(memberService, times(1)).notify(member);

        // 호출되지 않아야한다.
        verify(memberService, never()).validate(any());

        // 호출 순서 확인
        InOrder inOrder = inOrder(memberService);
        inOrder.verify(memberService).notify(study);
        inOrder.verify(memberService).notify(member);

        // 호출될께 없어야 한다.
        verifyNoMoreInteractions(memberService);
    }
}