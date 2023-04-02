package com.hack.chatgpt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hack.chatgpt.service.chat.ChatHistory;

public interface ChatHistoryRepository extends JpaRepository<ChatHistory, Long> {

	List<ChatHistory> findByEmail(String email);
}
