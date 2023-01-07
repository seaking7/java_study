package dev.practice.ad.domain.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StrategyServiceImpl implements StrategyService {

    private final StrategyStore strategyStore;

    @Override
    public StrategyInfo storeStrategy(StrategyCommand command) {
        var strategy = command.toEntity();
        Strategy returnStrategy = strategyStore.upsert(strategy);
        return new StrategyInfo(returnStrategy);
    }

    @Override
    public StrategyInfo listStrategy() {
        return strategyStore.listStrategy();

    }

}
