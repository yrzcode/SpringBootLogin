package com.sample.springlogin.service.LoginCheckService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.springlogin.bean.user.UserForm;
import com.sample.springlogin.service.DatabaseCheckService.IUserAuthService;

@Service("authErrorChecker")
public class LoginAuthChecker implements ILoginErrorChecker<String, UserForm> {

	private  IUserAuthService userIdPasswordAuthService;
	
	@Autowired
	public LoginAuthChecker(IUserAuthService userIdPasswordAuthService) {
		super();
		this.userIdPasswordAuthService = userIdPasswordAuthService;
	}

	@Override
	public List<String> getErrorList(UserForm userForm) {
		return userIdPasswordAuthService.getAuthErrorList(userForm);
	}

	@Override
	public boolean getCheckResult(UserForm userForm) {
		return  userIdPasswordAuthService.getAuthErrorList(userForm).size() == 0;
	}

}
