package com.cognizant.iiht.skillservice.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.iiht.skillservice.model.Skill;


@Repository
public interface SkillRepository extends CrudRepository<Skill,Long> {

}
