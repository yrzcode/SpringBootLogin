package com.sample.springlogin.test.LoginControllerTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Locale;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.sample.springlogin.bean.user.UserForm;
import com.sample.springlogin.controller.auth.LoginBtn;



@SpringBootTest
@ExtendWith(SpringExtension.class)
public class LoginBtnTest {

	@Resource
	@InjectMocks
	private LoginBtn loginBtn;
	
	@Autowired
	private MessageSource mesaageSource;
	
	private Locale locale;

	private  MockMvc mockMvc;

	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(loginBtn).build();
	}
	
	@Test
	public void rightIdShouldLoginSuccess() throws Exception {
		var userForm = new UserForm();
		userForm.setAccountId("111@softusing.com");
		userForm.setPassword("123");
		
//        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/AuthPage")
//                .param("accountId", "111@softusing.com")
//                .param("password", "123");
        
        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/AuthPage")
                .requestAttr("form", userForm);
		
		ResultActions results = this.mockMvc.perform(getRequest);
		
		results.andDo(print());
		results.andExpect(view().name("/SuccessPage"));
		results.andExpect(model().errorCount(0));
		
	}
		
}
