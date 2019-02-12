package com.test.besttrip.service;

import com.test.besttrip.model.Ville;
import com.test.besttrip.model.repository.VilleRepository;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class VilleService {

    private VilleRepository villeRepository;
    private IdService idService;

    public VilleService(VilleRepository villeRepository,IdService idService) {
        this.villeRepository = villeRepository;
        this.idService = idService;
    }

    public Iterable<Ville> getVilles(){
        Ville ville = new Ville();
        ville.setId("Tunis");
        ville.setName("Tunis");
        ville.setPays("Tunisie");
        villeRepository.save(ville);
        return (List<Ville>)villeRepository.findAll();
    }

    public Optional<Ville> getVille(String villeId){
        return villeRepository.findById(villeId);
    }

    public Ville getVilleByName(String name){
        return villeRepository.findByName(name);
    }

    public void createVille(Ville ville){
        ville.setId(idService.generateId(ville.getName()));
        villeRepository.save(ville);
    }

}
