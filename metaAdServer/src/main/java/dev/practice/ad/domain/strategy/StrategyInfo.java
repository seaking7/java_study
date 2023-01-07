package dev.practice.ad.domain.strategy;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class StrategyInfo {
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
    private LocalDateTime updatedAt;

    public StrategyInfo(){
    }

    public StrategyInfo(Strategy strategy){
        this.measuringScreenAreaX = strategy.getMeasuringScreenAreaX();
        this.measuringScreenAreaY = strategy.getMeasuringScreenAreaY();
        this.measuringScreenAreaWidth = strategy.getMeasuringScreenAreaWidth();
        this.measuringScreenAreaHeight = strategy.getMeasuringScreenAreaHeight();
        this.maxMeasuringCount = strategy.getMaxMeasuringCount();
        this.measuringInterval = strategy.getMeasuringInterval();
        this.waitingInterval = strategy.getWaitingInterval();
        this.viewableTimeImage = strategy.getViewableTimeImage();
        this.viewableTimeVideo = strategy.getViewableTimeVideo();
        this.coolDownTime = strategy.getCoolDownTime();
        this.viewingAngle = strategy.getViewingAngle();
        this.visibleArea = strategy.getVisibleArea();
        this.pixelGrid = strategy.getPixelGrid();
        this.referenceScreenHandheldX = strategy.getReferenceScreenHandheldX();
        this.referenceScreenHandheldY = strategy.getReferenceScreenHandheldY();
        this.referenceScreenBigX = strategy.getReferenceScreenBigX();
        this.referenceScreenBigY = strategy.getReferenceScreenBigY();
        this.screenRelativeLength = strategy.getScreenRelativeLength();
        this.updatedAt = strategy.getUpdatedAt().toLocalDateTime();
    }

}
