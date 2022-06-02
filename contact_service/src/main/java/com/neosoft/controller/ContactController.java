package com.neosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.Contact;
import com.neosoft.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@PostMapping("/save")
	public ResponseEntity<Contact> saveContact(@RequestBody Contact contact)
	{
		Contact contact2= contactService.savedata(contact);
		return new ResponseEntity<Contact>(contact2,HttpStatus.OK);
		
	}
	
	@GetMapping("/{userId}")
	public List<Contact> getID(@PathVariable Long userId)
	{
		List<Contact> contact= contactService.getID(userId);
		return contact;
		
	}
	
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Contact> deleteid(@PathVariable long userId)
	{
		Contact contacts= contactService.deleteid(userId);
		return new ResponseEntity<Contact>(contacts,HttpStatus.OK);
		
	}
}
