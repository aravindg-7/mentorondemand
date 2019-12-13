package com.cognizant.iiht.searchservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.iiht.searchservice.model.MentorSkill;
import com.cognizant.iiht.searchservice.model.Skill;
import com.cognizant.iiht.searchservice.service.SearchService;

@RestController
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private SearchService service;
	@PostMapping
	public List<MentorSkill> getMentorbySkill(@RequestBody @Valid Skill skill){
		return service.getMentorbySkill(skill);
	}
}
