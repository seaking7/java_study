package com.hack.chatgpt.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hack.chatgpt.service.funeralhall.FuneralHallService;
import com.hack.chatgpt.service.funeralhall.FuneralHallInfo;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/funeral")
public class FuneralHallController {

	private final FuneralHallService funeralHallService;

	@Operation(summary = "반려동물 장례식장 리스트", description = "장례식장 리스트 전체 조회")
	@GetMapping("/list")
	public List<FuneralHallInfo> getPetInfo(){
		return funeralHallService.getFuneralHallList();
	}
}
