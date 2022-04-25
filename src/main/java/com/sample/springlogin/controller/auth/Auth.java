package com.sample.springlogin.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.springlogin.bean.user.UserForm;

@Controller
@RequestMapping("AuthPage")
public class Auth {
	
	public static boolean hasPassAuth;
	public static String loginAccountId;

	@GetMapping
	public String getMappingAuth(@ModelAttribute("form") UserForm userForm) {
		userForm.setAccountId(loginAccountId);
		return hasPassAuth ? "SuccessPage" : "AuthPage";
	}
}
