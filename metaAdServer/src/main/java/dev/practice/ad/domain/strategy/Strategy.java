package dev.practice.ad.domain.strategy;

import dev.practice.ad.domain.AbstractEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "m_strategy")
public class Strategy extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer measuringScreenAreaX;
    private Integer measuringScreenAreaY;
    private Integer measuringScreenAreaWidth;
    private Integer measuringScreenAreaHeight;
    private Integer maxMeasuringCount;
    private String measuringInterval;
    private String waitingInterval;
    private String viewableTimeImage;
    private String viewableTimeVideo;
    private Integer coolDownTime;
    private Integer viewingAngle;
    private String visibleArea;
    private String pixelGrid;
    private Integer referenceScreenHandheldX;
    private Integer referenceScreenHandheldY;
    private Integer referenceScreenBigX;
    private Integer referenceScreenBigY;
    private String screenRelativeLength;

    @Builder
    public Strategy(Integer measuringScreenAreaX, Integer measuringScreenAreaY,
                    Integer measuringScreenAreaWidth, Integer measuringScreenAreaHeight,
                    Integer maxMeasuringCount, String measuringInterval, String waitingInterval,
                    String viewableTimeImage, String viewableTimeVideo,
                    Integer coolDownTime, Integer viewingAngle,
                    String visibleArea, String pixelGrid, Integer referenceScreenHandheldX, Integer referenceScreenHandheldY,
                    Integer referenceScreenBigX, Integer referenceScreenBigY, String screenRelativeLength) {
//        if (StringUtils.isEmpty(appId)) throw new InvalidParamException("empty appId");
        this.measuringScreenAreaX = measuringScreenAreaX;
        this.measuringScreenAreaY = measuringScreenAreaY;
        this.measuringScreenAreaWidth = measuringScreenAreaWidth;
        this.measuringScreenAreaHeight = measuringScreenAreaHeight;
        this.maxMeasuringCount = maxMeasuringCount;
        this.measuringInterval = measuringInterval;
        this.waitingInterval = waitingInterval;
        this.viewableTimeImage = viewableTimeImage;
        this.viewableTimeVideo = viewableTimeVideo;
        this.coolDownTime = coolDownTime;
        this.viewingAngle = viewingAngle;
        this.visibleArea = visibleArea;
        this.pixelGrid = pixelGrid;
        this.referenceScreenHandheldX = referenceScreenHandheldX;
        this.referenceScreenHandheldY = referenceScreenHandheldY;
        this.referenceScreenBigX = referenceScreenBigX;
        this.referenceScreenBigY = referenceScreenBigY;
        this.screenRelativeLength = screenRelativeLength;
    }
}
