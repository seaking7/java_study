package com.hack.chatgpt.config.auth;

import java.util.Map;

import com.hack.chatgpt.service.member.Member;
import com.hack.chatgpt.service.member.Role;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class OAuthAttributes {

	private final Map<String, Object> attributes;
	private final String nameAttributeKey;

	private final int id;
	private final String name;
	private final String email;

	private final String picture;


	@Builder
	public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey,
		int id, String name, String email, String picture) {
		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.id = id;
		this.name = name;
		this.email = email;
		this.picture = picture;
	}

	//registrationId : github, google, naver 등 인증주체, userNameAttributeName : 인증방법(id 등)
	public static OAuthAttributes of(String registrationId, String userNameAttributeName,
		Map<String, Object> attributes) {

		if (registrationId.equals("naver")) {
			return ofNaver("id", attributes);
		}
		return ofGoogle(userNameAttributeName, attributes);
	}


	private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
		return OAuthAttributes.builder()
			.name((String)attributes.get("name"))
			.email((String)attributes.get("email"))
			.picture((String)attributes.get("picture"))
			.attributes(attributes)
			.nameAttributeKey(userNameAttributeName)
			.build();
	}

	private static OAuthAttributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
		Map<String, Object> response = (Map<String, Object>)attributes.get("response");

		return OAuthAttributes.builder()
			.name((String)response.get("name"))
			.email((String)response.get("email"))
			.picture((String)response.get("profile_image"))
			.attributes(response)
			.nameAttributeKey(userNameAttributeName)
			.build();
	}

	// 회원가입 Entity 생성
	public Member toEntity() {
		return Member.builder()
			.id(id)
			.name(name)
			.email(email)
			.photo(picture)
			.role(Role.MEMBER)
			.build();
	}

}
