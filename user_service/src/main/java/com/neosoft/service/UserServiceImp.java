package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.User;
import com.neosoft.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveDeatils(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public List<User> gatdata() {
		return userRepository.findAll();
	}

	

	@Override
	public User getUser(Long userId) {
		return userRepository.findById(userId).get(); 
	}

	

	@Override
	public void deleteId(Long userId) {
		userRepository.deleteById(userId); 
		
	}

}
