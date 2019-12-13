package com.cognizant.iiht.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.iiht.userservice.model.User;






@Repository
public interface UserRepository extends CrudRepository<User,Long> {

	public User findByUsername(String name);
	
	

}
