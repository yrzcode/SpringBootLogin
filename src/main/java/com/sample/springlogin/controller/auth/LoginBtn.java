package com.sample.springlogin.controller.auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.springlogin.bean.user.UserForm;
import com.sample.springlogin.service.LoginCheckService.ILoginErrorChecker;

@Controller
@RequestMapping("AuthPage")
public class LoginBtn {
	
	
	private ILoginErrorChecker<ObjectError, BindingResult> inputErrorChecker;
	private ILoginErrorChecker<String, UserForm> authErrorChecker;
	
	@Autowired
	public LoginBtn(
			
			@Qualifier("inputErrorChecker")
			ILoginErrorChecker<ObjectError, BindingResult> inputErrorChecker,
			
			@Qualifier("authErrorChecker")
			ILoginErrorChecker<String, UserForm> authErrorChecker) {
		
			this.inputErrorChecker = inputErrorChecker;
			this.authErrorChecker = authErrorChecker;
	}
	

	@PostMapping
	public String postMappingAuth(Model model, @ModelAttribute("form") @Valid UserForm userForm, BindingResult result) {
		
		
		// check input
		var inputErrorList =  inputErrorChecker.getErrorList(result);
		var isPassInputCheck = inputErrorChecker.getCheckResult(result);
		if (!isPassInputCheck)  model.addAttribute("inputCheckErrorList", inputErrorList);

		
		// check database authentication
		var databaseAuthErrorList = authErrorChecker.getErrorList(userForm);
		var isPassDatabaseAuthCheck = authErrorChecker.getCheckResult(userForm);
		if (!isPassDatabaseAuthCheck)
			model.addAttribute("message", databaseAuthErrorList.get(0));
		else
			Auth.loginAccountId = userForm.getAccountId();
		
		
		// final check
		var isPassAllCheck = isPassInputCheck && isPassDatabaseAuthCheck;

		
		// memorize login result
		Auth.hasPassAuth = isPassAllCheck;

		
		// decide which page to go by result
		return isPassAllCheck ? "SuccessPage" : "AuthPage";

		
	}

}