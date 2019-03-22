package com.test.besttrip.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExperienceTest {

    private Experience experience;

    @Before
    public void before(){
        experience = new Experience();
    }

    @Test
    public void should_return_the_right_recommadation_mean(){
        //given

        List<Rank> ranks = new ArrayList<>();
        ranks.add(new Rank(2));
        ranks.add(new Rank(4));

        experience.setRanks(ranks);
        //when
        int result = experience.getMeanRank();

        //then
        Assert.assertEquals(3,result);
    }

}