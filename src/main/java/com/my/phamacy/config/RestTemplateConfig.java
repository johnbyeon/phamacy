package com.my.phamacy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
//스프링 시작할때 @configuration을 읽어서 Bean으로 등록해 놓는다.
public class RestTemplateConfig {

    @Bean
    //
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
