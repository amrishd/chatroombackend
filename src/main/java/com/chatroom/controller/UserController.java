package com.chatroom.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatroom.model.Error;
import com.chatroom.model.User;
import com.chatroom.service.UserService;

@RestController
public class UserController {
@Autowired
UserService uservice;
@RequestMapping(value="/registration",method=RequestMethod.POST)
public ResponseEntity<?> registration(@RequestBody User user)
{
	
	try
	{
		user.setEnabled(true);
		List<User> users=uservice.getAllUsers();
		for(User u:users)
		{
			if(u.getUsername().equals(user.getUsername()))
			{   Error error=new Error(1,"user name already exists");
				return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
			}
               	
		}
		System.out.println(user.getUsername()+" "+user.getfName()+""+user.getEmail());
		uservice.registration(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	catch(Exception e)
	{  
		Error error=new Error(2,"cannnot register user details");
		return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@RequestMapping(value="/Login", method=RequestMethod.POST)
public ResponseEntity<?>login(@RequestBody User user,HttpSession session)
{
	System.out.println("Is Session new for user "+user.getUsername()+""+session.isNew());
	User validuser=uservice.login(user);
	if(validuser==null)
	{
		Error error =new Error(3,"Invalid username and password ...please enter valid credentials");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	}
	else
	{
		validuser.setOnline(true);
		validuser=uservice.updateUser(validuser);
		session.setAttribute("user",validuser);
		return new ResponseEntity<User>(validuser,HttpStatus.OK);		
	}

}
@RequestMapping(value="/logout",method=RequestMethod.GET)
public ResponseEntity<?>logout(HttpSession session)
{
	User user=(User)session.getAttribute("user");
	if(user==null)
	{
	  Error error=new Error(3,"Unaouthorized user");
	  return new  ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	  
	}
	else
		{
		System.out.println("Is Session new for user "+user.getUsername()+""+session.isNew());
		user.setOnline(true);
		uservice.updateUser(user);
		session.removeAttribute("user");
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);		

	    }
	
}
@RequestMapping(value="/updateUser",method=RequestMethod.POST)
public ResponseEntity<?>updateuser(@RequestBody User validuser)
{
	uservice.updateUser(validuser);
	return new ResponseEntity<User>(validuser,HttpStatus.OK);
	
}

@RequestMapping(value="/enableOrDisable" ,method=RequestMethod.GET)
public ResponseEntity<?> enableOrDisableUser(@RequestParam("username")String username , @RequestParam("enabled")boolean enabled)
{
	uservice.enableUser(username, enabled);
	return new ResponseEntity<Boolean>(true,HttpStatus.OK);
}


}