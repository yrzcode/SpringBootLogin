package com.sample.springlogin.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserForm {

    @Getter @Setter
    @NotEmpty(message = "{login.error.accountId.notEmpty}")
    @Email(message = "{login.error.accountId.isEmail}")
    private String accountId;


    @Getter @Setter
    @NotEmpty(message = "{login.error.accountId.notEmpty}")
    @Size(min = 6, max = 6, message = "{login.error.password.length")
    private String password;

}
