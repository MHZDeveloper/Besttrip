package com.test.besttrip.rest;

import com.test.besttrip.model.Ville;
import com.test.besttrip.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class VilleRestController {

    private VilleService villeService;

    public VilleRestController(VilleService villeService) {
        this.villeService = villeService;
    }


    @RequestMapping(
            method = RequestMethod.GET,
            path = "/api/besttrip/villes",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Ville> getVilles(){
        return villeService.getVilles();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/api/besttrip/villes/{name}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Ville getVilleByName(@PathVariable("name") String name){
        return villeService.getVilleByName(name);
    }

    //TODO
//    @RequestMapping(
//            method = RequestMethod.POST,
//            path = "/api/besttrip/villes",
//            consumes = MediaType.APPLICATION_JSON_VALUE
//    )
//    public void createVille(@RequestBody Ville ville){
//        villeService.createVille(ville);
//    }

}
