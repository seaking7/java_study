package dev.practice.ad.domain.strategy;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class StrategyCommand {

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

    public Strategy toEntity() {
        return Strategy.builder()
                .measuringScreenAreaX(measuringScreenAreaX)
                .measuringScreenAreaY(measuringScreenAreaY)
                .measuringScreenAreaWidth(measuringScreenAreaWidth)
                .measuringScreenAreaHeight(measuringScreenAreaHeight)
                .maxMeasuringCount(maxMeasuringCount)
                .measuringInterval(measuringInterval)
                .waitingInterval(waitingInterval)
                .viewableTimeImage(viewableTimeImage)
                .viewableTimeVideo(viewableTimeVideo)
                .coolDownTime(coolDownTime)
                .viewingAngle(viewingAngle)
                .visibleArea(visibleArea)
                .pixelGrid(pixelGrid)
                .referenceScreenHandheldX(referenceScreenHandheldX)
                .referenceScreenHandheldY(referenceScreenHandheldY)
                .referenceScreenBigX(referenceScreenBigX)
                .referenceScreenBigY(referenceScreenBigY)
                .screenRelativeLength(screenRelativeLength)
                .build();
    }
}
