package com.chatroom.service;

import java.util.List;

import com.chatroom.model.Job;

public interface JobService {
  void saveJob(Job job);
  List<Job> getAllJobs();
  List<Job> getjobbyid(int id);
  boolean updatejob(Job job);
}
