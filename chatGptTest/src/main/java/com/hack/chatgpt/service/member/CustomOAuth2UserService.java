package com.hack.chatgpt.service.member;

import java.util.Collections;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.hack.chatgpt.config.auth.OAuthAttributes;
import com.hack.chatgpt.config.auth.SessionUser;
import com.hack.chatgpt.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
	private final MemberRepository memberRepository;
	private final HttpSession httpSession;

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2UserService delegate = new DefaultOAuth2UserService();
		OAuth2User oAuth2User = delegate.loadUser(userRequest);
		log.info("loadUser== {}", oAuth2User.toString());

		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails()
			.getUserInfoEndpoint().getUserNameAttributeName();

		log.info("registrationId :{}, userNameAttributeName:{}", registrationId, userNameAttributeName);
		OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNameAttributeName,
			oAuth2User.getAttributes());

		log.info("{}", attributes);

		Member member = oauthLoginProcess(attributes);
		httpSession.setAttribute("login_user", new SessionUser(member));

		return new DefaultOAuth2User(
			Collections.singleton(new SimpleGrantedAuthority(member.getRoleKey())),
			attributes.getAttributes(),
			attributes.getNameAttributeKey());
	}

	private Member oauthLoginProcess(OAuthAttributes attributes) {

		Member member;
		Optional<Member> byEmail = memberRepository.findByEmail(attributes.getEmail());
		if (byEmail.isEmpty()) {
			member = attributes.toEntity();
		} else {
			member = byEmail.map(entity -> entity.update(attributes)).get();
		}

		return memberRepository.save(member);
	}


}
