package com.chatroom.service;


import java.util.List;

import com.chatroom.model.Comment;

public interface CommentService {

 boolean addcomment(Comment com);
 List<Comment> getcommentblock(int id);

}
