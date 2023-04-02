package com.hack.chatgpt.config.auth;

import java.io.Serializable;

import com.hack.chatgpt.service.member.Member;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable {

	private final int id;
	private final String email;
	private final String name;
	private final String photo;

	public SessionUser(Member member) {
		this.id = member.getId();
		this.email = member.getEmail();
		this.name = member.getName();
		this.photo = member.getPhoto();

	}
}
