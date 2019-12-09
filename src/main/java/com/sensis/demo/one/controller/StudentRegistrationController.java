package com.sensis.demo.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensis.demo.one.persistence.entity.Student;
import com.sensis.demo.one.service.StudentService;

@RestController
public class StudentRegistrationController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/register/student",method = RequestMethod.POST)
	public String registerStudent(@RequestBody Student student) {
		
		try {
			if(student != null) {
				
				studentService.add(student);
				return "add successful";
			} else {
				return "add un-successful | parameter is empty";
			}
		} catch(Exception e) {
			e.printStackTrace();
			return "add un-successful | exception: " + e.getMessage();
		}
	}
}