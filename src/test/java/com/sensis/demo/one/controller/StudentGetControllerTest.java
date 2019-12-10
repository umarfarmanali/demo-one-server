package com.sensis.demo.one.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sensis.demo.one.persistence.entity.Student;

public class StudentGetControllerTest extends AbstractControllerTest {

	@Test
	public void getAllStudents() throws Exception{
		
		String uri = "/student/allstudent";
		
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		Student[] studentArr = mapFromJson(content, Student[].class);
		assertTrue(studentArr.length > 0);
	}
	
//	 @Test
//	  public void findsTaskById() throws Exception {
//	        mockMvc.perform(get("/tasks/1"))
//	                .andDo(print())
//	                .andExpect(status().isOk())
//	                .andExpect(content().json("{\"id\":1,\"title\":\"delectus aut autem\",\"userId\":1,\"completed\":false}"));
//	    }
}
