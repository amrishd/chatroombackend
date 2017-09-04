package com.chatroom.dao;

import java.util.List;

import com.chatroom.model.Blog;

public interface BlogDAO 
{
  public boolean saveBlog(Blog blog);

public List<Blog> getallblogUsers();

public List<Blog> getallpendingBlogs();

public boolean  updbateBlog(Blog blog);

public boolean Enableordisable(int id, char status);


  
  
}
