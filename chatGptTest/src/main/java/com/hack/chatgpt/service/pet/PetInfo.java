package com.hack.chatgpt.service.pet;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PetInfo {

	private long id;

	private String name;

	private LocalDateTime birthAt;

	public static PetInfo from(Pet pet){
		return PetInfo.builder()
			.id(pet.getId())
			.name(pet.getName())
			.birthAt(pet.getBirthAt())
			.build();
	}
}
