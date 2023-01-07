package dev.practice.ad.infrastructure.strategy;

import dev.practice.ad.domain.strategy.Strategy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StrategyRepository extends JpaRepository<Strategy, Long> {

}
