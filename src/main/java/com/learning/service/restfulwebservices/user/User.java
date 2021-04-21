package com.learning.service.restfulwebservices.user;

import java.util.Date;

public class User {
	
	private Integer userId;
	
	private String userName;
	
	private Date birthDate;

	public User(Integer userId, String userName, Date birthDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", birthDate=" + birthDate + "]";
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
