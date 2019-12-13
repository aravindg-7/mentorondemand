package com.cognizant.iiht.trainingservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.iiht.trainingservice.model.User;




@Repository
public interface UserRepository extends CrudRepository<User,Long> {

	public User findByUsername(String name);
	
	

}
