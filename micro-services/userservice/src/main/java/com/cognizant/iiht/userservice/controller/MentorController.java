package com.cognizant.iiht.userservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.iiht.userservice.model.Mentor;
import com.cognizant.iiht.userservice.service.MentorService;

@RestController
@RequestMapping("/mentor")
public class MentorController {
		
	@Autowired
	private MentorService mservice;
	@PostMapping("/{uname}")
	public void addmentor(@RequestBody @Valid Mentor mentor,@PathVariable String uname){
		mservice.addmentor(mentor, uname);
		
	}
}
