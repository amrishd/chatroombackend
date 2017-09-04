package com.chatroom.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.chatroom.model.Comment;
import com.chatroom.model.User;
import com.chatroom.service.CommentService;

@RestController
public class CommentController
{
	@Autowired
	CommentService comserv;
	@RequestMapping(value="/addComment",method=RequestMethod.POST)
	public ResponseEntity<?> addcomment(@RequestBody Comment com,HttpSession session)
	{
		User use=(User) session.getAttribute("user");
		if(use==null)
		{
			 Error error=new Error(1,"UnAuthorised user");
			 return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		DateFormat df= new SimpleDateFormat();
		Date date=new Date();		       
		com.setCommentBy(use.getEmail());
		com.setNameofperson(use.getfName());
		com.setCommentOn(df.format(date));
		
		boolean b=comserv.addcomment(com);
		return new ResponseEntity<Boolean>(b,HttpStatus.OK);
	}
 @RequestMapping(value="/getcommentblock/{blogId}",method=RequestMethod.GET)
 public ResponseEntity<?> getcommentBlock(@PathVariable ("blogId") int id,HttpSession session)
 {
	 User use=(User) session.getAttribute("user");
	 if(use==null)
	 {
		 Error error=new Error(1,"UnAuthorised User");
		 return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	 }
	 List<Comment> com=comserv.getcommentblock(id);
	 
	 return new ResponseEntity<List<Comment>>(com,HttpStatus.OK);
 }
 }
