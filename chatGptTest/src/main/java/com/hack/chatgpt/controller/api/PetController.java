package com.hack.chatgpt.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hack.chatgpt.common.exception.NotFoundException;
import com.hack.chatgpt.service.pet.PetService;
import com.hack.chatgpt.service.pet.PetInfo;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/pet")
@Tag(name = "Pet API", description = "Pet 관련 API 입니다.")
public class PetController {

	private final PetService petService;


	@GetMapping("/pet")
	public List<PetInfo> getPetInfo(){
		List<PetInfo> petInfo = petService.getPetInfo();
		if(petInfo == null || petInfo.size() == 0 ){
			throw new NotFoundException();
		}
		return petInfo;
	}


}
