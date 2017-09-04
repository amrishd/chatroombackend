package com.chatroom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatroom.dao.UserDAO;
import com.chatroom.model.User;
import com.chatroom.service.UserService;
@Service
public class UserSerImpl implements UserService {
@Autowired
UserDAO udao;
	
	public void registration(User user) 
	{
		udao.registration(user);
		
	}

	public List<User> getAllUsers() 
	{
	return udao.getAllUsers();
	
	}

	public User login(User user) {
		
		return udao.login(user);
	}

	public User updateUser(User validuser) {
		
		return udao.updateUser(validuser);
	}

	public void enableUser(String username, boolean enabled) {
		 udao.enableUser(username , enabled);
	}


}
