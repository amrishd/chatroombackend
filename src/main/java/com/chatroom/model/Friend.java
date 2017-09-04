package com.chatroom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FRIEND")
public class Friend {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String FromId;
private String ToId;
private char status;
public Friend()
{
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFromId() {
	return FromId;
}
public void setFromId(String fromId) {
	FromId = fromId;
}
public String getToId() {
	return ToId;
}
public void setToId(String toId) {
	ToId = toId;
}
public char getStatus() {
	return status;
}
public void setStatus(char status) {
	this.status = status;
}
}
















































































