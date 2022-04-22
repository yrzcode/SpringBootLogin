package com.sample.springlogin.user;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class UserIdPasswordAuthService implements IUserAuthService {

    private final IUserMapper userMapper;
    private final MessageSource messageSource;

    //private Locale locale = Locale.getDefault();
    private Locale locale = Locale.CHINESE;

    @Override
    public List<String> getAuthErrorList(UserForm userForm) {

        var user = userMapper.queryUser(userForm.getAccountId());
        var errorList = new ArrayList<String>();

        if (user == null) {
            errorList.add(messageSource.getMessage("login.message.accountId.error",null, locale));
        } else if (!user.getPassword().equals(userForm.getPassword())) {
            errorList.add(messageSource.getMessage("login.message.password.error", null, locale));
        }

        System.out.println(locale);

        return errorList;
    }
}
