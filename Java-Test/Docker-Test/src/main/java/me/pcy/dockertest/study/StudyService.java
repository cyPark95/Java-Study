package me.pcy.dockertest.study;

import me.pcy.dockertest.domain.Member;
import me.pcy.dockertest.domain.Study;
import me.pcy.dockertest.member.MemberService;

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
