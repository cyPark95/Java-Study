package me.pcy.javatest.member;

import me.pcy.javatest.domain.Member;
import me.pcy.javatest.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newStudy);

    void notify(Member member);
}
