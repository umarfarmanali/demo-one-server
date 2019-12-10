package com.sensis.demo.one.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensis.demo.one.service.StudentService;

@RestController
public class StudentDeleteController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/delete/student/{registrationNumber}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteStudentRecord(@PathVariable("registrationNumber") String registrationNumber) {
	
		String returnMessage;
		try {
			if(registrationNumber != null && !registrationNumber.isEmpty()) {
				
				studentService.delete(registrationNumber);
				returnMessage = "delete successful";
			} else {
				returnMessage = "delete un-successful | parameter is empty";
			}
		} catch(Exception e) {
			e.printStackTrace();
			returnMessage = "delete un-successful | exception: " + e.getMessage();
		}
		return "{\"message\":\"" + returnMessage + "\"}";
	}
}
