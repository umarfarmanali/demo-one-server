package com.sensis.demo.one.dto;

public class UserInfoDto {

	private Integer id;
	
	private String username;
	private String password;
	
	private Integer active;
	
	public UserInfoDto(Integer id, String username, Integer active) {
		super();
		this.id = id;
		this.username = username;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}
}