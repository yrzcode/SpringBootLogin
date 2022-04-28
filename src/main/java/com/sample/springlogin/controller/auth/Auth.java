package com.sample.springlogin.controller.auth;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.springlogin.Status;
import com.sample.springlogin.bean.user.UserForm;

@Controller
@RequestMapping("AuthPage")
public class Auth {

	@GetMapping
	public String getMappingAuth(
			@ModelAttribute("form") 
			UserForm userForm
			//@RequestBody("language")
			//String language
			) {
		
		//get language from browser
		//Status.languageInfo = language;
		
		//load login accountId
		userForm.setAccountId(Status.loginAccountId);
		
		return Status.hasPassAuth ? "SuccessPage" : "AuthPage";
		
	}
}
