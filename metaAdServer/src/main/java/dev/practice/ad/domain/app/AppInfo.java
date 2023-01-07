package dev.practice.ad.domain.app;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class AppInfo {
    private final Long id;
    private final String appId;
    private final String appName;
    private final String appKey;
    private final String status;
    private final LocalDateTime created_at;


    public AppInfo(App app){
        this.id = app.getId();
        this.appId = app.getAppId();
        this.appName = app.getAppName();
        this.appKey = app.getAppKey();
        this.status = app.getStatus().getDescription();
        this.created_at = app.getCreatedAt().toLocalDateTime();
    }

}
