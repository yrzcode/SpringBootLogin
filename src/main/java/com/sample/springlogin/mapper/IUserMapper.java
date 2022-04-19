package com.sample.springlogin.mapper;

import com.sample.springlogin.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {
    public User queryUser(String accountId);
}
