package com.test.besttrip.model.repository.config;

import com.test.besttrip.model.repository.AccountRepository;
import com.test.besttrip.model.repository.ExperienceRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {AccountRepository.class, ExperienceRepository.class})
public class RepositoryConfig {

}
