package com.chatroom.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chatroom.dao.CommentDAO;
import com.chatroom.model.Comment;
@Repository
public class CommentDaoImpl implements CommentDAO {
@Autowired
SessionFactory sf;
	public boolean addcomment(Comment com) 
	{
		Session session=sf.openSession();
		session.save(com);	
		session.flush();
		session.close();
	     return true;
	}
    public List<Comment> getcommentblock(int id)
    {
    	Session session=sf.openSession();
    	Query query=session.createQuery("From Comment where blogId=?");
        query.setInteger(0, id);
    	List<Comment> com=query.list();
        session.flush();
        session.close();
        return com;
    }
}
