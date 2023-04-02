package com.hack.chatgpt.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hack.chatgpt.common.exception.NotFoundException;
import com.hack.chatgpt.service.chat.ChatHistoryService;
import com.hack.chatgpt.service.chat.ChatService;
import com.hack.chatgpt.service.chat.CompletionService;
import com.hack.chatgpt.service.chat.DalleImageService;
import com.hack.chatgpt.service.chat.ChatHistoryInfo;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.image.Image;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/api/chat")
public class ChatController {

	private final ChatService chatService;
	private final ChatHistoryService chatHistoryService;
	private final CompletionService completionService;
	private final DalleImageService dalleImageService;
	@Operation(summary = "chatGpt 텍스트 생성", description = "텍스트 생성 with text-davinci-003")
	@GetMapping("/completion")
	public List<CompletionChoice> translate(@RequestParam String question){
		List<CompletionChoice> openInfo = completionService.getCompletion(question);
		if(openInfo == null || openInfo.size() == 0 ){
			throw new NotFoundException();
		}
		return openInfo;
	}

	@Operation(summary = "반려동물과 채팅", description = "반려동물과 채팅 응답 with gpt-3.5-turbo")
	@GetMapping("/question")
	public List<ChatCompletionChoice> chatWithDog(@RequestParam String question){
		List<ChatCompletionChoice> openInfo = chatService.chatWithDog(question);
		if(openInfo == null || openInfo.size() == 0 ){
			throw new NotFoundException();
		}
		return openInfo;
	}

	@Operation(summary = "상담사와 채팅", description = "상담사와 채팅 응답 with gpt-3.5-turbo")
	@GetMapping("/questionCounselor")
	public List<ChatCompletionChoice> chatWithCounselor(@RequestParam String question){
		List<ChatCompletionChoice> openInfo = chatService.chatWithCounselor(question);
		if(openInfo == null || openInfo.size() == 0 ){
			throw new NotFoundException();
		}
		return openInfo;
	}

	@Operation(summary = "채팅이력 조회", description = "로그인 사용자는 본인의 채팅이력, 비로그인자는 guest 채팅이력")
	@GetMapping("/chat-history")
	public List<ChatHistoryInfo> chatHistoryInfos(){
		List<ChatHistoryInfo> openInfo = chatHistoryService.chatHistoryInfos();
		if(openInfo == null || openInfo.size() == 0 ){
			throw new NotFoundException();
		}
		return openInfo;
	}


	@Operation(summary = "달리 이미지 생성", description = "keyword에 맞는 이미지 생성테스트 용")
	@GetMapping("/createImage")
	public List<Image> createImage(@RequestParam String question){
		List<Image> openInfo = dalleImageService.createImage(question);
		if(openInfo == null || openInfo.size() == 0 ){
			throw new NotFoundException();
		}
		return openInfo;
	}

}
