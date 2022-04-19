package com.sample.springlogin.user;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<String> getResult(UserForm userForm) {

        User user = userMapper.queryUser(userForm.getAccountId());

        List<String> errorList = new ArrayList<String>();

        if (user == null) {
            errorList.add("login.message.accountId.error");
        } else if (!user.getPassword().equals(userForm.getPassword())) {
            errorList.add("login.message.password.password.error");
        }

        return errorList;
    }
}
