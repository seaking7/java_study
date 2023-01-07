package dev.practice.ad.application;

import com.google.gson.Gson;
import dev.practice.ad.application.dto.AdReportLog;
import dev.practice.ad.application.dto.AdRequestLog;
import dev.practice.ad.domain.api.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdRequestFacade {
    private final AdRequestService adRequestService;
    private Logger reportLogger = LoggerFactory.getLogger("accReportFile");

    public AdInitInfo fetchInit(AdInitCommand adInitCommand) {
        return adRequestService.processInit(adInitCommand);
    }

    public AdRequestInfo requestAd(AdRequestCommand adRequestCommand) {
        AdRequestInfo adRequestInfo = adRequestService.requestAd(adRequestCommand);
        writeLogRequestAd(adRequestCommand, adRequestInfo);
        return adRequestInfo;
    }

    public void reportAd(AdReportCommand adReportCommand) {
        Gson gson = new Gson();

        AdReportLog adReportLog = new AdReportLog();
        adReportLog.setAppId(adReportCommand.getAppId());
        adReportLog.setAdSeq(adReportCommand.getAdsSeq());
        adReportLog.setAdsId(adReportCommand.getAdsId());
        setLogState(adReportCommand, adReportLog);
        adReportLog.setAdsType(adReportCommand.getAdMediaType());
        adReportLog.setPlayTime(adReportCommand.getPlayTime());
        adReportLog.setIp(adReportCommand.getUserIp());
        adReportLog.setRequestTime(ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        reportLogger.info(gson.toJson(adReportLog));
    }

    private void setLogState(AdReportCommand adReportCommand, AdReportLog adReportLog) {
        switch (adReportCommand.getState()){
            case "Started" :
                adReportLog.setState("시청시작");
                break;
            case "Downloaded":
                adReportLog.setState("다운로드");
                break;
            case "Impression":
                adReportLog.setState("노출");
                break;
            case "Ended":
                adReportLog.setState("시청종료");
                break;
            default:
                adReportLog.setState(adReportCommand.getState());
                break;
        }
    }

    private void writeLogRequestAd(AdRequestCommand adRequestCommand, AdRequestInfo adRequestInfo) {
        Gson gson = new Gson();
        String[] split = adRequestInfo.getAdsSeq().split(",");
        for (String s : split) {
            AdRequestLog adRequestLog = new AdRequestLog();
            adRequestLog.setAdSeq(s);
            adRequestLog.setAppId(adRequestCommand.getAppId());
            adRequestLog.setAdsId(adRequestInfo.getAdsId());
            adRequestLog.setAdsType(adRequestInfo.getAdsType());
            adRequestLog.setState("요청");
            adRequestLog.setIp(adRequestCommand.getUserIp());
            adRequestLog.setRequestTime(ZonedDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
            reportLogger.info(gson.toJson(adRequestLog));
        }
    }
}
