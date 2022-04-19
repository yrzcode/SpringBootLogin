package com.sample.springlogin.user;

import java.util.List;

public interface IUserService {
    User queryUser(String accountId);
    List<String> getResult(UserForm userForm);
}
