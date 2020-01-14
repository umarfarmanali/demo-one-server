package com.sensis.demo.one.service;

import java.util.List;

import com.sensis.demo.one.persistence.entity.Student;

public interface StudentService {

	public List<Student> getList();
	public void add(Student obj);
	public void update(Student obj);
	public void delete(String registrationNumber);
}
