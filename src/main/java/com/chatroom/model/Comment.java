package com.chatroom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Comments")
public class Comment
{
	
	
	@Id
	@GeneratedValue
     private int Commentid;
	 private int blogId;
	 private String comments;
     private String CommentBy;
     private String  CommentOn;
     private String nameofperson;
     public Comment()
     {
    	 
     }
     public int getCommentid()
     {
		return Commentid;
	 }
	public void setCommentid(int commentid) {
		Commentid = commentid;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCommentBy() {
		return CommentBy;
	}
	public void setCommentBy(String commentBy) {
		CommentBy = commentBy;
	}
	public String getCommentOn() {
		return CommentOn;
	}
	public void setCommentOn(String commentOn) {
		CommentOn = commentOn;
	}
	public String getNameofperson() {
		return nameofperson;
	}
	public void setNameofperson(String nameofperson) {
		this.nameofperson = nameofperson;
	}
}
