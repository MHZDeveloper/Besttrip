package com.test.besttrip.rest;

import com.test.besttrip.model.Experience;
import com.test.besttrip.service.ExperienceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
             method = RequestMethod.GET ,
             path="/api/besttrip/experiences/ville={villeD}")
    public Iterable<Experience> getExperiencesByVille(@PathVariable("villeD") String ville){
        return experienceService.getExperienceByVilleName(ville);
}

    @RequestMapping(
            method = RequestMethod.GET ,
            path="/api/besttrip/experiences/country={country}"
    )
    public Iterable<Experience> getExperiencesByCountry(@PathVariable("country") String country) {
        return experienceService.getExperienceByCountry(country);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/api/besttrip/experiences",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void createExperience(@RequestBody Experience experience){
        experienceService.createExperience(experience);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = "/api/besttrip/experiences/{expId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateExperience(@PathVariable("expId") int id,@RequestBody Experience experience){
        experienceService.updateExperience(id,experience);
    }

    //delete experience TODO

}


