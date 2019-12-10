package com.sensis.demo.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensis.demo.one.persistence.entity.Student;
import com.sensis.demo.one.service.StudentService;

@RestController
public class StudentAddController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/add/student", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addStudent(@RequestBody Student student) {
		
		String returnMessage;
		try {
			if(student != null) {
				
				studentService.add(student);
				returnMessage = "add successful";
			} else {
				returnMessage = "add un-successful | parameter is empty";
			}
		} catch(Exception e) {
			e.printStackTrace();
			returnMessage = "add un-successful | exception: " + e.getMessage();
		}
		return "{\"message\":\"" + returnMessage + "\"}";
	}
}