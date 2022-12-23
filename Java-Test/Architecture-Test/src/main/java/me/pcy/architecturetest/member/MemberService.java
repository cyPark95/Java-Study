package me.pcy.architecturetest.member;

import me.pcy.architecturetest.domain.Member;
import me.pcy.architecturetest.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newStudy);
}
