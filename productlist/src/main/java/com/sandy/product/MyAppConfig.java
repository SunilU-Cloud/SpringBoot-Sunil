package com.sandy.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    @Bean
    public ThirdPartyService thirdPartyService(){
        return new ThirdPartyService();
    }
}
