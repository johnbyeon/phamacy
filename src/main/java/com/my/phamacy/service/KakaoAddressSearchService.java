package com.my.phamacy.service;


import com.my.phamacy.dto.KakaoApiResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
@RequiredArgsConstructor
public class KakaoAddressSearchService {
    private final RestTemplate restTemplate;
    @Value("${KAKAO_REST_API_KEY}")
    private String kakaoRestApiKey;

    public void apiKeyTest(){
        log.info("========== KaKao API Key : {}",kakaoRestApiKey);
    }

    private static final String KAKAO_LOCAL_URL =
            "https://dapi.kakao.com/v2/local/search/address.json";

    public KakaoApiResponseDto requestAddressSearch(String address){
        //검색받은 주소가 비어있는경우
        if(ObjectUtils.isEmpty(address)){ return null;}

        UriComponentsBuilder uriBuilder = UriComponentsBuilder
                                                .fromUriString(KAKAO_LOCAL_URL);

        uriBuilder.queryParam("query",address);
        //해석불가능한 UTF-8 -> 인코딩
        URI uri = uriBuilder.build().encode().toUri();
        log.info("address : {}, uri : {}",address,uri);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION,"KakaoAK " + kakaoRestApiKey);
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);

        //카카오 api 호출
        return restTemplate.exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                KakaoApiResponseDto.class
        ).getBody();
    }

}
