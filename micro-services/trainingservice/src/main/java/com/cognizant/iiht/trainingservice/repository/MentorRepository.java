package com.cognizant.iiht.trainingservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.iiht.trainingservice.model.Mentor;
import com.cognizant.iiht.trainingservice.model.User;


@Repository
public interface MentorRepository extends CrudRepository<Mentor,Long> {

	Mentor findByUser(User user);

}
