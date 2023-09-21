package com.dnb.devConnector;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dnb.devConnector.dto.Education;
import com.dnb.devConnector.dto.Experience;
import com.dnb.devConnector.dto.RegisterUser;
import com.dnb.devConnector.service.RegisterUserService;

@SpringBootApplication
public class DevConnectorApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DevConnectorApplication.class, args);
		
//		RegisterUserService registerUserService = applicationContext.getBean(RegisterUserService.class);
//		
//		RegisterUser registerUser = new RegisterUser("Leia", "leia@gmail.com", "leia456");
//		
//		registerUserService.createUser(registerUser);
		
		//DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		/*Education education = new Education("griet", "btech", "cse", LocalDate.parse("2019-08-5", dateTimeFormatter), 
				LocalDate.parse("2023-08-5", dateTimeFormatter), true, "fml");*/
		
		
	}

}
