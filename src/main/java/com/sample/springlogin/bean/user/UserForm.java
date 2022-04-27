package com.sample.springlogin.bean.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserForm {

	@NotEmpty(message = "{login.error.accountId.notEmpty}")
	@Email(message = "{login.error.accountId.isEmail}")
	private String accountId;

	@NotEmpty(message = "{login.error.password.notEmpty}")
	@Size(min = 6, max = 6, message = "{login.error.password.length}")
	private String password;

}
