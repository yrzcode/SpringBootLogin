package com.sample.springlogin.bean.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {
    User queryUser(String accountId);
}
