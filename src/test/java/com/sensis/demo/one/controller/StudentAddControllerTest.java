package com.sensis.demo.one.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sensis.demo.one.persistence.entity.Student;

public class StudentAddControllerTest extends AbstractControllerTest {

	@Override
	@Before
	public void setup() {
		super.setUp();
	}
	
	@Test
	public void addStudent() throws Exception{
		
		String uri = "/add/student";
		
		Student studentToAdd = new Student("w90534", "Umar Ali", 35);
		
		String inputJson = super.mapToJson(studentToAdd);
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content.equals("add successful"));
	}
}
