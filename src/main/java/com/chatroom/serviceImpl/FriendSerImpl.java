package com.chatroom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatroom.dao.FriendDAO;
import com.chatroom.model.Friend;
import com.chatroom.model.User;
import com.chatroom.service.FriendService;

@Service
public class FriendSerImpl implements FriendService
{
	@Autowired

	FriendDAO fdao;
	
	public List<User> listOfSugestedUsers(String username) 
	{
		
		return fdao.listOfSugestedUsers(username);
	
	}
	
	public void FriendRequest(String fromusername, String tousername) 
	{
		  
		fdao.FriendRequest(fromusername,tousername);		
	
	}

	public List<Friend> listOfPendingRequest(String tousername) 
	{
		
		return fdao.listOfPendingRequest(tousername);
	}

	public void updatePendingRequest(String fromId, String toId, char status) 
	{
		fdao.updatePendingRequest(fromId, toId, status);
		
	}

	public List<Friend> listoffriends(String username) 
	{
		
		return fdao.listoffriends(username);
	}

}
