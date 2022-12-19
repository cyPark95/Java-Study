package me.pcy.mockitotest.study;

import me.pcy.mockitotest.domain.Member;
import me.pcy.mockitotest.domain.Study;
import me.pcy.mockitotest.member.MemberService;


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
        Study newStudy = repository.save(study);
        memberService.notify(newStudy);
        memberService.notify(member);
        return newStudy;
    }

    public Study openStudy(Study study) {
        study.open();
        Study openedStudy = repository.save(study);
        memberService.notify(openedStudy);
        return openedStudy;
    }
}
