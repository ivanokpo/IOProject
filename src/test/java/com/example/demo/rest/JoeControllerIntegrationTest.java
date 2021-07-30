package com.example.demo.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.user.Joe;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //tries a random port until it works

@AutoConfigureMockMvc

@Sql
(scripts = { "classpath:joe-schema.sql","classpath:joe-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test") // sets profile for the test class
public class JoeControllerIntegrationTest {
	
	@Autowired 
	private MockMvc mockMVC;

	@Autowired
	private ObjectMapper mapper; 

	@Test
	void testCreate() throws Exception {
		
		Joe testJoe = new Joe(1000,"Donald Trump","war",3,"yes");
		// convert to json
		String testJoeAsJSON = this.mapper.writeValueAsString(testJoe);

		System.out.println(testJoe);
		System.out.println(testJoeAsJSON);

		
		RequestBuilder request = post("/createPodcast").contentType(MediaType.APPLICATION_JSON).content(testJoeAsJSON);

		
		Joe testCreatedJoe = new Joe(1000,"Donald Trump","war",3,"yes");
		testCreatedJoe.setId(1); 
		String testCreatedJoeAsJSON = this.mapper.writeValueAsString(testCreatedJoe);
		
		ResultMatcher checkStatus = status().is(201);
		ResultMatcher checkBody = content().json(testCreatedJoeAsJSON);
		
		
		
		
		
		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	
	@Test
	void testDelete() throws Exception {
		
		RequestBuilder request = delete("/deletePodcast/1");
		
		ResultMatcher checkStatus = status().is(204);
		ResultMatcher checkBody = content().string("Deleted: 1");
		
		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testUpdate() throws Exception{
		Joe updateJoe = new Joe(1000,"Donald Trump","war",3,"yes");
		
		Joe checkJoe = new Joe(1000,"Donald Trump","war",3,"yes");
		checkJoe.setId(2);
		
		String checkJoeAsJSON = this.mapper.writeValueAsString(checkJoe);
		String updateJoeAsJSON = this.mapper.writeValueAsString(updateJoe);
		
		RequestBuilder request = put("/updatePodcast/2").contentType(MediaType.APPLICATION_JSON).content(updateJoeAsJSON);
		
		ResultMatcher checkStatus = status().is(202);
		ResultMatcher checkBody = content().json(checkJoeAsJSON);
		
		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	
	}
	
	@Test
	void testGetJoe() throws Exception {
		
	
		Joe testJoe = new Joe(1664,"Josh Dubin","Activists", 5, "yes");
		testJoe.setId(1);
		String testJoeAsJSON = this.mapper.writeValueAsString(testJoe);		
		RequestBuilder request = get("/getPodcastId/1");
		
		ResultMatcher checkStatus = status().is(200);
		
		ResultMatcher checkBody = content().json(testJoeAsJSON);
		
		this.mockMVC.perform(request).andExpect(checkStatus).andExpect(checkBody);
	
	
	
	
	}
}
