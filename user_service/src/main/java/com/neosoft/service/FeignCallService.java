package com.neosoft.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neosoft.model.Contact;
import com.neosoft.model.User;

@FeignClient(name="contact-service",url="http://localhost:8282/contact/")
public interface FeignCallService {


	
	@GetMapping("/{userId}")
	public List<Contact> getID(@PathVariable Long userId);
	
	@PostMapping("/save")
	public Contact saveContact(@RequestBody Contact contact);
	
	@DeleteMapping("/{userId}")
	public Contact deleteid(@PathVariable long userId);
}
