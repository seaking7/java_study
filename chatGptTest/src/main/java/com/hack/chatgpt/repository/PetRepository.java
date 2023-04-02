package com.hack.chatgpt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hack.chatgpt.service.pet.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

	@Override
	List<Pet> findAll();
}
