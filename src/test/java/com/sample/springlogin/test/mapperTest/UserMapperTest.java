package com.sample.springlogin.test.mapperTest;

//import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.*;

import org.hamcrest.core.IsNull;

import static org.hamcrest.CoreMatchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.springlogin.bean.user.IUserMapper;

@SpringBootTest
public class UserMapperTest  {
	
	@Autowired
	private IUserMapper userMapper;

	@Test
	public void testGetUserPassword() {
		var user = userMapper.queryUser("111@softusing.com");
		//assertEquals("111@softusing.com", user.getAccountId());
		//assertEquals("123123", user.getPassword());
		
		assertThat("111@softusing.com", is(user.getAccountId()));
		assertThat("123123", is(user.getPassword()));
	}

	@Test
	public void testUserNotMatch() {
		var user = userMapper.queryUser("2@softusing.com");
		//assertEquals(null, user);
		
		assertThat(user, IsNull.nullValue());
	}
	
}
