package com.sample.springlogin.test.mapperTest;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.springlogin.bean.user.IUserMapper;

@SpringBootTest
public class UserMapperTest  {
	
	private IUserMapper userMapper;

	@Autowired
	public UserMapperTest(IUserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Test
	public void userAccountIdShouldMatchPassword() {
		var user = userMapper.queryUser("111@softusing.com");
		assertEquals("111@softusing.com", user.getAccountId());
		assertEquals("123", user.getPassword());
	}

	@Test
	public void noUserShouldBeNull() {
		var user = userMapper.queryUser("2@softusing.com");
		assertEquals(null, user);
	}
	
}
