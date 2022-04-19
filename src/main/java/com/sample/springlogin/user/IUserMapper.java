package com.sample.springlogin.user;

import com.sample.springlogin.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {
    User queryUser(String accountId);
}
