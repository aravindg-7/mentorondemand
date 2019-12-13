package com.cognizant.iiht.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.iiht.userservice.model.MentorSkill;
import com.cognizant.iiht.userservice.model.Skill;
import com.cognizant.iiht.userservice.repository.SkillRepository;
import com.cognizant.iiht.userservice.service.MentorService;

@RestController
@RequestMapping("/skill")
public class MentorSkillController {
	
	@Autowired
	private MentorService mservice;
	
	@Autowired
	private SkillRepository skrepo;
	
	@PostMapping("/{uname}")
	public void addskill(@RequestBody @Valid MentorSkill mentorskill,@PathVariable String uname){
		mservice.addskill(mentorskill, uname);
	}
//	@GetMapping
//	public List<Skill> getallskill(){
//		List<Skill> sk= new ArrayList<Skill>();
//		skrepo.findAll().forEach(sk::add);
//		return sk;
//	}
}
