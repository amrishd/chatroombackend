package com.chatroom.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatroom.dao.CommentDAO;
import com.chatroom.model.Comment;
import com.chatroom.service.CommentService;
@Service
public class CommentSerImpl implements CommentService {
 @Autowired
 CommentDAO comdao;
	public boolean addcomment(Comment com) {
		
		return comdao.addcomment(com);
	}
	public List<Comment> getcommentblock(int id) {
		
		return comdao.getcommentblock(id);
	}

}
