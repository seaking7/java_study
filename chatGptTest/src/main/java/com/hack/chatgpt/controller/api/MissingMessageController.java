package com.hack.chatgpt.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hack.chatgpt.service.missing.MissingMessageInfo;
import com.hack.chatgpt.service.missing.MissingMessageService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/missing")
public class MissingMessageController {

	private final MissingMessageService missingMessageService;

	@Operation(summary = "추모게시판 리스트", description = "추모게시판 리스트 전체 조회")
	@GetMapping("/list")
	public List<MissingMessageInfo> getMissingMessage(){
		return missingMessageService.getMissingMessageLists();
	}
}
