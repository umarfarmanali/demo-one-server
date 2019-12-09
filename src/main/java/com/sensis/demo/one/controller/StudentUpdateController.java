package com.sensis.demo.one.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sensis.demo.one.bean.Student;
import com.sensis.demo.one.bean.StudentRegistration;

@Controller
public class StudentUpdateController {

	@RequestMapping(value="/update/student", method = RequestMethod.PUT)
	@ResponseBody
	public String updateStudentRecord(@RequestBody Student student) {
		return StudentRegistration.getInstance().update(student);
	}
}
