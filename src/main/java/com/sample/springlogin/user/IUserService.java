package com.sample.springlogin.user;

import java.util.List;

public interface IUserService {
    List<String> getAuthErrorList(UserForm userForm);
}
