package dev.practice.ad.domain.app;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class AppCommand {
    private final String appId;
    private final String appName;
//    private final String appKey;

    public App toEntity() {
        return App.builder()
                .appId(appId)
                .appName(appName)
                .build();
    }
}
