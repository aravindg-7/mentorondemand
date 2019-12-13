package com.cognizant.iiht.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.iiht.userservice.model.Skill;

@Repository
public interface SkillRepository extends CrudRepository<Skill,Long> {

}
