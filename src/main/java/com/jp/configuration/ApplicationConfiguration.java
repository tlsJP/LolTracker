package com.jp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by JP on 9/3/2017.
 */
@Configuration
public class ApplicationConfiguration {


    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
