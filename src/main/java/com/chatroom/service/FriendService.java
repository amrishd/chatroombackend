package com.chatroom.service;

import java.util.List;

import com.chatroom.model.Friend;
import com.chatroom.model.User;

public interface FriendService 
{

	List<User> listOfSugestedUsers(String username);

	void FriendRequest(String fromusername,String tousername);
	
	List<Friend> listOfPendingRequest(String tousername);

	void updatePendingRequest(String fromId, String toId, char status);

	List<Friend> listoffriends(String username);

}
