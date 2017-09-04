package com.chatroom.daoImpl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chatroom.dao.JobDAO;
import com.chatroom.model.Job;
@Repository
public class JobDaoImpl implements JobDAO {
@Autowired
SessionFactory sf;



	public void saveJob(Job job)
	{
		Session session=sf.openSession();
		Transaction t = session.beginTransaction();
		System.out.println("tgtgyvgvtv");
		session.save(job);
		t.commit();
		session.flush();
		session.close();
	}
	public List<Job> getAllJobs()
	{
		Session session=sf.openSession();
		Query query=session.createQuery("From Job");
		List<Job> jobs=query.list();
		session.flush();
		session.close();
		return jobs;
	}
	public List<Job> getjobbyid(int id) {
		Session session=sf.openSession();
		Query query=session.createQuery("From Job Where jobid=:id");
		query.setParameter("id" , id);
		List<Job> jobs=query.list();
		session.flush();
		session.close();
		return jobs;
		
	}
	public boolean updatejob(Job job) 
	{
		Session session=sf.openSession();
	     session.update(job);
	     session.flush();
	     session.close();
	     return true;
	
	}

}
