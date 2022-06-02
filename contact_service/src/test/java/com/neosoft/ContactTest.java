package com.neosoft;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.base.Optional;
import com.neosoft.model.Contact;
import com.neosoft.repository.ContactRepository;

@RunWith(SpringRunner.class)
@DataMongoTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ContactTest {

	@Autowired
	private ContactRepository contactRepository;
	
	
	  @Test 
	  public void saveContactTest() 
	  {  
		  Contact user=user.builder().cId(1).email("mayur12@gmail.com").contactName("Raj").
	       build(); contactRepository.save(user);
	       Assertions.assertThat(user.getUserId()).isGreaterThan(0);
	    
	  
	  }
	  
	  @Test 
	  public void getContactTest()
	  {
	  	  Contact contact = contactRepository.findBycId(1L).get();
	  	  Assertions.assertThat(contact.getUserId()).isEqualTo(1);
	  
	  }
	  
	  
	  @Test 
	  public void deleteUserTest()
	  {
		  Contact contact= contactRepository.findBycId(1L).get();
		  contactRepository.delete(contact); Contact contact2=null; Optional<Contact>
		  optional=contactRepository.findBycId(1L);
	  
	  if(optional.isPresent()) { contact2=optional.get(); }
	  
	  Assertions.assertThat(contact2).isNull(); }
	 
}
