package com.sample.springlogin.service.DatabaseCheckService;

import java.util.List;

import com.sample.springlogin.bean.user.UserForm;

public interface IUserAuthService {
    List<String> getAuthErrorList(UserForm userForm);
}
