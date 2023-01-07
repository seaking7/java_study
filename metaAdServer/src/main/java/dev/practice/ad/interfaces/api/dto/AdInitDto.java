package dev.practice.ad.interfaces.api.dto;

import dev.practice.ad.domain.api.AdInitCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
public class AdInitDto {
    @NotEmpty(message = "appId 는 필수값입니다")
    private String appId;
    private String appKey;
    private String macAddress;
    private String uuid;
    private String sdkVersion;

    public AdInitCommand toCommand() {
        return AdInitCommand.builder()
                .appId(appId)
                .appKey(appKey)
                .macAddress(macAddress)
                .uuid(uuid)
                .build();
    }
}

