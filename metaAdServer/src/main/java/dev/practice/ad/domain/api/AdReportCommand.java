package dev.practice.ad.domain.api;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class AdReportCommand {
    private String appId;
    private String adsId;
    private String adsSeq;
    private String state;
    private String adMediaType;
    private String playTime;
    private String userIp;

}
