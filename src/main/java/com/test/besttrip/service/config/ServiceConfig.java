package com.test.besttrip.service.config;

import com.test.besttrip.model.repository.AccountRepository;
import com.test.besttrip.model.repository.VilleRepository;
import com.test.besttrip.service.AccountService;
import com.test.besttrip.service.IdService;
import com.test.besttrip.service.VilleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Id;

@Configuration
public class ServiceConfig {

    @Bean
    public IdService idService (){
        return new IdService();
    }

    @Bean
    public VilleService villeService (VilleRepository villeRepository, IdService idService){
        return new VilleService(villeRepository,idService);
    }

    @Bean
    public AccountService accountService (AccountRepository accountRepository){
        return new AccountService(accountRepository);
    }
}
