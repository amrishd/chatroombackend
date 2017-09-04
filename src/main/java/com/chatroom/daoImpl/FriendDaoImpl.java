package com.chatroom.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import com.chatroom.dao.FriendDAO;
import com.chatroom.model.Friend;
import com.chatroom.model.User;
@Repository
public class FriendDaoImpl implements FriendDAO {
@Autowired
SessionFactory sessionFactory;
	public List<User> listOfSugestedUsers(String username) 
	{
	       Session session=sessionFactory.openSession();
	       
	       SQLQuery sqlquery=session.createSQLQuery("select * from USERS Where UserName in"
	                                               +"(select UserName from Users Where UserName!=? minus "
	                                               +"(select FromId from Friend Where ToId=? union "
	                                               +"select ToId from Friend Where FromId=?))");
	       sqlquery.setString(0, username);
	       sqlquery.setString(1, username);
	       sqlquery.setString(2, username);
	       sqlquery.addEntity(User.class);
	     
	       List<User>listOfSugestedUsers=sqlquery.list();
           
	       session.close();		
	       
	       return listOfSugestedUsers;
	       
	}
	public void FriendRequest(String fromusername, String tousername) 
	{
		 Session session=sessionFactory.openSession();
		 
		 Friend friend=new Friend();
		 
		 friend.setFromId(fromusername);
		 friend.setToId(tousername);
		 friend.setStatus('P');
		
		 session.save(friend);
		 session.flush();
		 session.close();
		
	}
	public List<Friend> listOfPendingRequest(String tousername)
	{
		Session session=sessionFactory.openSession();
		
		Query query=session.createQuery("From Friend Where toId=? and status=? ");
		
		query.setString(0,tousername);
		query.setCharacter(1,'P');
		
		List<Friend> pendingrequests=query.list();
		
		session.close();
		
		return pendingrequests;
	}
	public void updatePendingRequest(String fromId, String toId, char status) 
	{
		Session session=sessionFactory.openSession();
		
	    Query query=session.createQuery("From Friend Where fromId=? and toId=? ");
	    query.setString(0,fromId);
	    query.setString(1,toId);
	    
	    Friend friend=(Friend) query.uniqueResult();
	    
	    friend.setStatus(status);// status can be either a or p
	    
	    session.update(friend);
	    session.flush();
	    session.close();
	}
	public List<Friend> listoffriends(String username) 
	{
		Session session=sessionFactory.openSession();
		
		//Query query=session.createQuery("From Friend Where (fromId=? or toId=?) and status=?");
		SQLQuery query=session.createSQLQuery("Select * from USERS where username in ( Select ToId from Friend Where FromId=? and status='A' UNION select FromId from Friend where ToId=? and status='A')");
		query.setString(0,username);
		query.setString(1,username);
		//query.setCharacter(2,'A');
		
		List<Friend> friends=query.list();
		
		session.flush();
		session.close();
		return friends;
	
	}
	
	
	
  	
}
