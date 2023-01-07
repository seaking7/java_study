package dev.practice.ad.application.dto;

import dev.practice.ad.domain.ads.AdsType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AdRequestLog {
    private String requestTime;
    private String appId;
    private String adsId;
    private String adSeq;
    private String materialUrl;
    private String state;

    @Enumerated(EnumType.STRING)
    private AdsType adsType;

    private String ip;



}
