package com.sensis.demo.one.service;

import java.util.List;

import com.sensis.demo.one.dto.UserInfoDto;

public interface UserService {

	public List<UserInfoDto> getList();
	public UserInfoDto getByUsername(String username);
	
	public void add(UserInfoDto obj) throws Exception;
	public void update(UserInfoDto obj);
	public void delete(Integer id);
	public void deleteByUsername(String username);
}
