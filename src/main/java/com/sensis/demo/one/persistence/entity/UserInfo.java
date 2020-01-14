package com.sensis.demo.one.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
public class UserInfo {

	public UserInfo() {}
	
	public UserInfo(String username, byte[] password, byte[] salt, Integer active) {
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.active = active;
	}

	@Id
	@Column(name = "id")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "username", unique = true)
	private String username;
	
	@Column(name = "password")
	private byte[] password;
	
	@Column(name = "salt")
	private byte[] salt;
	
	@Column(name = "active")
	private Integer active;
	
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
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	public byte[] getSalt() {
		return salt;
	}
	public void setSalt(byte[] salt) {
		this.salt = salt;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
}