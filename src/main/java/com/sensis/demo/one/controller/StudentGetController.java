package com.sensis.demo.one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensis.demo.one.persistence.entity.Student;
import com.sensis.demo.one.service.StudentService;

@RestController
public class StudentGetController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/student/allstudent", method = RequestMethod.GET)
	public List<Student> getAllStudents(){
		
		try {
			return studentService.getStudentList();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
