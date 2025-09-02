package com.my.phamacy.service;

import com.my.phamacy.dto.KakaoApiResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class KakaoAddressSearchServiceTest {
    @Autowired
    KakaoAddressSearchService kakaoaddressSearchService;

    @Autowired
    KakaoCategorySearchService kakaoCategorySearchService;
    @Test
    @DisplayName("API KEY TEST")
    void Test(){
        kakaoaddressSearchService.apiKeyTest();
    }

    @Test
    @DisplayName("URI String TEST")
    void uriTest(){
       KakaoApiResponseDto dto = new KakaoApiResponseDto();
             dto =  kakaoaddressSearchService.requestAddressSearch("강남대로 450");
        System.out.println(dto.toString());
    }

    @Test
    @DisplayName("Search Category Test")
    void category(){
        KakaoApiResponseDto dto= new KakaoApiResponseDto();
        double x = 127.026692446306;
        double y = 37.4987750083767;
        double radius = 1000;
        dto = kakaoCategorySearchService.resultCategorySearch(x,y,radius);
        System.out.println(dto);
    }


}