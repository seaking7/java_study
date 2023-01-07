package dev.practice.ad.domain.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@ToString
@XmlRootElement(name = "init")
@XmlAccessorType(XmlAccessType.FIELD)
public class AdInitInfo {
    @XmlElement
    private String uuid;
    private String token;
    @XmlElement
    private Integer measuringScreenAreaX;
    @XmlElement
    private Integer measuringScreenAreaY;
    @XmlElement
    private Integer measuringScreenAreaWidth;
    @XmlElement
    private Integer measuringScreenAreaHeight;
    @XmlElement
    private Integer maxMeasuringCount;
    @XmlElement
    private String measuringInterval;
    @XmlElement
    private String waitingInterval;
    @XmlElement
    private String viewableTimeImage;
    @XmlElement
    private String viewableTimeVideo;
    @XmlElement
    private Integer coolDownTime;
    @XmlElement
    private Integer viewingAngle;
    @XmlElement
    private String visibleArea;
    @XmlElement
    private String pixelGrid;
    @XmlElement
    private Integer referenceScreenHandheldX;
    @XmlElement
    private Integer referenceScreenHandheldY;
    @XmlElement
    private Integer referenceScreenBigX;
    @XmlElement
    private Integer referenceScreenBigY;
    @XmlElement
    private String screenRelativeLength;
    @XmlElement
    private String skewAngle;
}
