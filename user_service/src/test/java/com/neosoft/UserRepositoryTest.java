package com.neosoft;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.base.Optional;
import com.neosoft.model.User;
import com.neosoft.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataMongoTest

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;

	
	  
	  @Test 
	  public void saveUserTest() 
	  {
		
		  User user=user.builder().userId(1).name("mayur").phone("9898989898").build();
		  userRepository.save(user);
		  Assertions.assertThat(user.getUserId()).isGreaterThan(0);
	  }
	  
	  
	  @Test 
	  public void getUsertest() {
	  
	  User user = userRepository.findByUserId(1).get();
	  
	  Assertions.assertThat(user.getUserId()).isEqualTo(1);
	  
	  }
	  
	  @Test 
	  public void getAllUsertest() {
	  
	  List<User> user = userRepository.findAll();
	  
	  Assertions.assertThat(user.size()).isGreaterThan(0);
	  
	  }
	  
	  @Test 
	  public void deleteUserTest() {
		  
	  User user= userRepository.findByUserId(1L).get();
	  
	  userRepository.delete(user); User user2=null; Optional<User>
	  
	  optional=userRepository.findByUserId(1);
	  
	  if(optional.isPresent()) { user2=optional.get(); }
	  
	  Assertions.assertThat(user2).isNull(); }
	 
}

