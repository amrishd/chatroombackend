package com.chatroom.daoImpl;

import java.util.List;



import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chatroom.dao.UserDAO;
import com.chatroom.model.User;
@Repository
public class UserDAOImpl implements UserDAO {
@Autowired
private SessionFactory sf;	
public void registration(User user) 
    {
		Session session=sf.openSession();
		session.save(user);
		session.flush();
		session.close();
		
	}
public List<User> getAllUsers() {
	Session session=sf.openSession();
	Query query=session.createQuery("from User");
	List<User> users=query.list();
	session.close();
	return users;
	
}
public User login(User user) {
	System.out.println(user.getUsername()+""+user.getPassword());
	Session session=sf.openSession();
	Query query=session.createQuery("From User u WHERE u.username=? and u.password=?");
	query.setString(0, user.getUsername());
	query.setString(1, user.getPassword());
	User validuser=(User)query.uniqueResult();
	session.close();
	return validuser;
}
public User updateUser(User validuser) {
	Session session =sf.openSession();
	session.update(validuser);
	session.flush();
	session.close();
	return  validuser;
}
public void enableUser(String username, boolean enabled) {
	Session session = sf.openSession();
	Transaction t = session.beginTransaction();
	User user = (User)session.get(User.class, username );
	user.setEnabled(enabled);
	t.commit();
	session.close();
	
}


}
