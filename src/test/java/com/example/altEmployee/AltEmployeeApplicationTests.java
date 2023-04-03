package com.example.altEmployee;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.altEmployee.Resource.EmployeeResource;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
class AltEmployeeApplicationTests {

	@Autowired
	private MockMvc mockMVC;
	private WebApplicationContext context;

	ObjectMapper ob = new ObjectMapper();

	List<EmployeeResource> resource = new ArrayList<EmployeeResource>();

	public void setUp() {
		mockMVC = MockMvcBuilders.webAppContextSetup(context).build();
	}


	@Test
	public void addData() throws Exception {
		EmployeeResource resource = new EmployeeResource();

		resource.setEmployeeId(805L);
		resource.setEmployeeName("Kiran");
		resource.setRoll("Embedded");
		resource.setSalary(15000L);

		String jsonRequest = ob.writeValueAsString(resource);

		MvcResult result = mockMVC.perform(
				post("/employee/addEmployee").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isCreated()).andReturn();
		
		  String contentAsString = result.getResponse().getContentAsString();
		  System.out.println(contentAsString);
	}
	
	@Test
	public void showAllData() throws Exception {
		MvcResult result = mockMVC.perform(get("/employee/getAllEmployee").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.[0].employeeId").value(801))
				.andExpect(jsonPath("$.[0].employeeName").value("ompi"))
				.andExpect(jsonPath("$.[0].roll").value("Engineer"))
				.andExpect(jsonPath("$.[0].salary").value(20000))
				
				.andExpect(jsonPath("$.[1].employeeId").value(802))
				.andExpect(jsonPath("$.[1].employeeName").value("syed"))
				.andExpect(jsonPath("$.[1].roll").value("Sales"))
				.andExpect(jsonPath("$.[1].salary").value(25000))
				
				.andReturn();
		
			String asString = result.getResponse().getContentAsString();
			
			System.out.println(asString);
	}

}
