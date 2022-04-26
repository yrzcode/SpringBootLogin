package com.sample.springlogin.test.serviceTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.* ;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.springlogin.bean.user.UserForm;
import com.sample.springlogin.service.DatabaseCheckService.UserIdPasswordAuthService;

@SpringBootTest
public class UserServiceTest {

	private UserIdPasswordAuthService userIdPasswordAuthService;
	
	@Autowired
	public UserServiceTest(UserIdPasswordAuthService userIdPasswordAuthService) {
		this.userIdPasswordAuthService = userIdPasswordAuthService;
	}

	@Test 
	public void rightAccountShouldReturnZeroError() {
		var useFrom = new UserForm();
		useFrom.setAccountId("111@softusing.com");
		useFrom.setPassword("123");
		
		List<String> errorList = null;
		errorList = userIdPasswordAuthService.getAuthErrorList(useFrom);
		assertThat(0, is(equalTo( errorList.size())));
	}

}
