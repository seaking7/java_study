package com.hack.chatgpt.service.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hack.chatgpt.config.auth.OAuthAttributes;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@NoArgsConstructor
@Entity
@Table(name = "d_member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String email;

	private String photo;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;


	@Builder
	public Member(int id, String name, String email, String photo, Role role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.photo = photo;
		this.role = role;
	}

	// 가입 이후 로그인시 호출
	public Member update(OAuthAttributes attributes) {

		this.name = attributes.getName();
		this.photo = attributes.getPicture();
		return this;
	}

	public Member update(MemberCommand command) {

		this.name = command.getName();
		this.photo = command.getPhoto();
		return this;
	}

	public String getRoleKey() {
		return this.role.getKey();
	}
}
