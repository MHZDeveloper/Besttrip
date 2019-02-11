package com.test.besttrip.model.repository;

import com.test.besttrip.model.Ville;
import org.springframework.data.repository.CrudRepository;

public interface VilleRepository extends CrudRepository<Ville,String> {

    Ville findByName(String name);
}
