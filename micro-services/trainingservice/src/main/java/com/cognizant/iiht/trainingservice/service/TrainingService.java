package com.cognizant.iiht.trainingservice.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.iiht.trainingservice.exception.EndDateCoincideException;
import com.cognizant.iiht.trainingservice.exception.StartDateCoincideException;
import com.cognizant.iiht.trainingservice.model.Mentor;
import com.cognizant.iiht.trainingservice.model.Training;
import com.cognizant.iiht.trainingservice.model.User;
import com.cognizant.iiht.trainingservice.repository.MentorRepository;
import com.cognizant.iiht.trainingservice.repository.TrainingRepository;
import com.cognizant.iiht.trainingservice.repository.UserRepository;

@Service
public class TrainingService {
	
	@Autowired
	private TrainingRepository trainingRepository;
	
	@Autowired
	private UserRepository userepo;
	
	@Autowired
	private MentorRepository merepo;
	
	@Transactional
	public void addTrainingRequest(Training training) throws StartDateCoincideException, EndDateCoincideException {
		List<Training> trainingListMentor = trainingRepository.findAllByMentor(training.getMentor());
		List<Training> trainingListUser = trainingRepository.findAllByUser(training.getUser());
		for(Training existingTraining:trainingListMentor){
			if(existingTraining.getStatus().equals("Approved")){
				if(training.getStartdate().after(existingTraining.getStartdate()) || training.getStartdate().equals(existingTraining.getStartdate())){
					if(training.getStartdate().before(existingTraining.getEnddate()) || training.getStartdate().equals(existingTraining.getEnddate())){
						throw new StartDateCoincideException();
					}
				}
				else if(training.getEnddate().after(existingTraining.getStartdate()) || training.getEnddate().equals(existingTraining.getStartdate())){
					if(training.getEnddate().before(existingTraining.getEnddate()) || training.getEnddate().equals(existingTraining.getEnddate())){
						throw new EndDateCoincideException();
					}
				}
			}
		}
		for(Training existingTraining:trainingListUser){
			if(existingTraining.getStatus().equals("Approved")){
				if(training.getStartdate().after(existingTraining.getStartdate()) || training.getStartdate().equals(existingTraining.getStartdate())){
					if(training.getStartdate().before(existingTraining.getEnddate()) || training.getStartdate().equals(existingTraining.getEnddate())){
						throw new StartDateCoincideException();
					}
				}
				else if(training.getEnddate().after(existingTraining.getStartdate()) || training.getEnddate().equals(existingTraining.getStartdate())){
					if(training.getEnddate().before(existingTraining.getEnddate()) || training.getEnddate().equals(existingTraining.getEnddate())){
						throw new EndDateCoincideException();
					}
				}
			}
		}
		trainingRepository.save(training);
	}
	
	@Transactional
	public List<Training> getIncompleteTraining(String userName) {
		User user = userepo.findByUsername(userName);
		Mentor mentor = merepo.findByUser(user);
		List<Training> trainingList = trainingRepository.findAllByMentor(mentor);
		List<Training> pendingTrainingList = new ArrayList<Training>();
		for(Training training:trainingList){
			if(training.getStatus().equals("Request Pending")){
				pendingTrainingList.add(training);
			}
		}
		return pendingTrainingList;
	}
	
	@Transactional
	public void editStatus(@Valid Training training) {
		trainingRepository.save(training);
	}
}
