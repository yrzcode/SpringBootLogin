package com.sample.springlogin.service.LoginCheckService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ILoginErrorChecker<ErrorList, CheckTarget>{

	List<ErrorList> getErrorList(CheckTarget checkTarget);

	boolean getCheckResult(CheckTarget checkTarget);

}
