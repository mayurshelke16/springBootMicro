package com.neosoft.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.neosoft.model.Contact;
import com.neosoft.repository.ContactRepository;

@Service
public class ContactServiceImp implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	
	
	@Override
	public Contact savedata(Contact contact) {
		
		return contactRepository.save(contact);
	}


	@Override
	public List<Contact> getID(Long userId) {
		List<Contact> list=contactRepository.findAll();

		return list.stream().filter(contact->contact.getUserId().equals(userId)).collect(Collectors.toList()); 

	}


	@Override
	public Contact deleteid(long userId) {
             Contact contact=	contactRepository.findById(userId).get();
           
              contactRepository.delete(contact);
			return contact;
	}





}


