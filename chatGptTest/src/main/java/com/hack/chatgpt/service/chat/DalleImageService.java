package com.hack.chatgpt.service.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.image.Image;
import com.theokanning.openai.service.OpenAiService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class DalleImageService {

	@Value("${space.openai-key}")
	String openAIToken;
	private final TranslationService translationService;

	public List<Image> createImage(String prompt){
		OpenAiService openAiService = new OpenAiService(openAIToken);
		String message = translationService.translate(prompt);
		CreateImageRequest createImageRequest = CreateImageRequest.builder()
			.prompt(message)
			.n(3)
			.size("256x256")
			.user("testing")
			.build();

		List<Image> images = openAiService.createImage(createImageRequest).getData();
		log.info("createImage result: {}", images);
		return images;
	}

}
