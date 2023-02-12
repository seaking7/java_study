package dev.practice.ad.infrastructure.ads;

import dev.practice.ad.domain.ads.Ads;
import dev.practice.ad.domain.ads.AdsType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdsRepository extends JpaRepository<Ads, Long> {

    @Query("select m from Ads m where m.adsType = :adsType order by abs( m.adsWidth/m.adsHeight - :width / :height)")
    Iterable<Ads> findAdsByAdsTypeEquals(AdsType adsType, Integer width, Integer height);

    @Query("select m from Ads m where m.adsType = :adsType order by abs( m.adsWidth/m.adsHeight - :width / :height)")
    List<Ads> findFirstByAdsTypeEquals(AdsType adsType, Float width, Float height);

    @Query("select m from Ads m where m.adsType = :adsType and m.adsWidth/m.adsHeight in (select s.adsWidth/s.adsHeight from Ads s where s.adsId = :adsId)")
    List<Ads> findByAdsTypeEqualsMatchRatioAdsId(AdsType adsType, String adsId);

}
