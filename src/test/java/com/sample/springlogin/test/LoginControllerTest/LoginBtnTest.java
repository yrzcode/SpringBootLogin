package com.sample.springlogin.test.LoginControllerTest;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.ObjectError;

import com.sample.springlogin.controller.auth.LoginBtn;


//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginBtnTest {

//	@Autowired
//	private MessageSource mesaageSource;
//	private Locale locale;

	@Autowired
	//@InjectMocks
	private LoginBtn loginBtn;
	
	@Autowired
	private  MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(loginBtn).build();
	}
	
	@Test
	public void rightIdShouldLoginSuccess() throws Exception {
//		var userForm = new UserForm();
//		userForm.setAccountId("111@softusing.com");
//		userForm.setPassword("123");
		
        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/AuthPage")
                .param("accountId", "111@softusing.com")
                .param("password", "123");
        
//        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/AuthPage")
//                .requestAttr("form", userForm);
		
		ResultActions results = this.mockMvc.perform(getRequest);
		
		results.andDo(print());
		results.andExpect(view().name("SuccessPage"));
		results.andExpect(model().errorCount(0));
		
	}
	
	
	@Test
    public void testAccountIdIsEmpty() throws Exception {
        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/AuthPage")
                .param("accountId", "")
                .param("password", "000001");
        
        ResultActions results = mockMvc.perform(getRequest);
        
        results.andDo(print());
        results.andExpect(view().name("AuthPage"));
        results.andExpect(model().errorCount(1));
        
        @SuppressWarnings("unchecked")
        List<ObjectError> errorList = (List<ObjectError>) results.andReturn().getModelAndView().getModel()
                .get("inputCheckErrorList");
        String message = errorList.get(0).getDefaultMessage();
        assertTrue(message.contains("login.error.accountId.notEmpty"));
        
    }
	
	
	
	
		
}
