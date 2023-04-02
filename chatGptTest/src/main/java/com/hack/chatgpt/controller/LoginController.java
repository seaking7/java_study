package com.hack.chatgpt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hack.chatgpt.config.auth.SessionUser;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

	private final HttpSession httpSession;

	@GetMapping("/signIn")      //로그인 화면
	public String signIn(Model model) {
		SessionUser loginUser = (SessionUser)httpSession.getAttribute("login_user");
		if (loginUser != null) {
			model.addAttribute("login_session", loginUser);
		}
		return "login/signIn";
	}
}
