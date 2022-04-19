package com.sample.springlogin.user;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@ComponentScan({ "mapper" })
@Service("userService")
@NoArgsConstructor
public class UserService implements IUserService {

	@Autowired
    private IUserMapper userMapper;

    @Autowired
    private MessageSource messageSource;

    @Override
    public User queryUser(String accountId) {
        return userMapper.queryUser(accountId);
    }
}
