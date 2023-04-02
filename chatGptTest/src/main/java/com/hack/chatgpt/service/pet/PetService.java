package com.hack.chatgpt.service.pet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hack.chatgpt.repository.PetRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetService {
	private final PetRepository petRepository;

	public List<PetInfo> getPetInfo(){
		List<PetInfo> petInfoList = new ArrayList<>();
		List<Pet> petList = petRepository.findAll();
		for (Pet pet : petList) {
			petInfoList.add(PetInfo.from(pet));
		}

		return petInfoList;

	}
}
