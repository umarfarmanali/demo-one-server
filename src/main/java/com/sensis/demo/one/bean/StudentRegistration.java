package com.sensis.demo.one.bean;

import java.util.ArrayList;
import java.util.List;

public class StudentRegistration {

	private List<Student> studentRecords;
	
	private static StudentRegistration studentRegistration = null;
	
	private StudentRegistration() {
		studentRecords = new ArrayList<>();
	}
	
	public static StudentRegistration getInstance() {
		if(studentRegistration == null)
			studentRegistration = new StudentRegistration();
		return studentRegistration;
	}
	
	public void add(Student toAdd) {
		studentRecords.add(toAdd);
	}
	
	public String update(Student toUpdate) {
		
		for(int i=0; i<studentRecords.size(); i++) {
			if(studentRecords.get(i).getRegistrationNumber().equals(toUpdate.getRegistrationNumber())){
				studentRecords.set(i, toUpdate);
				
				return "update successful";
			}
		}
		
		return "update un-successful";
	}
	
	public String delete(String registrationNumber) {
		
		for(int i=0; i<studentRecords.size(); i++) {
			if(studentRecords.get(i).getRegistrationNumber().equals(registrationNumber)){
				studentRecords.remove(i);
				
				return "delete successful";
			}
		}
		
		return "delete un-successful";
	}

	public List<Student> getStudentRecords() {
		return studentRecords;
	}
}
