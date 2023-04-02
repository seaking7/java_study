package com.hack.chatgpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hack.chatgpt.service.missing.MissingMessage;

public interface MissingMessageRepository extends JpaRepository<MissingMessage, Long> {
}
