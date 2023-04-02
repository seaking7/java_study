package com.hack.chatgpt.service.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TranslationService {

	@Value("${space.openai-key}")
	String openAIToken;

	public String translate(String prompt) {
		OpenAiService openAiService = new OpenAiService(openAIToken);

		String message = "Translate this into English : "+ prompt;
		log.info("message: {}", message);
		CompletionRequest completionRequest = CompletionRequest.builder()
			.model("text-davinci-003")
			.prompt(message)
			.echo(false)
			.user("testing")
			.n(1)
			.build();

		List<CompletionChoice> choices = openAiService.createCompletion(completionRequest).getChoices();
		String returnMessage = choices.get(0).getText();
		log.info("result: {}", choices);
		return returnMessage;
	}
}
