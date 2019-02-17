package com.test.besttrip.service;

import com.test.besttrip.model.Experience;
import com.test.besttrip.model.repository.ExperienceRepository;
import com.test.besttrip.service.exception.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

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

    public Experience getOneExperienceByVilleName(String villeName) {
        return experienceRepository.findOneByCountry(villeName);
    }



    public ArrayList<Experience> getExperienceByVilleName(String villeName) {
        return experienceRepository.findByVilleName(villeName);
    }
    public ArrayList<Experience> findByVilleName(String name){




            Iterable <Experience> exp = getExperiences();
            ArrayList<Experience> exp_ville = new ArrayList<Experience>() ;

            exp.forEach( experience -> {

                if (experience.getVilleName().equals(name)) {

                    exp_ville.add(experience);
                }
            });

            return exp_ville;

    }


    //TODO //Done //Beta
    //get experiences by country

    public ArrayList<Experience> getExperienceByCountry(String country) {
        return experienceRepository.findByCountry(country);
    }



    public ArrayList<Experience> findByCountry(String name){

        Iterable <Experience> exp = getExperiences();
        ArrayList<Experience> exp_country = new ArrayList<Experience>() ;

        exp.forEach( experience -> {

            if (experience.getCountry().equals(name)) {

                exp_country.add(experience);
            }
        });
        return exp_country;
    }




    public void createExperience(Experience experience) {
        log.info("[an experience is created in "+experience.getVilleName()+"("+experience.getCountry()+")]");
        experienceRepository.save(experience);
    }

    public void updateExperience(int id, Experience experience) {
        if (id == experience.getExpId()) {
            experienceRepository.save(experience);
        }
        else {
            throw new BadRequestException("Bad Request");
        }
    }

    public void deleteExperience(int id, Experience experience) {
        experienceRepository.delete(experience);
    }


}
