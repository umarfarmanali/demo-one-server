package com.sensis.demo.one.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sensis.demo.one.persistence.entity.Student;
import com.sensis.demo.one.service.StudentService;

@RestController
public class StudentGetController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/student/all", method = RequestMethod.GET)
	public List<Student> getAll(){
		
		try {
			return studentService.getList();
		} catch(Exception e) {
			log.warn(e.getMessage());
			return new ArrayList<>();
		}
	}
}
