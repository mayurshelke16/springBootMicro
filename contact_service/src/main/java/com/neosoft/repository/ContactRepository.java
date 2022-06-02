package com.neosoft.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.google.common.base.Optional;
import com.neosoft.model.Contact;

public interface ContactRepository extends MongoRepository<Contact, Long> {

	Optional<Contact> findBycId(Long cId);

}
