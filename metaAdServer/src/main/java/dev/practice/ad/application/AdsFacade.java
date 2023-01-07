package dev.practice.ad.application;

import dev.practice.ad.domain.app.AppInfo;
import dev.practice.ad.domain.notification.NotificationService;
import dev.practice.ad.domain.ads.AdsCommand;
import dev.practice.ad.domain.ads.AdsInfo;
import dev.practice.ad.domain.ads.AdsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdsFacade {
    private final AdsService adsService;

    public AdsInfo registerAds(AdsCommand command) {
        var adsInfo = adsService.registerAds(command);
        return adsInfo;
    }

    public List<AdsInfo> listAds(){
        List<AdsInfo> result = adsService.listAds();
        return result;
    }

    public AdsInfo getAdsById(Long id) {
        return adsService.getAdsById(id);
    }

    public void deleteById(Long id) {
        adsService.deleteById(id);
    }

    public AdsInfo updateAds(AdsCommand adsCommand) {
        return adsService.updateAds(adsCommand);
    }
}
