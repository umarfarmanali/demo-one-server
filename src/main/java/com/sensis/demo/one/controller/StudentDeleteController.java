package com.sensis.demo.one.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sensis.demo.one.bean.StudentRegistration;

@Controller
public class StudentDeleteController {

	@RequestMapping(value="/delete/student/{registrationNumber}")
	@ResponseBody
	public String deleteStudentRecord(@PathVariable("registrationNumber") String registrationNumber) {
		return StudentRegistration.getInstance().delete(registrationNumber);
	}
}
