package com.chatroom.controller;

import java.io.BufferedOutputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import com.chatroom.model.User;


@Controller
public class ProfilePictureController {
/*@Autowired
private ProfilePictureService pser;
@RequestMapping(value="/uploadprofilepic",method=RequestMethod.POST)
public ResponseEntity<?>uploadprofilepic(@RequestParam CommonsMultipartFile image,HttpSession session )
{
   User user=(User) session.getAttribute("user");	
    if(user==null)
    {
    	Error error=new Error(1,"UnAuthorized user");
    	return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
    }
   ProfilePicture profilepicture=new ProfilePicture();
   profilepicture.setUsername(user.getUsername());
   profilepicture.setImage(image.getBytes());
   pser.saveProfilePicture(profilepicture);
   return new ResponseEntity<Void>(HttpStatus.OK);
}
@RequestMapping(value="/getimage/{username}",method=RequestMethod.GET)
public @ResponseBody byte[] getProfilePic(@PathVariable String username,HttpSession session)
{
	User user=(User) session.getAttribute("user");
	if(user==null)
		return null;
	else
	{
		ProfilePicture profilepic=pser.getProfilePicture(username);
		if(profilepic==null)
			return null;
		else
			return profilepic.getImage();
	}
}*/
@RequestMapping(value="/addImage",method=RequestMethod.POST)
public ResponseEntity<?> addimage(@RequestParam CommonsMultipartFile image,HttpSession session) throws IOException
{
	if(!session.isNew())
	{
		User use=(User) session.getAttribute("user");
		String path="D:\\DT2\\chatroom\\src\\main\\resources\\images\\";
	    path=path+use.getUsername()+".jpg";
	    File f=new File(path);
	    byte[] b=image.getBytes();
	    FileOutputStream fos=new FileOutputStream(f);
	    BufferedOutputStream bos=new BufferedOutputStream(fos);
	    bos.write(b);
	    bos.close();
	  /* HttpHeaders headers=new HttpHeaders();
	    headers.add("Location","/chatroomfrontend/#!/user/account");
	   return new ResponseEntity<String>(headers,HttpStatus.FOUND);*/
	}
	session.invalidate();
	Error error = new Error("Please Log In to Upload File");
	return new ResponseEntity<Error>(error , HttpStatus.UNAUTHORIZED);
	
	
	
}
@RequestMapping(value="/getPic/{username}/")
public @ResponseBody byte[] getPic(@PathVariable String username , HttpSession session) throws IOException
{
		String path ="D:\\DT2\\chatroom\\src\\main\\resources\\images\\";
		try{
			String path1= path+ username+ ".jpg";
			File file = new File(path1);
			byte[] b = Files.readAllBytes(file.toPath());
			return b;
		}catch(Exception e) //if image not present
		{
			String path2 = path +"default.jpg";
			File file = new File(path2);
			byte[] b = Files.readAllBytes(file.toPath());
			return b;
		}
}
}



