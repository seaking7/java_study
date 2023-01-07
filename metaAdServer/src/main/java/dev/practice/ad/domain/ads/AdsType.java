package dev.practice.ad.domain.ads;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum AdsType {
    Image("이미지"), Video("동영상");
    private final String description;

//    private static final Map<String, AdsType> BY_LABEL = Stream.of(values()).collect(Collectors.toMap((AdsType::)))
}
