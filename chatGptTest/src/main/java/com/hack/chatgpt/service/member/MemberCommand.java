package com.hack.chatgpt.service.member;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MemberCommand {

	private String name;
	private String email;
	private String userKey;
	private String photo;

	public Member toEntity() {
		return Member.builder()
			.name(name)
			.email(email)
			.photo(photo)
			.role(Role.MEMBER)
			.build();
	}

}
