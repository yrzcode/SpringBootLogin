package com.sample.springlogin.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {
    User queryUser(String accountId);
}
