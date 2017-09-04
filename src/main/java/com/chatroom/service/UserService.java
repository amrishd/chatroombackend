package com.chatroom.service;

import java.util.List;

import com.chatroom.model.User;

public interface UserService {
	

	void registration(User user);

	List<User> getAllUsers();

	User login(User user);

	User updateUser(User validuser);

	void enableUser(String username, boolean enabled);

}
