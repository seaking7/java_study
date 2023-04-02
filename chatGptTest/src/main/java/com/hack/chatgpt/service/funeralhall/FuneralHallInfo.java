package com.hack.chatgpt.service.funeralhall;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FuneralHallInfo {

	private long id;

	private String name;

	private String address;

	private String tel;

	private String onlineUrl;

	public static FuneralHallInfo from(FuneralHall funeralHall) {
		return FuneralHallInfo.builder()
			.id(funeralHall.getId())
			.name(funeralHall.getName())
			.address(funeralHall.getAddress())
			.tel(funeralHall.getTel())
			.onlineUrl(funeralHall.getOnlineUrl())
			.build();
	}
}
