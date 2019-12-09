package com.sensis.demo.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sensis.demo.one.service.StudentService;

@RestController
public class StudentDeleteController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/delete/student/{registrationNumber}")
	public String deleteStudentRecord(@PathVariable("registrationNumber") String registrationNumber) {
	
		try {
			if(registrationNumber != null && !registrationNumber.isEmpty()) {
				
				studentService.delete(registrationNumber);
				return "delete successful";
			} else {
				return "delete un-successful | parameter is empty";
			}
		} catch(Exception e) {
			e.printStackTrace();
			return "delete un-successful | exception: " + e.getMessage();
		}
	}
}
