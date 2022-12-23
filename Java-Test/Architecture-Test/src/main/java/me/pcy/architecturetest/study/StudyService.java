package me.pcy.architecturetest.study;

import me.pcy.architecturetest.domain.Member;
import me.pcy.architecturetest.domain.Study;
import me.pcy.architecturetest.member.MemberService;

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
        return newStudy;
    }

    public Study openStudy(Study study) {
        study.open();
        Study openedStudy = repository.save(study);
        memberService.notify(openedStudy);
        return openedStudy;
    }
}
