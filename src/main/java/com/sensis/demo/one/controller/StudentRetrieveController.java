package com.sensis.demo.one.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensis.demo.one.bean.Student;
import com.sensis.demo.one.bean.StudentRegistration;

@RestController
public class StudentRetrieveController {

	@RequestMapping(value = "/student/allstudent", method = RequestMethod.GET)
	public List<Student> getAllStudents(){
		return StudentRegistration.getInstance().getStudentRecords();
	}
}
