package com.sensis.demo.one.service;

import java.util.List;

import com.sensis.demo.one.persistence.entity.Student;

public interface StudentService {

	public List<Student> getStudentList();
	public void add(Student student);
	public void update(Student student);
	public void delete(String registrationNumber);
}
