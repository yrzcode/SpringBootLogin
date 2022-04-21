package com.sample.springlogin.user;

import java.util.List;

public interface IUserAuthService {
    List<String> getAuthErrorList(UserForm userForm);
}
