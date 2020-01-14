package com.sensis.demo.one.service;

import java.util.List;

import com.sensis.demo.one.persistence.entity.UserInfo;

public interface UserService {

	public List<UserInfo> getList();
	public UserInfo getByUsername(String username);
	
	public void add(UserInfo obj);
	public void update(UserInfo obj);
	public void delete(Integer id);
}
