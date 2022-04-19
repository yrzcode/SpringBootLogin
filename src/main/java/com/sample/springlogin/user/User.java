package com.sample.springlogin.user;

public class User {

    private static final long serialVersionUID = 1L;
    private String accountId;
    private String password;

    public User() {};

    public User(String accountId, String password) {
        this.accountId = accountId;
        this.password = password;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static long gtSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "User accountId=" + accountId + ", password=" + password + "]";
    }

}
