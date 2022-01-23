package com.gloria.registeration.web;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
class EventRegisterControllerTest {


	@Autowired
	EventRegisterController controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void whenPostRequestToRegister_thenCorrectResponse() throws Exception {
		String user = "{\n\t\"eventCode\": \"abc-event\", \n\t\"userFirstName\": \"Gloria\"\n}";
		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/registeration").content(user).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void whenPostRequestToRegister_thenInvalidFormatResponse() throws Exception {
		String user = "{\n\t\"eventCode\": \"abc-event\", \n\t\"userFirstName\": \"Gloria\",\n        \"userPhoneNumber\": \"134\"\n}";
		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/registeration").content(user).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
			}

}
