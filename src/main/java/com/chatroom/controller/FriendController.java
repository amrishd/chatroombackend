package com.chatroom.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chatroom.model.Error;
import com.chatroom.model.Friend;
import com.chatroom.model.User;
import com.chatroom.service.FriendService;

@RestController
public class FriendController 
{
   @Autowired
   
   FriendService fser;

   @RequestMapping(value="/listOfSugestedUsers",method=RequestMethod.GET)

   public ResponseEntity<?> getSugestedUsersList(HttpSession session)
   {
	   User use=(User) session.getAttribute("user");
	   if(use==null)
	   {
		   Error error=new Error(1,"UnAuthorized User");
		   return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	   }
	   
	   List<User> sugesteduser=fser.listOfSugestedUsers(use.getUsername());
	   return new ResponseEntity<List<User>>(sugesteduser,HttpStatus.OK);
	
   }
   
   @RequestMapping(value="/FriendRequest/{tousername}",method=RequestMethod.GET)
   public ResponseEntity<?> friendrequest(@PathVariable String tousername,HttpSession session)
   {
	   User use=(User) session.getAttribute("user");
	   if(use==null)
	   {
		   Error error=new Error(1,"UnAuthorized User");
		   return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	   }
	  
	   String fromusername=use.getUsername();
	  
	   fser.FriendRequest(fromusername, tousername);
	  
	   return new ResponseEntity<Void>(HttpStatus.OK);
	   
   }
   
   @RequestMapping(value="/PendingRequest",method=RequestMethod.GET)
   public ResponseEntity<?> pendingrequest(HttpSession session)
   {
	   User use=(User) session.getAttribute("user");
	   if(use==null)
	   {
		   Error error=new Error(1,"UnAuthorized user");
		   return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	   }
	   
	   List<Friend> pendingrequests=fser.listOfPendingRequest(use.getUsername());
	   return new ResponseEntity<List<Friend>>(pendingrequests,HttpStatus.OK);
	   
	   
	}
   @RequestMapping(value="/updatePendingRequest/{FromId}/{status}",method=RequestMethod.PUT)
   public ResponseEntity<?> updatePendingRequests(@PathVariable ("FromId") String fromId,@PathVariable ("status") char status,HttpSession session)
   {
	   User use=(User) session.getAttribute("user");
	    
	   if(use==null)
	   {
		   Error error=new Error(1,"UnAuthorized  user");
		   return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	   }
	   
	   fser.updatePendingRequest(fromId,use.getUsername(),status);
	  
	   return new ResponseEntity<Void>(HttpStatus.OK);
	   
   }
   
   @RequestMapping(value="/LisOfFriends",method=RequestMethod.GET)
   public ResponseEntity<?> listoffriends(HttpSession session)
   {
	   System.out.println("Hello");
	   User users =(User)session.getAttribute("user");
	  if(users==null)
	  {
		  Error error=new Error(1,"UnAuthorized User");
		  return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	  }
	    List<Friend> friends=fser.listoffriends(users.getUsername());
	   return new ResponseEntity<List<Friend>>(friends,HttpStatus.OK);
	   
   }
}
