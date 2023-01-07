package dev.practice.ad.domain.strategy;


import java.util.List;
import java.util.Optional;

public interface StrategyService {
    StrategyInfo storeStrategy(StrategyCommand command);

    StrategyInfo listStrategy();
}
