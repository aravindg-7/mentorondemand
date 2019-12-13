package com.cognizant.iiht.searchservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.iiht.searchservice.model.MentorSkill;
import com.cognizant.iiht.searchservice.model.Skill;
import com.cognizant.iiht.searchservice.repository.MentorskillRepository;

@Service
public class SearchService {
	
	@Autowired
	private MentorskillRepository mskrepo;
	@Transactional
	public List<MentorSkill> getMentorbySkill(Skill skill){
		return mskrepo.findAllBySkillId(skill);
	}
	

}
