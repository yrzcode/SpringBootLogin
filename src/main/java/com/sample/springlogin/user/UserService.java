package com.sample.springlogin.user;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@ComponentScan({ "mapper" })
@Service("userService")
public class UserService implements IUserService {

    @Resource
//	@Autowired
    private IUserMapper userMapper;

    @Resource
    private MessageSource messageSource;

    public UserService() {
    }

    @Override
    public User queryUser(String accountId) {
        return userMapper.queryUser(accountId);
    }
}
