package com.hack.chatgpt.controller.api;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hack.chatgpt.common.exception.OauthException;
import com.hack.chatgpt.config.auth.SessionUser;
import com.hack.chatgpt.controller.dto.MemberRequest;
import com.hack.chatgpt.service.member.MemberService;
import com.hack.chatgpt.service.member.MemberCommand;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/session")
public class SessionController {

	private final HttpSession httpSession;
	private final MemberService memberService;

	@Operation(summary = "로그인여부 확인", description = "로그인세션이 존재하면 로그인정보 리턴.")
	@GetMapping("/status")
	public SessionUser getSession(){
		SessionUser loginUser = (SessionUser)httpSession.getAttribute("login_user");
		if( loginUser == null ){
			throw new OauthException();
		}

		return loginUser;
	}


	@Operation(summary = "로그인 처리요청", description = "로그인처리시 호출하면 서버에 로그인세션 생성됩니다.")
	@PostMapping("/login")
	public SessionUser loginProcess(@RequestBody @Valid MemberRequest memberRequest) {
		log.info("login: {}", memberRequest);
		MemberCommand command = memberRequest.toCommand();
		SessionUser sessionUser = memberService.loginProcess(command);
		return sessionUser;
	}


}
