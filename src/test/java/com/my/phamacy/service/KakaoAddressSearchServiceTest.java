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


}