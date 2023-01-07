package dev.practice.ad.domain.api;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class AdInitCommand {
    private String appId;
    private String appKey;
    private String macAddress;
    private String uuid;

}
