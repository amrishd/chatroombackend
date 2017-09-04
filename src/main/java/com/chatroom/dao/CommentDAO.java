package com.chatroom.dao;



import java.util.List;

import com.chatroom.model.Comment;

public interface CommentDAO 
{
   boolean addcomment(Comment com);
   List<Comment> getcommentblock(int id);
}
