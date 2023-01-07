package dev.practice.ad.interfaces.web.form;

import dev.practice.ad.domain.app.AppCommand;
import lombok.Data;

@Data
public class AppForm {
    private String appId;
    private String appName;

    public AppCommand toCommand(){
        return AppCommand.builder()
                .appId(appId)
                .appName(appName)
                .build();
    }
}
