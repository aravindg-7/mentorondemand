package com.cognizant.iiht.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.iiht.userservice.exception.UserAlreadyExistsException;
import com.cognizant.iiht.userservice.model.Mentor;
import com.cognizant.iiht.userservice.model.MentorSkill;
import com.cognizant.iiht.userservice.model.Skill;
import com.cognizant.iiht.userservice.model.User;
import com.cognizant.iiht.userservice.repository.SkillRepository;
import com.cognizant.iiht.userservice.repository.UserRepository;
import com.cognizant.iiht.userservice.security.AppUserDetailsService;
import com.cognizant.iiht.userservice.service.MentorService;


@RestController
@RequestMapping("/users") 
public class UserController {
	@Autowired
	InMemoryUserDetailsManager inMemoryUserDetailsManager;
	
	@Autowired
	private AppUserDetailsService detailservice;
	
	@Autowired
	private UserRepository repository;
	
	
	
	
	
//	@PostMapping
//	public boolean signup(@RequestBody @Valid User user) throws UserAlreadyExistsException {
//		
//			if(inMemoryUserDetailsManager.userExists(user.getUsername())){
//				throw new UserAlreadyExistsException();
//				
//			}
//			else{
//				
//				inMemoryUserDetailsManager.createUser(
//						org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
//						.password(new BCryptPasswordEncoder().encode(user.getPassword()))
//						.roles("USER").build());
//				return true;
//			}
//			
//	}
      
	@PostMapping
	public void signup(@RequestBody @Valid User user) throws UserAlreadyExistsException {
		if(detailservice.signup(user)){
			detailservice.signup(user);
			user.getUsername();}
		else
			throw new UserAlreadyExistsException();
	}
	@GetMapping("/{id}")
	public User getuser(@PathVariable long id){
		return repository.findById(id).get();
	}
	
//	@PostMapping("/mentor/{id}")
//	public String addmentor(@RequestBody @Valid Mentor mentor,@PathVariable String uname){
//		mservice.addmentor(mentor, uname);
//		return uname;
//	}
//	@PostMapping("/skill/{id}")
//	public String addskill(@RequestBody @Valid MentorSkill mentorskill,@PathVariable String uname){
//		mservice.addskill(mentorskill, uname);
//		return uname;
//	}
//	@GetMapping("/skill")
//	public List<Skill> getallskill(){
//		List<Skill> sk= new ArrayList<Skill>();
//		skrepo.findAll().forEach(sk::add);
//		return sk;
//	}
}
