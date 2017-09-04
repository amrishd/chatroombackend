package com.chatroom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatroom.dao.JobDAO;
import com.chatroom.model.Job;
import com.chatroom.service.JobService;
@Service
public class JobSerImpl implements JobService {
@Autowired
JobDAO jdao;
	public void saveJob(Job job)
    {
		jdao.saveJob(job);
		
	}
	public List<Job> getAllJobs() 
	{
		
		return jdao.getAllJobs();
	}
	public List<Job> getjobbyid(int id) 
	{

		return jdao.getjobbyid(id);
	}
	public   boolean updatejob(Job job) {
		
		return jdao.updatejob(job);
	}
	

}
