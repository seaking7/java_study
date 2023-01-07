package dev.practice.ad.application;

import dev.practice.ad.domain.strategy.StrategyCommand;
import dev.practice.ad.domain.strategy.StrategyInfo;
import dev.practice.ad.domain.strategy.StrategyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StrategyFacade {
    private final StrategyService strategyService;
public StrategyInfo storeStrategy(StrategyCommand command) {
        var strategyInfo = strategyService.storeStrategy(command);
        return strategyInfo;
    }

    public StrategyInfo listStrategy(){
        return strategyService.listStrategy();
    }

}
