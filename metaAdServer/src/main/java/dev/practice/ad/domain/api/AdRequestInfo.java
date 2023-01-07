package dev.practice.ad.domain.api;

import dev.practice.ad.domain.ads.AdsType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@ToString
@XmlRootElement(name = "adsInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class AdRequestInfo {
    @XmlElement (name = "adsId")
    private String adsId;
    @XmlElement (name = "adUrl")
    private String materialUrl;

    @XmlElement (name = "adMediaType")
    @Enumerated(EnumType.STRING)
    private AdsType adsType;

    @XmlElement (name = "adsSeq")
    private String adsSeq;

}
