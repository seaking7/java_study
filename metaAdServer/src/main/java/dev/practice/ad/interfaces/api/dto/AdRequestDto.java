package dev.practice.ad.interfaces.api.dto;

import dev.practice.ad.domain.ads.AdsType;
import dev.practice.ad.domain.api.AdRequestCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class AdRequestDto {
    @NotEmpty(message = "appId 는 필수값입니다")
    private String appId;
    @NotEmpty(message = "token 는 필수값입니다")
    private String token;
    private String tag;
    private String adRole;
    @NotNull
    private String duplicatedNum;
    @NotNull
    private String adMediaType;
    private String unit;
    private Float width;
    private Float height;
    private String userIp;
    private String sdkVersion;

        public AdRequestCommand toCommand() {
            return AdRequestCommand.builder()
                    .appId(appId)
                    .token(token)
                    .tag(tag)
                    .adRole(adRole)
                    .duplicatedNum(Integer.valueOf(duplicatedNum))
                    .adsType(AdsType.valueOf(adMediaType))
                    .unit(unit)
                    .width(width)
                    .height(height)
                    .userIp(userIp)
                    .build();
        }

}
