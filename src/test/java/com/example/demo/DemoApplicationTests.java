package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class DemoApplicationTests {
	@Autowired
	private MockMvc mvc;

	@Test
	public void testHomepage() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/hello");
		this.mvc.perform(request)
				//.andExpect(status().isOk())
				.andExpect(content().string("Hello World"));
	}
}
