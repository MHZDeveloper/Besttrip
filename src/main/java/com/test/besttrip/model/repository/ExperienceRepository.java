package com.test.besttrip.model.repository;

import com.test.besttrip.model.Experience;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;


public interface ExperienceRepository extends CrudRepository<Experience,String> {

    List<Experience> findByCountry(String name);
    List<Experience> findByVilleName(String name);
}
