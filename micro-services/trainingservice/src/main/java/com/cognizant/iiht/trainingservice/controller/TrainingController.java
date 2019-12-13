package com.cognizant.iiht.trainingservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.iiht.trainingservice.exception.EndDateCoincideException;
import com.cognizant.iiht.trainingservice.exception.StartDateCoincideException;
import com.cognizant.iiht.trainingservice.model.Training;
import com.cognizant.iiht.trainingservice.model.User;
import com.cognizant.iiht.trainingservice.repository.UserRepository;
import com.cognizant.iiht.trainingservice.service.TrainingService;

@RestController
@RequestMapping("/training")
public class TrainingController {
	
	@Autowired
	private TrainingService trainingService;
	
	@Autowired
	private UserRepository urepo;
	
	@PostMapping
	public void addTrainingRequest(@RequestBody @Valid Training training) throws StartDateCoincideException, EndDateCoincideException {
		trainingService.addTrainingRequest(training);
	}
	@GetMapping("/{uname}")
	public User getuser(@PathVariable String uname){
		return urepo.findByUsername(uname);
	}
	
	@PostMapping("/status")
	public void editStatus(@RequestBody @Valid Training training){
		trainingService.editStatus(training);
	}
	
	@GetMapping("/get/{uname}")
	public List<Training> getIncompleteTraining(@PathVariable String uname) {
		return trainingService.getIncompleteTraining(uname);
	}
	

}
