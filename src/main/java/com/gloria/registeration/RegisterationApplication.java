package com.gloria.registeration;

import com.gloria.registeration.domain.EventRegisteration;
import com.gloria.registeration.service.EventRegisterationService;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RegisterationApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterationApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper;
		
	}
	@Bean
	CommandLineRunner run(EventRegisterationService regService) {
		return (args) -> {
			EventRegisteration reg = EventRegisteration.builder().userLastName("Default").userFirstName("Default fist").userPhoneNumber("12345678").build();
			regService.saveRegisteration(reg);

		};
	}
}
