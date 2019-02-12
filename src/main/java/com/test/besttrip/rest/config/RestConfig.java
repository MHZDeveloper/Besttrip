package com.test.besttrip.rest.config;

import com.test.besttrip.rest.AccountRestController;
import com.test.besttrip.rest.VilleRestController;
import com.test.besttrip.service.AccountService;
import com.test.besttrip.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class
RestConfig {

    @Bean
    public VilleRestController villeRestController(VilleService villeService){
        return new VilleRestController(villeService);
    }

    @Bean
    public AccountRestController accountRestController(AccountService accountService){
        return new AccountRestController(accountService);
    }
}
