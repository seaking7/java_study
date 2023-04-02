package com.hack.chatgpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hack.chatgpt.service.funeralhall.FuneralHall;

public interface FuneralHallRepository extends JpaRepository<FuneralHall, Long> {
}
