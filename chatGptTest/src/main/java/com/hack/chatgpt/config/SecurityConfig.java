package com.hack.chatgpt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.hack.chatgpt.service.member.CustomOAuth2UserService;
import com.hack.chatgpt.service.member.Role;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

	private final CustomOAuth2UserService customOAuth2UserService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.headers().frameOptions().disable()
			.and()
			.authorizeRequests()
			.antMatchers("/*", "/assets/**", "/css/**", "/images/**", "/js/**", "/h2-console/**",
				"/oauth2/**", "/user/**", "/login/**", "/api/**", "/api-docs/**", "/swagger-ui/**").permitAll()
			.antMatchers("/member/**").hasRole(Role.MEMBER.name())
			.anyRequest().authenticated()
			.and()
			.logout()
			.logoutSuccessUrl("/")
			.and()
			.oauth2Login().loginPage("/login/signIn")
			.userInfoEndpoint()         //로그인 성공이후 사용자 정보 가져올때
			.userService(customOAuth2UserService);      //oauth로그인 성공시 후속조치
		return http.build();
	}

}
