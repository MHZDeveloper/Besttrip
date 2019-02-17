package com.test.besttrip.service;

import com.test.besttrip.model.Experience;
import com.test.besttrip.model.repository.ExperienceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public Experience getExperienceByVilleName(String villeName) {
        return experienceRepository.findByVilleName(villeName);
    }

    //TODO
    //get experiences by country

    public void createExperience(Experience experience) {
        log.info("[an experience is created in "+experience.getVilleName()+"("+experience.getCountry()+")]");
        experienceRepository.save(experience);
    }

    public void updateExperience(int id, Experience experience) {
        if (id == experience.getExpId()) {
            experienceRepository.save(experience);
        }
        //else throw exception
    }

    public void deleteExperience(int id, Experience experience) {
        experienceRepository.delete(experience);
    }
}
