package dev.practice.ad.domain.app;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppServiceImpl implements AppService {
    private final AppStore appStore;

    @Override
    @Transactional
    public AppInfo registerApp(AppCommand command) {
        var initApp = command.toEntity();
        App returnApp = appStore.store(initApp);
        return new AppInfo(returnApp);
    }

    @Override
    public List<AppInfo> listApp() {
        List<AppInfo> result = appStore.listApp();
        return result;
    }

    @Override
    public AppInfo getAppById(Long id) {
        App returnApp = appStore.getAppById(id);
        return new AppInfo(returnApp);
    }


}
