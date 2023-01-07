package dev.practice.ad.domain.api;

import dev.practice.ad.domain.ads.AdsType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class AdRequestCommand {
    private String appId;
    private String token;
    private String tag;
    private String adRole;
    private Integer duplicatedNum;
    private AdsType adsType;
    private String unit;
    private Float width;
    private Float height;
    private String userIp;
    private String sdkVersion;

}
