package com.chatroom.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOB")
public class Job {
@Id
@GeneratedValue
private int jobid;

@Column(name="JobTitle")
private String jobtitle;

@Column(name="Description")
private String description;

@Column(name="CompanyName")
private String companyname;

@Column(name="Location")
private String location;

@Column(name="YearOfExperience")
private String yearsofexperience;

@Column(name="PostedBy")
private String postedby;

@Column(name="Status")
private Boolean status;

public Job()
{
	
}
public String getJobtitle() {
	return jobtitle;
}
public void setJobtitle(String jobtitle) {
	this.jobtitle = jobtitle;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCompanyname() {
	return companyname;
}
public void setCompanyname(String companyname) {
	this.companyname = companyname;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getYearsofexperience() {
	return yearsofexperience;
}
public void setYearsofexperience(String yearsofexperience) {
	this.yearsofexperience = yearsofexperience;
}
public String getPostedby() {
	return postedby;
}
public void setPostedby(String postedby) {
	this.postedby = postedby;
}
public Boolean getStatus() {
	return status;
}
public void setStatus(Boolean status) {
	this.status = status;
}


public int getJobid() {
	return jobid;
}
public void setJobid(int jobid) {
	this.jobid = jobid;
}
}
