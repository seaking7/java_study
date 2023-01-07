package dev.practice.ad.interfaces.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@Transactional   //@Test 에 선언시 rollback 처리됨
@AutoConfigureMockMvc
@SpringBootTest
class AdsControllerTest {

    private final MockMvc mvc;

    AdsControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }


    @DisplayName("[Web] Ads 리스트화면 테스트")
    @Test
    void listAdsTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/ads"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().string(containsString("타입")));
    }

    @DisplayName("[Web] Ads 신규 등록 테스트")
    @Test
    void insertAdsTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/ads/new")
                        .queryParam("adsId", "91001")
                        .queryParam("materialUrl", "http://test.com")
                        .queryParam("adsWidth", "100")
                        .queryParam("adsHeight", "200")
                        .queryParam("adsType", "Image"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().string(containsString("아이디를 입력하세요")));
    }

    @DisplayName("[Web] Ads 신규 등록 실패 테스트")
    @Test
    void insertAdsValidationTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/ads/new")
                .queryParam("adsId", "11001"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().string(containsString("입력값을 확인해주세요")));

    }
}