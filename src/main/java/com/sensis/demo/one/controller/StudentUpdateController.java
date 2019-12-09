package com.sensis.demo.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="/update/student", method = RequestMethod.PUT)
	public String updateStudentRecord(@RequestBody Student student) {
		
		try {
			if(student != null) {
				
				studentService.update(student);
				return "update successful";
			} else {
				return "update un-successful | parameter is empty";
			}
		} catch(Exception e) {
			e.printStackTrace();
			return "update un-successful | exception: " + e.getMessage();
		}
	}
}
