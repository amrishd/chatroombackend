package com.chatroom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User implements Serializable {
	
	@Column(name="FName")
	private String fName;
	
	@Column(name="LName")
	private String lName;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="DOB")
	private String dateofbirth;
	
	@Column(name="Gender")
	private char gender;
	
	@Column(name="City")
	private String city;
	
	@Column(name="Country")
	private String country;
	
	@Column(name="Mobile_No")
	private String mobileno;
	
	@Column(name="RegisteredOn")
    private String registeredon;
	
	@Id
	@Column(name="UserName")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Role")
	private String role;
	
	@Column(name="On_Line")
	private boolean online;
	
	@Column(name="Approved")
	private boolean enabled;
	
	User()
	{
		
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getRegisteredon() {
		return registeredon;
	}

	public void setRegisteredon(String registeredon) {
		this.registeredon = registeredon;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean getOnline() {
		return online;
	}

	public void setOnline(boolean b) {
		this.online = b;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
}
