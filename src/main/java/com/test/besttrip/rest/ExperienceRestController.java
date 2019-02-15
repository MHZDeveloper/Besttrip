package com.test.besttrip.rest;

import com.test.besttrip.model.Experience;
import com.test.besttrip.service.ExperienceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperienceRestController {

    private ExperienceService experienceService;

    public ExperienceRestController(ExperienceService experienceService){
        this.experienceService = experienceService;
    }


    @RequestMapping(
            method = RequestMethod.GET,
            path = "/api/besttrip/experiences",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Experience> getExperiences(){
        return experienceService.getExperiences();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/api/besttrip/experiences",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void createExperience(@RequestBody Experience experience){
        experienceService.createExperience(experience);
    }
}
