package me.pcy.javatest.study;

import me.pcy.javatest.domain.Member;
import me.pcy.javatest.domain.Study;
import me.pcy.javatest.member.MemberService;


public class StudyService {

    private final MemberService memberService;

    private final StudyRepository repository;

    public StudyService(MemberService memberService, StudyRepository repository) {
        assert memberService != null;
        assert repository != null;
        this.memberService = memberService;
        this.repository = repository;
    }

    public Study createNewStudy(Long memberId, Study study) {
        Member member = memberService.findById(memberId).orElseThrow(() -> {
            throw new IllegalArgumentException("Member doesn't exist for id: '" + memberId);
        });
        study.setOwner(member);
        return repository.save(study);
    }
}
