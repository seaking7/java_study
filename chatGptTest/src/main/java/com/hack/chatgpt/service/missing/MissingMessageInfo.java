package com.hack.chatgpt.service.missing;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MissingMessageInfo {

	private long id;

	private String name;

	private String title;

	private String contents;

	private String photoUrl;

	private LocalDateTime writeAt;

	public static MissingMessageInfo from(MissingMessage missingMessage) {
		return MissingMessageInfo.builder()
			.id(missingMessage.getId())
			.name(missingMessage.getName())
			.title(missingMessage.getTitle())
			.contents(missingMessage.getContents())
			.photoUrl(missingMessage.getPhotoUrl())
			.writeAt(missingMessage.getWriteAt())
			.build();
	}
}
