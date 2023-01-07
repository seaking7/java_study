package dev.practice.ad.interfaces.api;

import dev.practice.ad.application.AdRequestFacade;
import dev.practice.ad.common.util.XmlGenerator;
import dev.practice.ad.domain.api.*;
import dev.practice.ad.interfaces.api.dto.AdInitDto;
import dev.practice.ad.interfaces.api.dto.AdReportDto;
import dev.practice.ad.interfaces.api.dto.AdRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/meta/v1")
public class AdRequestController {

    private final AdRequestFacade adRequestFacade;


    @GetMapping("/init")
    public String getInitAd(@ModelAttribute @Valid AdInitDto adInit) throws JAXBException {
        log.info("init appId:{}, appKey:{}, macAddress:{}, uuid:{}, sdkVersion:{}",
                adInit.getAppId(), adInit.getAppKey(), adInit.getMacAddress(), adInit.getUuid(), adInit.getSdkVersion());
        AdInitCommand adInitCommand = adInit.toCommand();

        AdInitInfo adInitInfo = adRequestFacade.fetchInit(adInitCommand);
        log.info("result === {}", adInitInfo.toString());

        return XmlGenerator.marshalObjectToXml(adInitInfo);
    }


    @GetMapping("/init3")
    public AdInitInfo getInitAd3(@ModelAttribute @Valid AdInitDto adInit) throws JAXBException {

        log.info("init appId:{}, appKey:{}, macAddress:{}, uuid:{}, sdkVersion:{}",
                adInit.getAppId(), adInit.getAppKey(), adInit.getMacAddress(), adInit.getUuid(), adInit.getSdkVersion());
        AdInitCommand adInitCommand = adInit.toCommand();

        AdInitInfo adInitInfo = adRequestFacade.fetchInit(adInitCommand);
        log.info("result === {}", adInitInfo.toString());

        return adInitInfo;
    }


    @GetMapping("/request")
    public String getRequestAd(@ModelAttribute("AdRequestDto") @Valid AdRequestDto adRequestDto, HttpServletRequest request ) throws JAXBException {
        log.info("request appId:{}, token:{}, width:{}, height:{} getDuplicatedNum:{}",
                adRequestDto.getAppId(), adRequestDto.getToken(), adRequestDto.getWidth(), adRequestDto.getHeight(), adRequestDto.getDuplicatedNum());
        adRequestDto.setUserIp(request.getRemoteAddr());
        AdRequestCommand adRequestCommand = adRequestDto.toCommand();

        AdRequestInfo adRequestInfo = adRequestFacade.requestAd(adRequestCommand);
        log.info("result === {}", adRequestInfo.toString());
        return XmlGenerator.marshalObjectToXml(adRequestInfo);
    }


        @GetMapping("/report")
    public String getReportAd(@ModelAttribute("AdReportDto") @Valid AdReportDto report, HttpServletRequest request){
        log.info("report adsId:{}, adsSeq:{}, state:{} userIp:{} playTime:{}, ip:{}",
                report.getAdsId(), report.getAdsSeq(), report.getState(), report.getUserIp(), report.getPlayTime(), request.getRemoteAddr());
        report.setUserIp(request.getRemoteAddr());
        AdReportCommand adReportCommand = report.toCommand();
        adRequestFacade.reportAd(adReportCommand);

        String returnStr = "OK";
        return returnStr;
    }

    @GetMapping("/test")
    public void testHeader(@RequestHeader Map<String, Object> requestHeader){
        log.info(requestHeader.toString());
    }

}
