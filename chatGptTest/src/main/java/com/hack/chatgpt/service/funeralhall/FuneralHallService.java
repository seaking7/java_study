package com.hack.chatgpt.service.funeralhall;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hack.chatgpt.repository.FuneralHallRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuneralHallService {
	private final FuneralHallRepository funeralHallRepository;

	public List<FuneralHallInfo> getFuneralHallList(){
		List<FuneralHall> funeralHallList = funeralHallRepository.findAll();
		return funeralHallList.stream().map(FuneralHallInfo::from).collect(Collectors.toList());

	}
}
