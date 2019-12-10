package com.sensis.demo.one.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sensis.demo.one.persistence.entity.Student;

public class StudentUpdateControllerTest extends AbstractControllerTest {

	@Test
	public void updateStudent() throws Exception{
		
		String uri = "/update/student";
		
		Student student = new Student("w90534", "Umar Ali", 36);
		
		String inputJson = super.mapToJson(student);
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content.equals("{\"message\":\"update successful\"}"));
	}
}
