package dev.practice.ad.domain.ads;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class AdsCommand {
    private final Long id;
    private final String adsId;
    private final String adsName;
    private final String materialUrl;
    private final Integer adsWidth;
    private final Integer adsHeight;
    private final AdsType adsType;

    public Ads toEntity() {
        return Ads.builder()
                .adsId(adsId)
                .adsName(adsName)
                .materialUrl(materialUrl)
                .adsWidth(adsWidth)
                .adsHeight(adsHeight)
                .adsType(adsType)
                .build();
    }
}
