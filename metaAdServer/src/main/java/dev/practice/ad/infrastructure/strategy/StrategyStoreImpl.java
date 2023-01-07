package dev.practice.ad.infrastructure.strategy;

import dev.practice.ad.domain.strategy.Strategy;
import dev.practice.ad.domain.strategy.StrategyInfo;
import dev.practice.ad.domain.strategy.StrategyStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Slf4j
@Component
@RequiredArgsConstructor
public class StrategyStoreImpl implements StrategyStore {

    private final StrategyRepository strategyRepository;


    @Override
    public Strategy upsert(Strategy strategy) {
//        if (StringUtils.isEmpty(app.getAppId())) throw new InvalidParamException("app.getAppId()");
//        if (app.getStatus() == null) throw new InvalidParamException("app.getStatus()");
        Strategy saved = strategyRepository.findAll().stream().findFirst().orElse(new Strategy());
        saved.setMeasuringScreenAreaX(strategy.getMeasuringScreenAreaX());
        saved.setMeasuringScreenAreaY(strategy.getMeasuringScreenAreaY());
        saved.setMeasuringScreenAreaWidth(strategy.getMeasuringScreenAreaWidth());
        saved.setMeasuringScreenAreaHeight(strategy.getMeasuringScreenAreaHeight());
        saved.setMaxMeasuringCount(strategy.getMaxMeasuringCount());
        saved.setMeasuringInterval(strategy.getMeasuringInterval());
        saved.setWaitingInterval(strategy.getWaitingInterval());
        saved.setViewableTimeImage(strategy.getViewableTimeImage());
        saved.setViewableTimeVideo(strategy.getViewableTimeVideo());
        saved.setCoolDownTime(strategy.getCoolDownTime());
        saved.setViewingAngle(strategy.getViewingAngle());
        saved.setVisibleArea(strategy.getVisibleArea());
        saved.setPixelGrid(strategy.getPixelGrid());
        saved.setReferenceScreenHandheldX(strategy.getReferenceScreenHandheldX());
        saved.setReferenceScreenHandheldY(strategy.getReferenceScreenHandheldY());
        saved.setReferenceScreenBigX(strategy.getReferenceScreenBigX());
        saved.setReferenceScreenBigY(strategy.getReferenceScreenBigY());
        saved.setScreenRelativeLength(strategy.getScreenRelativeLength());

        return strategyRepository.save(saved);
    }

    @Override
    public StrategyInfo listStrategy() {
        return strategyRepository.findAll()
                .stream()
                .map(StrategyInfo::new)
                .findFirst().orElse(new StrategyInfo());


    }
}
