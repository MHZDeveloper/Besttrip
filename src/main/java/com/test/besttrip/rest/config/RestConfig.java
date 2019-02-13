package com.test.besttrip.rest.config;

import com.test.besttrip.rest.AccountRestController;
import com.test.besttrip.rest.ExperienceRestController;
import com.test.besttrip.service.AccountService;
import com.test.besttrip.service.ExperienceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestConfig {


    @Bean
    public ExperienceRestController experienceRestController(ExperienceService experienceService){
        return new ExperienceRestController(experienceService);
    }

    @Bean
    public AccountRestController accountRestController(AccountService accountService){
        return new AccountRestController(accountService);
    }
}
