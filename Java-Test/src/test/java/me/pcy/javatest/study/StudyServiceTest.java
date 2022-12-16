package me.pcy.javatest.study;

import me.pcy.javatest.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {

    // Mock 어노테이션을 통해 Mock 객체를 만드는 방법
//    @Mock
//    MemberService memberService;
//    @Mock
//    StudyRepository studyRepository;


    @Test
    void createStudyService(
            // 메서드 매개변수를 통해 Mock 객체를 만드는 방법
            @Mock MemberService memberService,
            @Mock StudyRepository studyRepository
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

}