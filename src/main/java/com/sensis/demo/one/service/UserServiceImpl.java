package com.sensis.demo.one.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensis.demo.one.dto.UserInfoDto;
import com.sensis.demo.one.persistence.entity.UserInfo;
import com.sensis.demo.one.persistence.rep.UserInfoRepository;
import com.sensis.demo.one.util.PasswordUtil;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Override
	public List<UserInfoDto> getList() {
		
		List<UserInfoDto> list = new ArrayList<>();
		userInfoRepository.findAll().forEach(obj -> list.add(convertFromEntityToDto(obj)));
		return list;
	}

	@Override
	public UserInfoDto getByUsername(String username) {
		return convertFromEntityToDto(userInfoRepository.findByUsername(username));
	}

	@Override
	public void add(UserInfoDto obj) throws Exception {
		
		
		userInfoRepository.save(convertFromDtoToEntity(obj));
	}

	@Override
	public void update(UserInfoDto obj) {
	
	}

	@Override
	public void delete(Integer id) {
		userInfoRepository.deleteById(id);
	}
	
	public void deleteByUsername(String username) {
		userInfoRepository.deleteByUsername(username);
	}
	
	private UserInfo convertFromDtoToEntity(UserInfoDto dto) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		byte[] salt = PasswordUtil.generateSalt();
		byte[] encryptedPassword = PasswordUtil.encryptPassword(dto.getPassword(), salt);
		
		return new UserInfo(dto.getUsername(), encryptedPassword, salt, dto.getActive());
	}
	
	private UserInfoDto convertFromEntityToDto(UserInfo entity) {
		
		return new UserInfoDto(entity.getId(), entity.getUsername(), entity.getActive());
	}
}