package com.test.besttrip.service;

import com.test.besttrip.model.Experience;
import com.test.besttrip.model.repository.ExperienceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExperienceServiceTest {

    private ExperienceRepository experienceRepository;
    private ExperienceService experienceService;
    private AccountService accountService;

    @Before
    public void before(){
        experienceRepository = Mockito.mock(ExperienceRepository.class);
        accountService = Mockito.mock(AccountService.class);
        experienceService = new ExperienceService(experienceRepository,accountService);
    }

    @Test
    public void should_create_experience_in_database(){
        ArgumentCaptor<Experience> argumentCaptor = ArgumentCaptor.forClass(Experience.class);
        //given
        Experience experience = new Experience();
        experience.setVilleName("Tunis");
        experience.setCountry("Tunisie");
        //when
        experienceService.createExperience(experience);
        //then
        Mockito.verify(experienceRepository,Mockito.times(1)).save(argumentCaptor.capture());
        Assert.assertNotNull(argumentCaptor.getValue().getExpId());
        Assert.assertEquals("Tunis",argumentCaptor.getValue().getVilleName());
    }

    @Test
    public void should_return_all_experiences_from_database(){
        //given
        List<Experience> experienceList = new ArrayList<>();
        Experience experience = new Experience();
        experience.setVilleName("Tunis");
        experienceList.add(experience);
        Mockito.doReturn(experienceList).when(experienceRepository).findAll();
        //when
        List<Experience> result = (List<Experience>) experienceService.getExperiences();
        //then
        Assert.assertEquals(1,result.size());
        Assert.assertEquals("Tunis",result.get(0).getVilleName());
    }

    @Test
    public void should_return_experience_by_name_from_database() {
        //given
        Experience experience = new Experience();
        experience.setVilleName("Tunis");
        Mockito.doReturn(experience).when(experienceRepository).findByVilleName("Tunis");
        //when
        Experience result = experienceService.getExperienceByVilleName("Tunis");
        //then
        Assert.assertNotNull(result.getExpId());
        Assert.assertEquals("Tunis",result.getVilleName());
    }

}