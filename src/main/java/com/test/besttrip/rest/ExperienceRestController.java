package com.test.besttrip.rest;

import com.test.besttrip.model.Experience;
import com.test.besttrip.service.ExperienceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExperienceRestController {

    private ExperienceService experienceService;

    public ExperienceRestController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }


    @RequestMapping(
            method = RequestMethod.GET,
            path = "/api/besttrip/experiences",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Experience> getExperiences() {
        return experienceService.getExperiences();
    }


    @RequestMapping(
            method = RequestMethod.GET,
            path = "/api/besttrip/experiences/ville={villeD}")
    public Iterable<Experience> getExperiencesByVille(@PathVariable("villeD") String ville) {
        return experienceService.getExperienceByVilleName(ville);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/api/besttrip/experiences/means/ville={villeD}")
    public int getExperiencesMeanByVille(@PathVariable("villeD") String ville) {
        return experienceService.getGeneralMeanByVilleName(ville);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/api/besttrip/experiences/country={country}"
    )
    public Iterable<Experience> getExperiencesByCountry(@PathVariable("country") String country) {
        return experienceService.getExperienceByCountry(country);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/api/besttrip/experiences/means/country={country}"
    )
    public int getExperiencesMeanByCountry(@PathVariable("country") String country) {
        return experienceService.getGeneralMeanByCountry(country);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/api/besttrip/experiences/{login}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void createExperience(@RequestBody Experience experience, @PathVariable("login") String login) {
        experienceService.createExperience(experience, login);
    }

    @RequestMapping(method = RequestMethod.PUT,
            path = "/api/besttrip/experiences/{expId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateExperience(@PathVariable("expId") int id, @RequestBody Experience experience) {
        experienceService.updateExperience(id, experience);
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/api/besttrip/experiences/{Expid}"
    )
    public void Experience(@PathVariable("Expid") int Expid) {
        experienceService.deleteExperience(Expid);
    }

}


