package dev.practice.ad.domain.app;

import java.util.List;

public interface AppService {
    AppInfo registerApp(AppCommand command);

    List<AppInfo> listApp();

    AppInfo getAppById(Long id);
}
