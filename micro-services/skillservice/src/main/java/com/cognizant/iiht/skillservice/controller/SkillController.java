package com.cognizant.iiht.skillservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.iiht.skillservice.model.Skill;
import com.cognizant.iiht.skillservice.repository.SkillRepository;


@RestController
@RequestMapping("/skill")
public class SkillController {
	
	@Autowired
	private SkillRepository skrepo;
	@GetMapping
	public List<Skill> getallskill(){
		List<Skill> sk= new ArrayList<Skill>();
		skrepo.findAll().forEach(sk::add);
		return sk;
	}
}
