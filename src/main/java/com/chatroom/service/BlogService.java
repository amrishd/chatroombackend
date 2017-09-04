package com.chatroom.service;


import java.util.List;

import com.chatroom.model.Blog;


public interface BlogService {

	boolean saveBlog(Blog blog);

	List<Blog> getallblogUsers();

	List<Blog> getallpendingBlogs();

	boolean updateBlog(Blog blog);

	boolean Enableordisable(int id, char status);

	

	

	



}
