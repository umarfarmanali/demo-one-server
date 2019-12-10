package com.sensis.demo.one.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class StudentDeleteControllerTest extends AbstractControllerTest {

	@Test
	public void deleteStudent() throws Exception{
		
		String uri = "/delete/student/w90534";
		
//		Student studentToAdd = new Student("w90534", "Umar Ali", 35);
		
//		String inputJson = super.mapToJson(studentToAdd);
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content.equals("{\"message\":\"delete successful\"}"));
	}
}
