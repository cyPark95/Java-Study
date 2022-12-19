package me.pcy.mockitotest.member;

import me.pcy.mockitotest.domain.Member;
import me.pcy.mockitotest.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newStudy);

    void notify(Member member);
}
