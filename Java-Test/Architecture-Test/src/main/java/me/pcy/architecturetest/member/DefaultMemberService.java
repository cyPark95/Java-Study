package me.pcy.architecturetest.member;

import me.pcy.architecturetest.domain.Member;
import me.pcy.architecturetest.domain.Study;
import me.pcy.architecturetest.study.StudyService;

import java.util.Optional;

public class DefaultMemberService implements MemberService {

    StudyService studyService;

    @Override
    public Optional<Member> findById(Long memberId) {
        return Optional.empty();
    }

    @Override
    public void validate(Long memberId) {
        studyService.hi();
    }

    @Override
    public void notify(Study newStudy) {
        studyService.hi();
    }
}
