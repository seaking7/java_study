package dev.practice.ad.interfaces.web;

import dev.practice.ad.application.AdsFacade;
import dev.practice.ad.domain.ads.Ads;
import dev.practice.ad.domain.ads.AdsCommand;
import dev.practice.ad.domain.ads.AdsInfo;
import dev.practice.ad.domain.ads.AdsType;
import dev.practice.ad.domain.app.AppCommand;
import dev.practice.ad.domain.app.AppInfo;
import dev.practice.ad.interfaces.web.form.AdsForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/ads")
public class AdsController {

    private final AdsFacade adsFacade;

    @ModelAttribute("adsTypes")
    public AdsType[] apsTypes(){
        return AdsType.values();
    }

    @GetMapping
    public String listAds(Model model){
        log.info("{listAds} list ads ");
        List<AdsInfo> result = adsFacade.listAds();
        for (AdsInfo adsInfo : result) {
            log.info(adsInfo.toString());
        }
        model.addAttribute("ads", result);
        return "ads/listAds";
    }

    @GetMapping("/new")
    public String viewInsertApp(Model model){
        model.addAttribute("ads", new AdsForm());
        return "ads/createAdsForm";
    }


    @PostMapping("/new")
    public String insertAds(@Validated @ModelAttribute("ads") AdsForm form, BindingResult bindingResult, Model model){
        log.info("{insertAds} getAdsId: {} {}", form.getAdsId(), form.getAdsType());

        if(bindingResult.hasErrors()){
            log.info("error={}", bindingResult);
            model.addAttribute("error_msg", "입력값을 확인해주세요");
            return "ads/createAdsForm";
        }

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        AdsCommand adsCommand = form.toCommand();
        log.info("appCommand {}", adsCommand);
        adsFacade.registerAds(adsCommand);

        return "ads/createAdsForm";
    }


    @GetMapping("/{id}")
    public String detailAds(@PathVariable Long id, Model model){
        AdsInfo result = adsFacade.getAdsById(id);

        model.addAttribute("ads", result);
        return "ads/detailAds";
    }

    @PostMapping("/delete")
    public String deleteAds(@ModelAttribute("ads") AdsForm form, Model model){

        log.info("deleteAds :{}", form.getId());
        adsFacade.deleteById(form.getId());

        model.addAttribute("ads", new AdsForm());
        return "redirect:/ads";
    }

    @PostMapping("/update")
    public String updateAds(@Validated @ModelAttribute("ads") AdsForm form, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            log.info("error={}", bindingResult);
            model.addAttribute("error_msg", "입력값을 확인해주세요");
            return "ads/detailAds";
        }

        log.info("updateAds :{}", form.getId());
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        AdsCommand adsCommand = form.toCommand();
        log.info("appCommand {}", adsCommand);
        AdsInfo result = adsFacade.updateAds(adsCommand);
        model.addAttribute("ads", result);

        return "ads/detailAds";
    }
}
