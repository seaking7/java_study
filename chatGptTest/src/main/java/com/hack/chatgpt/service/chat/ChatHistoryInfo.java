package com.hack.chatgpt.service.chat;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChatHistoryInfo {

	private long id;

	private String email;

	private String chatMessage;

	private String replyMessage;

	private LocalDateTime chatAt;

	public static ChatHistoryInfo from(ChatHistory chatHistory) {
		return ChatHistoryInfo.builder()
			.email(chatHistory.getEmail())
			.chatMessage(chatHistory.getChatMessage())
			.replyMessage(chatHistory.getReplyMessage())
			.chatAt(chatHistory.getChatAt())
			.build();
	}
}
