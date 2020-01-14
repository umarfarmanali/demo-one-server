package com.sensis.demo.one.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sensis.demo.one.persistence.entity.UserInfo;
import com.sensis.demo.one.persistence.rep.UserInfoRepository;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Override
	public List<UserInfo> getList() {
		
		List<UserInfo> list = new ArrayList<>();
		userInfoRepository.findAll().forEach(obj -> list.add(obj));
		return list;
	}

	@Override
	public UserInfo getByUsername(String username) {
		return userInfoRepository.findByUsername(username);
	}

	@Override
	public void add(UserInfo obj) {
		userInfoRepository.save(obj);
	}

	@Override
	public void update(UserInfo obj) {
		userInfoRepository.save(obj);
		
	}

	@Override
	public void delete(Integer id) {
		userInfoRepository.deleteById(id);
	}
}