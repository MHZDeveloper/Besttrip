package com.test.besttrip;

import com.test.besttrip.model.repository.config.RepositoryConfig;
import com.test.besttrip.rest.config.RestConfig;
import com.test.besttrip.service.config.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@Import({RestConfig.class,RepositoryConfig.class, ServiceConfig.class})
@EnableAutoConfiguration
public class BesttripApplication {

	public static void main(String[] args) {
		SpringApplication.run(BesttripApplication.class, args);
	}

	@RequestMapping(value="/")
	public String homepage(){
		return "index";
	}

}

