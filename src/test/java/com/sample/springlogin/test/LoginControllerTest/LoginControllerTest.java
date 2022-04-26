package com.sample.springlogin.test.LoginControllerTest;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.sample.springlogin.controller.auth.LoginBtn;

@SpringBootTest
public class LoginControllerTest {

	@Autowired
	@InjectMocks
	private LoginBtn logincontroller;
	
	MockMvc mockMvc;
	
	
	@Test
	void rightIdShouldLoginSuccess() {
		
	}
	
	
}
