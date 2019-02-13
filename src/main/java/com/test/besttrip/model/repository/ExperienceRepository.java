package com.test.besttrip.model.repository;

import com.test.besttrip.model.Experience;
import org.springframework.data.repository.CrudRepository;

public interface ExperienceRepository extends CrudRepository<Experience,String> {

    Experience findByVilleName(String name);
}
