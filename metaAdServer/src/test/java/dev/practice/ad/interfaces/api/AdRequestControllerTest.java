package dev.practice.ad.interfaces.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@DisplayName("Api 테스트")
@AutoConfigureMockMvc
@SpringBootTest
class AdRequestControllerTest {

    private final MockMvc mvc;

    AdRequestControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }


    @DisplayName("Init API 호출 테스트")
    @Test
    void getInitAd() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/meta/v1/init").queryParam("appId", "game1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string(containsString("measuringScreenAreaX")))
                .andExpect(content().string(containsString("viewableTimeImage")))
                .andExpect(content().string(containsString("pixelGrid")))
                .andExpect(xpath("/init/maxMeasuringCount/text()").string(equalTo("100")));

    }

    @DisplayName("Init API 호출 실패 테스트")
    @Test
    void getInitAdFailTest() throws Exception {

        // 필수필드 appId 누락시 500에러
        mvc.perform(MockMvcRequestBuilders.get("/meta/v1/init"))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }


    @DisplayName("Request API 호출 테스트")
    @Test
    void getRequestAd() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/meta/v1/request")
                        .queryParam("appId", "game1")
                        .queryParam("token", "erqwre")
                        .queryParam("duplicatedNum", "2")
                        .queryParam("adMediaType", "Image")
                        .queryParam("width", "700")
                        .queryParam("height", "900"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string(containsString("adsId")))
                .andExpect(content().string(containsString("adUrl")))
                .andExpect(content().string(containsString("adMediaType")))
                .andExpect(content().string(containsString("adsSeq")));
    }

    @DisplayName("Report API 호출 테스트")
    @Test
    void getReportAd() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/meta/v1/report")
                        .queryParam("appId", "game1")
                        .queryParam("adsId", "11008")
                        .queryParam("adsSeq", "20220728113900004")
                        .queryParam("adMediaType", "Image")
                        .queryParam("state", "노출")
                        .queryParam("playTime", "10"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
                .andExpect(content().string("OK"));
    }

}