package com.hack.chatgpt.service.member;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.hack.chatgpt.config.auth.SessionUser;
import com.hack.chatgpt.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	private final HttpSession httpSession;


	public SessionUser loginProcess(MemberCommand command) {

		Member member;
		Optional<Member> byEmail = memberRepository.findByEmail(command.getEmail());
		if (byEmail.isEmpty()) {
			member = command.toEntity();
		} else {
			member = byEmail.map(entity -> entity.update(command)).get();
		}
		memberRepository.save(member);
		SessionUser sessionUser = new SessionUser(member);
		httpSession.setAttribute("login_user", sessionUser);
		return sessionUser;
	}

}
