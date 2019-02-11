package com.test.besttrip.model.repository.config;

import com.test.besttrip.model.repository.AccountRepository;
import com.test.besttrip.model.repository.VilleRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {VilleRepository.class, AccountRepository.class})
public class RepositoryConfig {

}
