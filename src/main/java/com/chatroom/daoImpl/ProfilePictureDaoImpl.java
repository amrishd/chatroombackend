/*package com.chatroom.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chatroom.dao.ProfilePictureDAO;
import com.chatroom.model.ProfilePicture;
@Repository
public class ProfilePictureDaoImpl implements ProfilePictureDAO 
{
    @Autowired
     private SessionFactory sessionfactory;
	public void saveProfilePicture(ProfilePicture profilepicture) 
	{
		Session session=sessionfactory.openSession();
	 	session.save(profilepicture);
	 	session.flush();
	 	session.close();
	}

	public ProfilePicture getProfilePicture(String username) 
	{
		Session session=sessionfactory.openSession();
		ProfilePicture profilePicture=(ProfilePicture) session.get(ProfilePicture.class,username);
		session.close();
		return profilePicture;
	}

}*/
