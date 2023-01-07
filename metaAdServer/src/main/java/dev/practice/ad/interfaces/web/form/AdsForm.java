package dev.practice.ad.interfaces.web.form;

import dev.practice.ad.domain.ads.AdsCommand;
import dev.practice.ad.domain.ads.AdsType;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AdsForm {
    private Long id;
    @NotNull
    private String adsId;
    private String adsName;
    @NotNull
    private String materialUrl;
    private Integer adsWidth;
    private Integer adsHeight;
    @NotNull
    private AdsType adsType;

    public AdsCommand toCommand(){
        return AdsCommand.builder()
                .id(id)
                .adsId(adsId)
                .adsName(adsName)
                .materialUrl(materialUrl)
                .adsWidth(adsWidth)
                .adsHeight(adsHeight)
                .adsType(adsType)
                .build();
    }
}
