package com.sensis.demo.one.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensis.demo.one.persistence.entity.Student;
import com.sensis.demo.one.persistence.rep.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getStudentList() {
		
		List<Student> studentList = new ArrayList<Student>();
		studentRepository.findAll().forEach(student -> studentList.add(student));
		
		return studentList;
	}

	@Override
	public void add(Student student) {
		
		studentRepository.save(student);
	}

	@Override
	public void update(Student student) {
		
		studentRepository.save(student);
	}

	@Override
	public void delete(String registrationNumber) {
		
		studentRepository.deleteById(registrationNumber);
	}

}
