package com.cognizant.iiht.userservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.iiht.userservice.model.Mentor;
import com.cognizant.iiht.userservice.model.MentorSkill;
import com.cognizant.iiht.userservice.model.Skill;
import com.cognizant.iiht.userservice.model.User;
import com.cognizant.iiht.userservice.repository.MentorRepository;
import com.cognizant.iiht.userservice.repository.SkillRepository;
import com.cognizant.iiht.userservice.repository.UserRepository;

@Service
public class MentorService {
	
	@Autowired
	private MentorRepository merepo;
	
	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private SkillRepository skrepo;
	
	@Transactional
	public void addmentor(Mentor mentor,String uname){
		User u=urepo.findByUsername(uname);
		mentor.setUser(u);
		mentor.setId(u.getId());
		u.setMentor(mentor);
		urepo.save(u);
	}
	
	@Transactional
	public void addskill(MentorSkill mentorskill,String uname){
		User u=urepo.findByUsername(uname);
//		Skill skill=skrepo.findById(skillid).get();
//		mentorskill.setSkillId(skill);
		Mentor mentor=u.getMentor();
		mentorskill.setMentorId(mentor);
		mentor.getMskill().add(mentorskill);
		merepo.save(mentor);
	}
	
}
