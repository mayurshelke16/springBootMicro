package com.neosoft.service;

import java.util.List;

import com.neosoft.model.User;

public interface UserService {

  
	public User saveDeatils(User user);

	public List<User> gatdata();

	public User getUser(Long userId);

	public void deleteId(Long UserId);

}
