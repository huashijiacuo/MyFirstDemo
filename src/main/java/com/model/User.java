package com.model;

/**
 * Created by shihuashun on 2016/12/7.
 */
public class User {
    int userId;
    String userName;
    String userPassword;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
