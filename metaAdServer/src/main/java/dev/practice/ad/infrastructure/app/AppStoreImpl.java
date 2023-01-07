package dev.practice.ad.infrastructure.app;

import dev.practice.ad.common.exception.InvalidParamException;
import dev.practice.ad.domain.app.App;
import dev.practice.ad.domain.app.AppInfo;
import dev.practice.ad.domain.app.AppStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppStoreImpl implements AppStore {

    private final AppRepository appRepository;

    @Override
    public App store(App app) {
        if (StringUtils.isEmpty(app.getAppId())) throw new InvalidParamException("app.getAppId()");
        if (app.getStatus() == null) throw new InvalidParamException("app.getStatus()");

        return appRepository.save(app);
    }

    @Override
    public List<AppInfo> listApp() {
        return appRepository.findAll().stream()
                .map(AppInfo::new)
                .collect(Collectors.toList());
    }

    @Override
    public App getAppById(Long id) {
        return appRepository.findById(id).get();

    }


}
