package com.test.besttrip.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExperienceTest {

    private Experience experience;

    @Before
    public void before(){
        experience = new Experience();
    }

    @Test
    public void should_return_the_right_recommadation_mean(){
        //given
        experience.setSommeRecommandation(12);
        experience.setRecommandationNumber(6);

        //when
        double result = experience.getMeanRecommandation();

        //then
        Assert.assertEquals(2.0,result,0.0001);
    }

    @Test
    public void should_update_the_recommadation_mean(){
        //given
        experience.setSommeRecommandation(18);
        experience.setRecommandationNumber(9);

        //when
        double result = experience.updateMeanRecommandation(2);

        //then
        Assert.assertEquals(2.0,result,0.0001);
    }

}