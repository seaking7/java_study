package com.hack.chatgpt.service.missing;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hack.chatgpt.repository.MissingMessageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MissingMessageService {
	private final MissingMessageRepository missingMessageRepository;

	public List<MissingMessageInfo> getMissingMessageLists(){
		List<MissingMessage> missingMessageList = missingMessageRepository.findAll();
		return missingMessageList.stream().map(MissingMessageInfo::from).collect(Collectors.toList());

	}
}
