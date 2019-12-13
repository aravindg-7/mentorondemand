package com.cognizant.iiht.userservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.iiht.userservice.model.Mentor;

@Repository
public interface MentorRepository extends CrudRepository<Mentor,Long> {

}
