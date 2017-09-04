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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chatroom.model.Error;
import com.chatroom.model.Job;
import com.chatroom.model.User;
import com.chatroom.service.JobService;
@RestController
public class JobController {
	@Autowired
	JobService jser;
	@RequestMapping(value="/saveJob",method=RequestMethod.POST)
	public ResponseEntity<?> savejob(@RequestBody Job job,HttpSession session)
	{
		
		System.out.println(job.getCompanyname()+ " " + job.getDescription()+ " "+ job.getJobtitle() + " "+ job.getLocation());
		User use=(User) session.getAttribute("user");
		if(use==null)
		{
			Error error=new Error(1,"Unauthorized user");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		try
		{
			if(use.getRole().equals("admin"))
			{
				job.setStatus(true);
				job.setPostedby(use.getUsername());
				System.out.println("Hello ");
				jser.saveJob(job);
				return new ResponseEntity<Void>(HttpStatus.OK);
			}
			else
			{
			  Error error =new Error(3,"Access Denied");
			  return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e);
			Error error=new Error(4,"Unable to insert job details" + e.getMessage());
			return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
@RequestMapping(value="/getAllJobs",method=RequestMethod.GET)
public ResponseEntity<?> getalljobs(HttpSession session)
{
	User use=(User) session.getAttribute("user");
	if(use==null)
	{
		Error  error=new Error(1,"Unauthorised user");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	}
	   List<Job> jobs=jser.getAllJobs();
	   return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
}
@RequestMapping(value="/getjobbyid/{jobid}",method=RequestMethod.GET)
public ResponseEntity<?> getjobbyid( @PathVariable("jobid") int id,HttpSession session)
{
	User use=(User)session.getAttribute("user");
	if(use==null)
	{
		Error error=new Error(1,"Unauthorised user");
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	}
	List<Job> jobs=jser.getjobbyid(id);
	
	return new ResponseEntity<List<Job>>(jobs,HttpStatus.OK);
	
}

@RequestMapping(value="/updatejob",method=RequestMethod.POST)
public ResponseEntity<?> updatejob(@RequestBody Job job,HttpSession session)
{
	User use=(User) session.getAttribute("user");
	if(use==null)
	{
		Error error=new Error(1,"Unauthorised user");
         return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);	
	}
	jser.updatejob(job);
	return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	
}


}
		