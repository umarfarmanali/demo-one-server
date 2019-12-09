package com.sensis.demo.one.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensis.demo.one.bean.Student;
import com.sensis.demo.one.bean.StudentRegistration;

@RestController
public class StudentUpdateController {

	@RequestMapping(value="/update/student", method = RequestMethod.PUT)
	public String updateStudentRecord(@RequestBody Student student) {
		return StudentRegistration.getInstance().update(student);
	}
}
