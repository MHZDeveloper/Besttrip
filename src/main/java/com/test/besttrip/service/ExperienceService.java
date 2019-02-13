package com.test.besttrip.service;

import com.test.besttrip.model.Account;
import com.test.besttrip.model.AccountType;
import com.test.besttrip.model.Experience;
import com.test.besttrip.model.repository.ExperienceRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExperienceService {


    private ExperienceRepository experienceRepository;
    private AccountService accountService;

    public ExperienceService(ExperienceRepository experienceRepository,AccountService accountService) {
        this.experienceRepository = experienceRepository;
        this.accountService = accountService;
    }

    public Iterable<Experience> getExperiences (){

//        Account account = new Account("login","password",AccountType.ADMIN);
//        account.setExperiences((List<Experience>) experienceRepository.findAll());
//        accountService.createAccount(account);
        return experienceRepository.findAll();
    }

    public Experience getExperienceByVilleName(String villeName){
        return experienceRepository.findByVilleName(villeName);
    }

    public void createExperience(Experience experience){
        experienceRepository.save(experience);
    }

    public void updateExperience(int id,Experience experience){
        experienceRepository.save(experience);
    }

    public void deleteExperience(int id, Experience experience){
        experienceRepository.delete(experience);
    }
}
