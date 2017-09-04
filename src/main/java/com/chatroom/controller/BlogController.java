package com.chatroom.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.chatroom.model.Blog;
import com.chatroom.model.User;
import com.chatroom.service.BlogService;

@RestController
public class BlogController
{
   @Autowired
   BlogService bser;
   
   @RequestMapping(value="/SaveBlog",method=RequestMethod.POST)
   public ResponseEntity<?> saveblog(@RequestBody Blog blog,HttpSession session)
   {
	  User use=(User) session.getAttribute("user");
	  if(use==null)
	  {
		  Error error=new Error(1,"UnAuthorised User");
	      return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	  }
	  System.out.println(blog.getContent());
	  blog.setPostedby(use.getUsername());
	  DateFormat df= new SimpleDateFormat();
	  Date date=new Date();
	  blog.setPostedOn(df.format(date));
	  blog.setApproved('N');
	  boolean b=bser.saveBlog(blog);
	  if(b==true)
	  {
		  return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	  }
	  else
	  {
		  Error error=new Error(1,"Intrenal server error");
	    return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	  }
   }
@RequestMapping(value="/getAllBlogUsers",method=RequestMethod.GET)
public ResponseEntity<?> getallblogUsers(HttpSession session)
{ 
	User user=(User) session.getAttribute("user");
	if(user==null)
	{
		Error error=new Error(1,"UnAuthorized user");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	}
	List<Blog> blog=bser.getallblogUsers();
	return new ResponseEntity<List<Blog>>( blog,HttpStatus.OK);
	
}
@RequestMapping(value="/getAllPendingBlogs",method=RequestMethod.GET)
public ResponseEntity<?> getallpendingBlogs(HttpSession session)
{
	User use=(User) session.getAttribute("user");
	if(use==null)
	{
		Error error=new Error(1,"UnAuthorized User");
	    return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	}
	List<Blog> blogs=bser.getallpendingBlogs();
	return new ResponseEntity<List<Blog>>(blogs,HttpStatus.OK);
	
}
@RequestMapping(value="/UpdateBlog",method=RequestMethod.POST)
public ResponseEntity<?> updateBlog(@RequestBody Blog blog,HttpSession session)
{
	System.out.println(blog);
	User user=(User) session.getAttribute("user");
	if(user==null)
	{
		Error error=new Error(1,"UnAuthorized User");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	}
	bser.updateBlog(blog);
	
	return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	
}
@RequestMapping(value="/EnableorDisable", method=RequestMethod.GET)
public ResponseEntity<?>enableordisable(@RequestParam("id") int id,@RequestParam("status") char status, HttpSession session)
{
	User user=(User) session.getAttribute("user");
	if(user==null)
	{
	   Error error=new Error(1,"UnAuthorized User");
	   return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	   
	}
	
	boolean b=bser.Enableordisable(id,status);
	if(b==true)
	{
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
	else
	{
		Error error= new Error(2, "please login and try again later");
		return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
	}
	
}

}
