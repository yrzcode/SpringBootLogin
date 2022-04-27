package com.sample.springlogin.test.LoginControllerTest;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Locale;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.ObjectError;

import com.sample.springlogin.bean.user.UserForm;
import com.sample.springlogin.controller.auth.LoginBtn;


//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginBtnTest {

	@Autowired
	//@InjectMocks
	private LoginBtn loginBtn;
	
	@Autowired
	private MessageSource mesaageSource;
	
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
                .param("password", "123123");
        
//        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/AuthPage")
//                .requestAttr("form", userForm);
		
		ResultActions results = this.mockMvc.perform(getRequest);
		
		results.andDo(print());
		results.andExpect(view().name("SuccessPage"));
		results.andExpect(model().errorCount(0));
	}
	
	
	@Test
     void testAccountIdIsEmpty() throws Exception    {
        MockHttpServletRequestBuilder getRequest = MockMvcRequestBuilders.post("/AuthPage")
                .param("accountId", "")
                .param("password", "123123");
        
        ResultActions results = mockMvc.perform(getRequest);
        
        results.andDo(print());
        results.andExpect(view().name("AuthPage"));
        results.andExpect(model().errorCount(1));
        
        @SuppressWarnings("unchecked")
        List<ObjectError> errorList = (List<ObjectError>) results.andReturn().getModelAndView().getModel()
                .get("inputCheckErrorList");
        String message = errorList.get(0).getDefaultMessage();
        assertThat(message, containsString("Please input accountId!"));
        
    }
	
	
	@Test
	 void testAccountIdNotMail() throws Exception {
		
		var getRequest  = MockMvcRequestBuilders.post("/AuthPage")
                .param("accountId", "111")
                .param("password", "123123");
		
		var results = mockMvc.perform(getRequest);
		
		results.andDo(print());
		results.andExpect(view().name("AuthPage"));
		results.andExpect(model().errorCount(1));
		
		@SuppressWarnings("unchecked")
		List<ObjectError> errorList = (List<ObjectError>) results.andReturn()
															.getModelAndView().getModel()
															.get("inputCheckErrorList");
		
		var message = errorList.get(0).getDefaultMessage();
		//assertTrue(message.contains("Please input Email Address!"));
	    assertThat(message, containsString("Please input Email Address!"));
	}
	

	@Test
	void testPasswordLength() throws Exception {
		var request = MockMvcRequestBuilders.post("/AuthPage")
				.param("accountId", "111@softusing")
				.param("password","0");
		var results = mockMvc.perform(request);
		
		results.andDo(print());
		results.andExpect(view().name("AuthPage"));
		results.andExpect(model().errorCount(1));
		
		@SuppressWarnings("unchecked")
		var errorList = (List<ObjectError>) results.andReturn()
				.getModelAndView().getModel()
				.get("inputCheckErrorList");
		
		var message = errorList.get(0).getDefaultMessage();
		assertThat(message, containsString("Please input 6 bytes Password!"));
	}
	
	
	@Test
	void testLoginAccountError() throws Exception {
		var request = MockMvcRequestBuilders.post("/AuthPage")
				.param("accountId", "1@softusing.com")
				.param("password","123123");
		var results = mockMvc.perform(request);
		
		results.andDo(print());
		results.andExpect(view().name("AuthPage"));
		results.andExpect(model().errorCount(0));
		
		var message = (String) results.andReturn().getModelAndView().getModel().get("message");
		assertThat(message, is(mesaageSource.getMessage("login.message.accountId.error", null, Locale.getDefault())));
		
	}
	
	@Test 
	void testPasswordError() throws Exception {
		var request = MockMvcRequestBuilders.post("/AuthPage")
				.param("accountId", "111@softusing.com")
				.param("password","111111");
		var results = mockMvc.perform(request);
		
		results.andDo(print());
		results.andExpect(view().name("AuthPage"));
		results.andExpect(model().errorCount(0));
		
		var message = (String)results.andReturn().getModelAndView().getModel().get("message");
		assertThat(message, is(mesaageSource.getMessage("login.message.password.error", null, Locale.getDefault())));
	}
	
	@Test
	void testLoginSuccess() throws Exception {
		var request = MockMvcRequestBuilders.post("/AuthPage")
				.param("accountId","111@softusing.com")
				.param("password","123123");
		
		var results = mockMvc.perform(request);
		
		results.andDo(print());
		results.andExpect(view().name("SuccessPage"));
		
		var form =  (UserForm)results.andReturn().getModelAndView().getModel().get("form");
		var message = form.getAccountId();
		assertThat(message, is("111@softusing.com"));
		
	}
	
}
