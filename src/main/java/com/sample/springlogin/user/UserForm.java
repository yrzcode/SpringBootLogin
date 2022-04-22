package com.sample.springlogin.user;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

    @NotEmpty(message = "{login.error.accountId.notEmpty}")
    @Email(message = "{login.error.accountId.isEmail}")
    private String accountId;

    @NotEmpty(message = "{login.error.accountId.notEmpty}")
    @Size(min = 0, max = 6, message = "{login.error.password.length}")
    private String password;

}
