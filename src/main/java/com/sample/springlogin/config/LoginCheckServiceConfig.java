//package com.sample.springlogin.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.sample.springlogin.service.ILoginErrCheck;
//import com.sample.springlogin.service.LoginAuthCheck;
//import com.sample.springlogin.service.LoginInputCheck;
//
//@Configuration
//public class LoginCheckServiceConfig {
//	@Bean("checkInputError")
//	ILoginErrCheck checkInputErr() {
//		return new LoginInputCheck();
//	}
//
//	@Bean("checkAuthError")
//	ILoginErrCheck checkAuthErr() {
//		return new LoginAuthCheck();
//	}
//}
