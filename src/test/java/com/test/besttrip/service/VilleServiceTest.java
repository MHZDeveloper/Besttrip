package com.test.besttrip.service;

import com.test.besttrip.model.Ville;
import com.test.besttrip.model.repository.VilleRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class VilleServiceTest {

    private VilleRepository villeRepository;
    private VilleService villeService;
    private IdService idService;

    @Before
    public void before(){
        villeRepository = Mockito.mock(VilleRepository.class);
        idService = new IdService();
        villeService = new VilleService(villeRepository,idService);
    }

    @Test
    public void should_create_ville_with_id(){
        ArgumentCaptor<Ville> argumentCaptor = ArgumentCaptor.forClass(Ville.class);

        //given
        Ville ville = new Ville();
        ville.setName("ain drahem");

        //when
        villeService.createVille(ville);

        //then
        Mockito.verify(villeRepository,Mockito.times(1)).save(argumentCaptor.capture());
        Assert.assertNotNull(argumentCaptor.getValue().getId());
        Assert.assertEquals("ain-drahem",argumentCaptor.getValue().getId());
    }

}