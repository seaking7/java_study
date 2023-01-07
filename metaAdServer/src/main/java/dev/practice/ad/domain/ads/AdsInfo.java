package dev.practice.ad.domain.ads;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AdsInfo {
    private final Long id;
    private String adsId;
    private String adsName;
    private String materialUrl;
    private Integer adsWidth;
    private Integer adsHeight;
    private AdsType adsType;
    private String status;
    private LocalDateTime updatedAt;

    public AdsInfo(Ads adRequest) {
        this.id = adRequest.getId();
        this.adsId = adRequest.getAdsId();
        this.adsName = adRequest.getAdsName();
        this.materialUrl = adRequest.getMaterialUrl();
        this.adsWidth = adRequest.getAdsWidth();
        this.adsHeight = adRequest.getAdsHeight();
        this.adsType = adRequest.getAdsType();
        this.status = adRequest.getStatus().getDescription();
        this.updatedAt = adRequest.getUpdatedAt().toLocalDateTime();
    }
}
