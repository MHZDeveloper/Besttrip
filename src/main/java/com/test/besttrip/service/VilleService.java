package com.test.besttrip.service;

import com.test.besttrip.model.Ville;
import com.test.besttrip.model.repository.VilleRepository;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class VilleService {

    private VilleRepository villeRepository;

    public VilleService(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    public Iterable<Ville> getVilles(){
        return (List<Ville>)villeRepository.findAll();
    }

    public Optional<Ville> getVille(String villeId){
        return villeRepository.findById(villeId);
    }

    public Ville getVilleByName(String name){
        return villeRepository.findByName(name);
    }

}
