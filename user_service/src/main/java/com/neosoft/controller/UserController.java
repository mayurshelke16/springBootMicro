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
import org.springframework.web.client.RestTemplate;

import com.neosoft.model.Contact;
import com.neosoft.model.User;
import com.neosoft.service.FeignCallService;
import com.neosoft.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	
	
     @Autowired 
     private RestTemplate restTemplate;
	  
	 @Autowired
	  private FeignCallService feignCallService;
	
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		User savedata=userService.saveDeatils(user);
		return new ResponseEntity<>(savedata,HttpStatus.CREATED);
		
	}
	
	
	/*
	 * @PostMapping("/savedata") public ResponseEntity<Contact>
	 * saveContact(@RequestBody Contact contact) { Contact
	 * savedata=feignCallService.saveContact(contact); return new
	 * ResponseEntity<>(savedata,HttpStatus.CREATED);
	 * 
	 * }
	 */
	
	
	
	@GetMapping("/show")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> user= userService.gatdata();
	
		return new ResponseEntity<List<User>>(user,HttpStatus.OK);
		
	}
	
	
	
	 @GetMapping("/{userId}")
	    public User getUser(@PathVariable("userId") Long userId) {

	        User user = this.userService.getUser(userId);
	        List<Contact> contacts = feignCallService.getID(userId);
	      
	        user.setContacts(contacts);
	        return user;

	    }
	 
	
	 @DeleteMapping("/{userId}")
		public ResponseEntity<User> deleteID(@PathVariable Long userId)
		{
			//userService.deleteId(userId);
		
		feignCallService.deleteid(userId);
			return new ResponseEntity<User>(HttpStatus.ACCEPTED);
		}
	 
}
