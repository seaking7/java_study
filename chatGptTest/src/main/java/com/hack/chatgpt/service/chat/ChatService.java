package com.hack.chatgpt.service.chat;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {

	@Value("${space.openai-key}")
	String openAIToken;
	private final ChatHistoryService chatHistoryService;


	public List<ChatCompletionChoice> chatWithDog(String prompt){
		OpenAiService openAiService = new OpenAiService(openAIToken, Duration.ofSeconds(15));

		final List<ChatMessage> messages = createDogChatMessage(prompt);
		List<ChatCompletionChoice> choices = callChatGpt(openAiService, messages);

		chatHistoryService.saveChatHistory(prompt, choices);
		log.info("chatWithDog result: {}", choices);
		return choices;
	}

	public List<ChatCompletionChoice> chatWithCounselor(String prompt){
		OpenAiService openAiService = new OpenAiService(openAIToken, Duration.ofSeconds(15));

		final List<ChatMessage> messages = createCounselorChatMessage(prompt);
		List<ChatCompletionChoice> choices = callChatGpt(openAiService, messages);

		chatHistoryService.saveChatHistory(prompt, choices);
		log.info("chatWithCounselor result: {}", choices);
		return choices;
	}

	private List<ChatCompletionChoice> callChatGpt(OpenAiService openAiService, List<ChatMessage> messages) {
		ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
			.builder()
			.model("gpt-3.5-turbo")
			.messages(messages)
			.n(1)
			.temperature(0.7)
			.topP(1.0)
			.maxTokens(512)
			.logitBias(new HashMap<>())
			.build();

		return openAiService.createChatCompletion(chatCompletionRequest).getChoices();
	}

	@NotNull
	private List<ChatMessage> createCounselorChatMessage(String prompt) {
		final List<ChatMessage> messages = new ArrayList<>();
		final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(),
			"You are a psychological counselor counseling a grieving patient who has lost a dog. Kindly reply in Korean");

		ChatMessage userMessage = new ChatMessage(ChatMessageRole.USER.value(), prompt);
		messages.add(systemMessage);
		messages.add(userMessage);

		log.info("chat message : {}", userMessage);
		return messages;
	}

	private List<ChatMessage> createDogChatMessage(String prompt) {
		final List<ChatMessage> messages = new ArrayList<>();
		final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(),
			"You are a dead puppy after spending a long time with your owner. Talk to me like a puppy missing its owner after death and answer me in Korean");

		ChatMessage userMessage = new ChatMessage(ChatMessageRole.USER.value(), prompt);
		messages.add(systemMessage);
		messages.add(userMessage);

		log.info("chat message : {}", userMessage);
		return messages;
	}

}
