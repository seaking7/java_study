package dev.practice.ad.interfaces.web;

import dev.practice.ad.application.StrategyFacade;
import dev.practice.ad.domain.strategy.StrategyCommand;
import dev.practice.ad.domain.strategy.StrategyInfo;
import dev.practice.ad.interfaces.web.form.AdsForm;
import dev.practice.ad.interfaces.web.form.StrategyForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/strategy")
public class StrategyController {

    private final StrategyFacade strategyFacade;


    @GetMapping
    public String viewStoreStrategy(Model model){
        StrategyInfo strategyInfo = strategyFacade.listStrategy();;

        model.addAttribute("strategyInfo", strategyInfo);
        return "strategy/manageStrategy";
    }

    @GetMapping("/guide")
    public String guideStrategy(Model model){
        return "strategy/guideStrategy";
    }

    @PostMapping
    public String storeStrategy(StrategyForm form, Model model){

        log.info("{storeStrategy} getMeasuringScreenAreaX: "+ form.getMeasuringScreenAreaX());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        StrategyCommand strategyCommand = form.toCommand();
        log.info("appCommand {}", strategyCommand);
        StrategyInfo strategyInfo = strategyFacade.storeStrategy(strategyCommand);

        model.addAttribute("strategyInfo", strategyInfo);

        return "strategy/manageStrategy";
    }


}
