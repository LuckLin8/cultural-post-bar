package com.cultural.bean;

public class User {
	private Integer userId;
	private String username;
	private String password;
	private Integer typeId;
	public User(String username, String password,  Integer typeId) {
		super();
		this.username = username;
		this.password = password;
		this.typeId = typeId;
	}

	public User() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
}
