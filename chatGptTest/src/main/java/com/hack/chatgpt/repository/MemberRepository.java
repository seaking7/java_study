package com.hack.chatgpt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hack.chatgpt.service.member.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	Optional<Member> findByEmail(String email);
}
