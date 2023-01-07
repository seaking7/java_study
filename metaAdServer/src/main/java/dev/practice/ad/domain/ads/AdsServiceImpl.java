package dev.practice.ad.domain.ads;

import dev.practice.ad.domain.app.AppInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdsServiceImpl implements AdsService {
    private final AdsStore adsStore;

    @Override
    @Transactional
    public AdsInfo registerAds(AdsCommand command) {
        var initAdRequest = command.toEntity();
        Ads adRequest = adsStore.store(initAdRequest);
        return new AdsInfo(adRequest);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdsInfo> listAds() {
        return adsStore.listAds();
    }

    @Override
    public AdsInfo getAdsById(Long id) {
        Ads adsById = adsStore.getAdsById(id);
        return new AdsInfo(adsById);
    }

    @Override
    public void deleteById(Long id) {
        adsStore.deleteById(id);
    }

    @Override
    public AdsInfo updateAds(AdsCommand adsCommand) {
        Ads ads = adsStore.updateAds(adsCommand);
        return new AdsInfo(ads);

    }

}
