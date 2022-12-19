package me.pcy.dockertest.member;

import me.pcy.dockertest.domain.Member;
import me.pcy.dockertest.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newStudy);
}
