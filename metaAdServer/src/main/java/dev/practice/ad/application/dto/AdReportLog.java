package dev.practice.ad.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AdReportLog {
    private String requestTime;
    private String appId;
    private String adsId;
    private String adSeq;
    private String state;
    private String adsType;
    private String playTime;
    private String ip;


}
