package dev.practice.ad.interfaces.api.dto;

import dev.practice.ad.domain.api.AdReportCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class AdReportDto {

    @NotEmpty(message = "appId 는 필수값입니다")
    private String appId;

    @NotEmpty(message = "adsId 는 필수값입니다")
    private String adsId;

    @NotEmpty(message = "adsSeq 는 필수값입니다")
    private String adsSeq;
    private String state;
    private String adMediaType;
    private String playTime;
    private String userIp;


    public AdReportCommand toCommand() {
        return AdReportCommand.builder()
                .appId(appId)
                .adsId(adsId)
                .adsSeq(adsSeq)
                .state(state)
                .adMediaType(adMediaType)
                .playTime(playTime)
                .userIp(userIp)
                .build();
    }
}
