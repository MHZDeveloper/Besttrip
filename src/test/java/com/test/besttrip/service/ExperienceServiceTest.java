package com.test.besttrip.service;

import com.test.besttrip.model.Experience;
import com.test.besttrip.model.repository.ExperienceRepository;
import com.test.besttrip.service.exception.BadRequestException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void should_return_experience_by_country_from_database() {
        //given
        Experience experience = new Experience();
        experience.setCountry("Tunisie");
        List<Experience> experiences = Arrays.asList(experience);
        Mockito.doReturn(experiences).when(experienceRepository).findByCountry("Tunisie");
        //when
        List<Experience> result = experienceService.getExperienceByCountry("Tunisie");
        //then
        Assert.assertNotNull(result.get(0).getExpId());
        Assert.assertEquals("Tunisie",result.get(0).getCountry());
    }

    @Test(expected = BadRequestException.class)
    public void should_return_exception_when_id_is_not_equal_to_body_id(){
        //given
        Experience experience = new Experience();
        experience.setExpId(1);
        //when
        experienceService.updateExperience(2,experience);
    }

    @Test
    public void should_return_correct_villename_mean(){
        //given
        Experience experience1 = new Experience();
        experience1.setVilleName("Tunis");
        experience1.setSommeRecommandation(5);
        experience1.setRecommandationNumber(2);

        Experience experience2 = new Experience();
        experience2.setVilleName("Tunis");
        experience2.setSommeRecommandation(6);
        experience2.setRecommandationNumber(3);

        List<Experience> experiences = Arrays.asList(experience1,experience2);
        Mockito.doReturn(experiences).when(experienceRepository).findByVilleName("Tunis");

        //when
        int result = experienceService.getGeneralMeanByVilleName("Tunis");

        //then
        Assert.assertEquals(2,result);
    }

    @Test
    public void should_return_correct_country_mean(){
        //given
        Experience experience1 = new Experience();
        experience1.setCountry("Tunisie");
        experience1.setSommeRecommandation(5);
        experience1.setRecommandationNumber(2);

        Experience experience2 = new Experience();
        experience2.setCountry("Tunisie");
        experience2.setSommeRecommandation(6);
        experience2.setRecommandationNumber(3);

        List<Experience> experiences = Arrays.asList(experience1,experience2);
        Mockito.doReturn(experiences).when(experienceRepository).findByCountry("Tunisie");

        //when
        int result = experienceService.getGeneralMeanByCountry("Tunisie");

        //then
        Assert.assertEquals(2,result);
    }

    // test for get experience by villename TODO //Done
    @Test
    public void should_return_experience_by_villename_from_database() {
        //given
        Experience experience = new Experience();
        experience.setVilleName("Tunis");
        List<Experience> experiences = Arrays.asList(experience);
        Mockito.doReturn(experiences).when(experienceRepository).findByVilleName("Tunis");
        //when
        List<Experience> result = experienceService.getExperienceByVilleName("Tunis");
        //then
        Assert.assertNotNull(result.get(0).getExpId());
        Assert.assertEquals("Tunis",result.get(0).getVilleName());
    }

    //test bad request for delete method TODO //Done //Beta //To_be_verified
    @Test(expected = BadRequestException.class)
    public void should_return_exception_when_id_is_erronious_or_inexistant(){
        //given
        Experience experience = new Experience();
        experience.setExpId(1);
        //when
        experienceService.deleteExperience(3);
    }




}