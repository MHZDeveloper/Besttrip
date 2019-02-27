package com.test.besttrip.service;

import com.test.besttrip.model.Experience;
import com.test.besttrip.model.repository.ExperienceRepository;
import com.test.besttrip.service.exception.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

public class ExperienceService {

    private static final Logger log = LoggerFactory.getLogger(ExperienceService.class);

    private ExperienceRepository experienceRepository;
    private AccountService accountService;

    public ExperienceService(ExperienceRepository experienceRepository, AccountService accountService) {
        this.experienceRepository = experienceRepository;
        this.accountService = accountService;
    }

    public Iterable<Experience> getExperiences() {
        return experienceRepository.findAll();
    }

    public List<Experience> getExperienceByVilleName(String villeName) {
        return experienceRepository.findByVilleName(villeName);
    }

    public List<Experience> getExperienceByCountry(String country) {
        return experienceRepository.findByCountry(country);
    }

    //get general mean by ville name

    //get general mean by country

    public void createExperience(Experience experience) {
        log.info("[an experience is created in " + experience.getVilleName() + "(" + experience.getCountry() + ")]");
        experienceRepository.save(experience);
    }

    public void updateExperience(int id, Experience experience) {
        if (id == experience.getExpId()) {
            log.info("[an experience is updated : " + experience.getVilleName() + "(" + experience.getCountry() + ")]");
            experienceRepository.save(experience);
        } else {
            throw new BadRequestException("Bad Request");
        }
    }

    //check if id = experience.id else exception "bad request" TODO //DONE //beta

    public void deleteExperience(int id) {
        if (experienceRepository.findById(id).isPresent()){
            log.info("[an experience with the id : " + id + " is deleted]");
            experienceRepository.deleteById(id);

        }else { throw  new BadRequestException("Bad Delete Request");
                    }



    }

}