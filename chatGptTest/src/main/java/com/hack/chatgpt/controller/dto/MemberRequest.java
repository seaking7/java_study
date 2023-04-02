package com.hack.chatgpt.controller.dto;

import com.hack.chatgpt.service.member.MemberCommand;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberRequest {

	private String email;
	private String name;
	private String userKey;
	private String photo;

	public MemberCommand toCommand() {
		return MemberCommand.builder()
			.email(email)
			.name(name)
			.userKey(userKey)
			.photo(photo)
			.build();
	}

}
