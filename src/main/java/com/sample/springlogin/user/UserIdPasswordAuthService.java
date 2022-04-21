package com.sample.springlogin.user;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserIdPasswordAuthService implements IUserAuthService {

    private IUserMapper userMapper;
    private MessageSource messageSource;

    @Override
    public List<String> getAuthErrorList(UserForm userForm) {

        var user = userMapper.queryUser(userForm.getAccountId());
        var errorList = new ArrayList<String>();

        if (user == null) {
            errorList.add("login.message.accountId.error");
        } else if (!user.getPassword().equals(userForm.getPassword())) {
            errorList.add("login.message.password.password.error");
        }

        return errorList;
    }
}
