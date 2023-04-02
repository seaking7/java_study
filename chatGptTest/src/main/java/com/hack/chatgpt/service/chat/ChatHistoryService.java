package com.hack.chatgpt.service.chat;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.hack.chatgpt.config.auth.SessionUser;
import com.hack.chatgpt.repository.ChatHistoryRepository;
import com.theokanning.openai.completion.chat.ChatCompletionChoice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatHistoryService {

	private final ChatHistoryRepository chatHistoryRepository;
	private final HttpSession httpSession;

	public List<ChatHistoryInfo> chatHistoryInfos() {
		String email;
		SessionUser loginUser = (SessionUser)httpSession.getAttribute("login_user");
		if(Objects.isNull(loginUser)){
			email = "guest";
		} else {
			email = loginUser.getEmail();
		}
		List<ChatHistory> byEmail = chatHistoryRepository.findByEmail(email);
		return byEmail.stream().map(ChatHistoryInfo::from).collect(Collectors.toList());
	}

	public void saveChatHistory(String prompt, List<ChatCompletionChoice> choices) {
		String email;
		if(choices.size() == 1){
			SessionUser loginUser = (SessionUser)httpSession.getAttribute("login_user");
			if(Objects.isNull(loginUser)){
				email = "guest";
			} else {
				email = loginUser.getEmail();
			}
			ChatHistory chatHistory = new ChatHistory(email, prompt, choices.get(0).getMessage().getContent());
			chatHistoryRepository.save(chatHistory);
		}
	}
}
