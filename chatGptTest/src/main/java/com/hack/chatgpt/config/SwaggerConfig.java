package com.hack.chatgpt.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {


	@Bean
	public GroupedOpenApi groupedOpenApi1() {
		return GroupedOpenApi.builder().group("space-i").pathsToMatch("/**").build();
	}

	@Bean
	public OpenAPI openApi() {
		return new OpenAPI()
			.info(new Info().title("SpaceI")
				.description("Space I api document"));
	}
}
