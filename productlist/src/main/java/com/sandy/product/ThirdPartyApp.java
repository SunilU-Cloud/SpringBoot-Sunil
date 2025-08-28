package com.sandy.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThirdPartyApp {

    private ThirdPartyService thirdPartyService;

    @Autowired
    public ThirdPartyApp(ThirdPartyService thirdPartyService){
        this.thirdPartyService=thirdPartyService;
    }

    public void run(){
        thirdPartyService.getMessage();
    }
}
