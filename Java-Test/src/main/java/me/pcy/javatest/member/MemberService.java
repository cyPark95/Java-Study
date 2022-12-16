package me.pcy.javatest.member;

import me.pcy.javatest.domain.Member;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

}
