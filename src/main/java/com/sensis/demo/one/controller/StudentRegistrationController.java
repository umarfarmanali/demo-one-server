package com.sensis.demo.one.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sensis.demo.one.bean.Student;
import com.sensis.demo.one.bean.StudentRegistration;
import com.sensis.demo.one.bean.StudentRegistrationReply;

@Controller
public class StudentRegistrationController {

	@RequestMapping(value = "/register/student",method = RequestMethod.POST)
	@ResponseBody
	public StudentRegistrationReply registerStudent(@RequestBody Student student) {
		
		StudentRegistration.getInstance().add(student);
		
		StudentRegistrationReply reply = new StudentRegistrationReply();
		reply.setRegistrationNumber(student.getRegistrationNumber());
		reply.setName(student.getName());
		reply.setAge(student.getAge());
		reply.setRegistrationStatus("successful");
		return reply;
	}
}