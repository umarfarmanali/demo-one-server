package com.sensis.demo.one.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sensis.demo.one.dto.UserInfoDto;
import com.sensis.demo.one.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/all")
	public List<UserInfoDto> getAll(){
		
		try {
			return userService.getList();
		} catch(Exception e) {
			log.warn(e.getMessage());
			return new ArrayList<>();
		}
	}
	
	@GetMapping(value = "/byUsername/{username}")
	public UserInfoDto getByUsername(@PathVariable("username") String username){
		
		try {
			return userService.getByUsername(username);
		} catch(Exception e) {
			log.warn(e.getMessage());
			return null;
		}
	}
	
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public String addStudent(@RequestBody UserInfoDto obj) {
		
		String returnMessage;
		try {
			if(obj != null) {
				
				userService.add(obj);
				returnMessage = "add successful";
			} else {
				returnMessage = "add un-successful | parameter is empty";
			}
		} catch(Exception e) {
			log.warn(e.getMessage());
			returnMessage = "add un-successful | exception: " + e.getMessage();
		}
		return "{\"message\":\"" + returnMessage + "\"}";
	}
	
	@DeleteMapping(value="/delete/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteStudentRecord(@PathVariable("username") String username) {
	
		String returnMessage;
		try {
			if(username != null && !username.isEmpty()) {
				
				userService.deleteByUsername(username);
				returnMessage = "delete successful";
			} else {
				returnMessage = "delete un-successful | parameter is empty";
			}
		} catch(Exception e) {
			log.warn(e.getMessage());
			returnMessage = "delete un-successful | exception: " + e.getMessage();
		}
		return "{\"message\":\"" + returnMessage + "\"}";
	}
}
