package com.mapper;

import com.model.User;

/**
 * Created by shihuashun on 2016/12/7.
 */
public interface UserMapper {
    //User selectUser(int id);
    User selectUser(String name);

    String selectName(String name);
}
