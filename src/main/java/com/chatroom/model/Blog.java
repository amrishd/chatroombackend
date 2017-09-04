package com.chatroom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Blog 
{
	@Id
	@GeneratedValue
    private int id;
	private String title;
	@Lob
	private String content;
    private String postedby;
    private String PostedOn;
    private char approved;  //Approved='Y' && not approved='N'
    public Blog()
    {
    	
    }
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostedby() {
		return postedby;
	}
	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}
	public String getPostedOn() {
		return PostedOn;
	}
	public void setPostedOn(String postedOn) {
		PostedOn = postedOn;
	}
	public char getApproved() {
		return approved;
	}
	public void setApproved(char approved) {
		this.approved = approved;
	}
	
}
