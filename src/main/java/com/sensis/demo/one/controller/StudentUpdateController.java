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
public class StudentUpdateController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/update/student", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public String updateStudentRecord(@RequestBody Student student) {
		
		String returnMessage;
		try {
			if(student != null) {
				
				studentService.update(student);
				returnMessage = "update successful";
			} else {
				returnMessage = "update un-successful | parameter is empty";
			}
		} catch(Exception e) {
			e.printStackTrace();
			returnMessage = "update un-successful | exception: " + e.getMessage();
		}
		return "{\"message\":\"" + returnMessage + "\"}";
	}
}
