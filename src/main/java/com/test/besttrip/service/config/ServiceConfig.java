package com.test.besttrip.service.config;

import com.test.besttrip.model.repository.AccountRepository;
import com.test.besttrip.model.repository.ExperienceRepository;
import com.test.besttrip.service.AccountService;
import com.test.besttrip.service.ExperienceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {


    @Bean
    public ExperienceService experienceService (ExperienceRepository experienceRepository,AccountService accountService){
        return new ExperienceService(experienceRepository,accountService);
    }

    @Bean
    public AccountService accountService (AccountRepository accountRepository){
        return new AccountService(accountRepository);
    }
}
