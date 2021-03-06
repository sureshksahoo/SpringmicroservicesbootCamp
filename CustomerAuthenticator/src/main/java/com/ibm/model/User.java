package com.ibm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	@Column
	@GeneratedValue
	@Id
	private int userId;
	@Column 
	private String userName;
	@Column 
	private String password;
	@Column 
	private String role;
	public User() {}
	public User(int userId, String userName, String password, String role) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public int getUserid() {
		return userId;
	}
	public void setUserid(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
	
	

}
