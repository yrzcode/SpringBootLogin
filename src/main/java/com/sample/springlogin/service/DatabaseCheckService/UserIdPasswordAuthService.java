package com.sample.springlogin.service.DatabaseCheckService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.sample.springlogin.bean.user.IUserMapper;
import com.sample.springlogin.bean.user.User;
import com.sample.springlogin.bean.user.UserForm;

@Service
public class UserIdPasswordAuthService implements IUserAuthService {
	
	private final IUserMapper userMapper;
	private final MessageSource messageSource;

	// private Locale locale = Locale.getDefault();
	private Locale locale = Locale.CHINESE;
	
	@Autowired
	public UserIdPasswordAuthService(IUserMapper userMapper, MessageSource messageSource) {
		this.userMapper = userMapper;
		this.messageSource = messageSource;
	}

	@Override
	public List<String> getAuthErrorList(UserForm userForm) {

		User user = userMapper.queryUser(userForm.getAccountId());
		var errorList = new ArrayList<String>();

		if (user == null) {
			errorList.add(messageSource.getMessage("login.message.accountId.error", null, locale));
		} else if (!user.getPassword().equals(userForm.getPassword())) {
			errorList.add(messageSource.getMessage("login.message.password.error", null, locale));
		}

		return errorList;
	}
}
