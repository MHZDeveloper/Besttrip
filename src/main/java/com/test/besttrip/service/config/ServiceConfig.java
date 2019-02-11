package com.test.besttrip.service.config;

import com.test.besttrip.model.repository.AccountRepository;
import com.test.besttrip.model.repository.VilleRepository;
import com.test.besttrip.service.AccountService;
import com.test.besttrip.service.VilleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public VilleService villeService (VilleRepository villeRepository){
        return new VilleService(villeRepository);
    }

    @Bean
    public AccountService accountService (AccountRepository accountRepository){
        return new AccountService(accountRepository);
    }
}
