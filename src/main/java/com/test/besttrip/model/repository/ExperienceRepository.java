package com.test.besttrip.model.repository;

import com.test.besttrip.model.Experience;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface ExperienceRepository extends CrudRepository<Experience,String> {
    Experience findOneByCountry(String name);
    ArrayList<Experience> findByCountry(String name);
    ArrayList<Experience> findByVilleName(String name);
}
