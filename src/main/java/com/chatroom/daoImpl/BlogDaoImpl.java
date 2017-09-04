package com.chatroom.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chatroom.dao.BlogDAO;
import com.chatroom.model.Blog;
@Repository
public class BlogDaoImpl implements BlogDAO 
{
    @Autowired
	SessionFactory sf;
    
    public boolean saveBlog(Blog blog) 
	{
	   Session session=sf.openSession();
	   try
	   {
		   session.save(blog);
		   session.flush();
		   session.close();
		   return true;
		   
	   }
	   catch(Exception e)
	   {
		   session.close();
		  System.out.println(e);	
	   }
	return false;
   }

	public List<Blog> getallblogUsers() 
	{
		Session session=sf.openSession();
		Query query=session.createQuery("From Blog Where approved='Y' ");
		List <Blog> bloguser=query.list();
		session.flush();
		session.close();
		return bloguser;
	}

	public List<Blog> getallpendingBlogs()
	{   
		Session session=sf.openSession();
		try
		{
		Query query=session.createQuery("From Blog Where approved='N'");
		List<Blog> bloguser=query.list();
		session.close();
		return bloguser;
		}
		catch(Exception e)
		{
			session.close();
			System.out.println(e);
		    
		}
		return null;
		
		
		
	}

	
	public boolean updbateBlog(Blog blog) 
	{
	
		Session session=sf.openSession();
		try
		{
			session.update(blog);
			session.flush();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			session.close();
			System.out.println(e);
		}
		
		return false;
	}

	public boolean Enableordisable(int id, char status) 
	{
		Session session=sf.openSession();
		try
		{
			Transaction t= session.beginTransaction();
			Blog b =(Blog) session.get(Blog.class, id);
			b.setApproved('y');
			t.commit();
			session.close();
			return true;
		}
		catch(Exception e)
		{
			session.close();
			System.out.println(e);
		}
		return false;
	}

     

}
