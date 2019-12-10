package com.sensis.demo.one.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sensis.demo.one.persistence.entity.Student;

public class StudentGetControllerTest extends AbstractControllerTest {

	@Override
	@Before
	public void setup() {
		super.setUp();
	}
	
	@Test
	public void getAllStudents() throws Exception{
		
		String uri = "/student/allstudent";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		Student[] studentArr = super.mapFromJson(content, Student[].class);
		assertTrue(studentArr.length > 0);
	}
}
