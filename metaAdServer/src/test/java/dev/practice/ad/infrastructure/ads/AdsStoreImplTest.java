package dev.practice.ad.infrastructure.ads;

import dev.practice.ad.domain.ads.Ads;
import dev.practice.ad.domain.ads.AdsInfo;
import dev.practice.ad.domain.ads.AdsStore;
import dev.practice.ad.domain.ads.AdsType;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class AdsStoreImplTest {

    @Autowired
    AdsStore adsStore;

    @Test
    void store() {
        //given
        Ads test_ad = Ads.builder()
                .adsId("91001")
                .adsName("test ad_name")
                .adsType(AdsType.Image)
                .materialUrl("http://test.com/12345")
                .adsWidth(300)
                .adsHeight(200)
                .build();
        //when
        Ads savedAds = adsStore.store(test_ad);
        //then
        Ads findAds = adsStore.getAdsById(test_ad.getId());
        assertThat(findAds.getAdsName()).isEqualTo(savedAds.getAdsName());
        assertThat(findAds.getMaterialUrl()).isEqualTo(savedAds.getMaterialUrl());
    }

    @Test
    void listAds() {
        List<AdsInfo> adsInfos = adsStore.listAds();

        assertThat(adsInfos.size()).isEqualTo(9);
        for (AdsInfo adsInfo : adsInfos) {
            if(adsInfo.getAdsId().equals("11001"))
                assertThat(adsInfo.getAdsWidth()).isEqualTo(700);
        }

    }

    @Test
    void getAdsById() {
        Ads findAds = adsStore.getAdsById(9l);

        assertThat(findAds.getAdsId()).isEqualTo("11001");
        assertThat(findAds.getAdsWidth()).isEqualTo(700);
        assertThat(findAds.getAdsHeight()).isEqualTo(965);
    }

    @Test
    void deleteById() {
        //when
        adsStore.deleteById(9l);
        //then
        Assertions.assertThatThrownBy(
                () -> adsStore.getAdsById(9l)
        ).isInstanceOf(NoSuchElementException.class).hasMessageContaining("No value");
    }

    @Test
    void findAdsByRatio() {
    }

    @Test
    void updateAds() {
    }
}