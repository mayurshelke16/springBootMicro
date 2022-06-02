package com.neosoft.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.google.common.base.Optional;
import com.neosoft.model.User;

public interface UserRepository extends MongoRepository<User, Long>{

	Optional<User> findByUserId(long l);
	

}
