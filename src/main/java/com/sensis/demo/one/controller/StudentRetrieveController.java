package com.sensis.demo.one.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sensis.demo.one.bean.Student;
import com.sensis.demo.one.bean.StudentRegistration;

@Controller
public class StudentRetrieveController {

	@RequestMapping(value = "/student/allstudent", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> getAllStudents(){
		return StudentRegistration.getInstance().getStudentRecords();
	}
}
