package com.cognizant.iiht.searchservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.iiht.searchservice.model.MentorSkill;
import com.cognizant.iiht.searchservice.model.Skill;



public interface MentorskillRepository extends CrudRepository<MentorSkill,Long> {
	
	List<MentorSkill> findAllBySkillId(Skill skill);
}
