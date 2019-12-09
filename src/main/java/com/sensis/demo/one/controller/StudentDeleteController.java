package com.sensis.demo.one.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sensis.demo.one.bean.StudentRegistration;

@RestController
public class StudentDeleteController {

	@RequestMapping(value="/delete/student/{registrationNumber}")
	public String deleteStudentRecord(@PathVariable("registrationNumber") String registrationNumber) {
		return StudentRegistration.getInstance().delete(registrationNumber);
	}
}
