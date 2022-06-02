package com.neosoft.service;

import java.util.List;

import com.neosoft.model.Contact;

public interface ContactService {

	Contact savedata(Contact contact);

	List<Contact> getID(Long userId);

	Contact deleteid(long userId);

	
}
