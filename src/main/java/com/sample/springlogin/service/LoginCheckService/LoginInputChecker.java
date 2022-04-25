package com.sample.springlogin.service.LoginCheckService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import lombok.AllArgsConstructor;

@Service("inputErrorChecker")
@AllArgsConstructor
public class LoginInputChecker implements ILoginErrorChecker<ObjectError, BindingResult> {

	@Override
	public List<ObjectError> getErrorList(BindingResult result) {
		return result.getAllErrors();
	}
	
	@Override
	public boolean getCheckResult(BindingResult result) {
		return result.getAllErrors().size() == 0;
	}
	
}
