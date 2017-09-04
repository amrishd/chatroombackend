package com.chatroom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatroom.dao.BlogDAO;
import com.chatroom.model.Blog;
import com.chatroom.service.BlogService;
@Service
public class BlogSerImpl implements BlogService 
{
  @Autowired
  BlogDAO bdao;
	public boolean saveBlog(Blog blog) 
    {
	
		return bdao.saveBlog(blog);
	}
	public List<Blog> getallblogUsers() {
		
		return bdao.getallblogUsers();
	}
	public List<Blog> getallpendingBlogs() {
		
		return bdao.getallpendingBlogs();
	}
	public boolean updateBlog(Blog blog) {
		
		return bdao.updbateBlog(blog);
	}
	public boolean Enableordisable(int id, char status) {
		
		return  bdao.Enableordisable(id,status);
	}
	
}
