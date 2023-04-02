package com.hack.chatgpt.service.chat;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class CompletionService {

	@Value("${space.openai-key}")
	String openAIToken;
	public List<CompletionChoice> getCompletion(String prompt) {
		OpenAiService openAiService = new OpenAiService(openAIToken, Duration.ofSeconds(15));

		log.info("message: {}", prompt);
		CompletionRequest completionRequest = CompletionRequest.builder()
			.model("text-davinci-003")
			.prompt(prompt)
			.echo(false)
			.temperature(0.7)
			.maxTokens(256)
			.bestOf(1)
			.topP(1.0)
			.user("testing")
			.n(1)
			.build();

		List<CompletionChoice> choices = openAiService.createCompletion(completionRequest).getChoices();
		log.info("getCompletion result: {}", choices);
		return choices;
	}
}
