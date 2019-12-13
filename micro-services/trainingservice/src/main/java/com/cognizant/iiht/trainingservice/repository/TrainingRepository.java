package com.cognizant.iiht.trainingservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.iiht.trainingservice.model.Mentor;
import com.cognizant.iiht.trainingservice.model.Training;
import com.cognizant.iiht.trainingservice.model.User;

public interface TrainingRepository extends CrudRepository<Training,Long> {
	
	List<Training> findAllByMentor(Mentor mentor);

	List<Training> findAllByUser(User user);
}
