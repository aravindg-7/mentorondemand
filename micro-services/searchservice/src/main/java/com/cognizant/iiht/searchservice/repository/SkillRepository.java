package com.cognizant.iiht.searchservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.iiht.searchservice.model.Skill;



@Repository
public interface SkillRepository extends CrudRepository<Skill,Long> {

}
