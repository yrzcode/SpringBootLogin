package com.sample.springlogin.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class User {

    @Getter
    private static final long id = 1L;
    private String accountId;
    private String password;

}
