package com.chatroom.dao;

import java.util.List;

import com.chatroom.model.Job;

public interface JobDAO {
	void saveJob(Job job);
	 List<Job> getAllJobs();
	  List<Job> getjobbyid(int id);
	boolean updatejob(Job job);

}
