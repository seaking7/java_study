package dev.practice.ad.domain.app;


import java.util.List;

public interface AppStore {
    App store(App initApp);

    List<AppInfo> listApp();


    App getAppById(Long id);
}
