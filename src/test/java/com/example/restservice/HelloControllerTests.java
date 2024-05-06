package com.example.restservice;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getHello() throws Exception {
		var req = MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(req)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World!")));
	}
}
