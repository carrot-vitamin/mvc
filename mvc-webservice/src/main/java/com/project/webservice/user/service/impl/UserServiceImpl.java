package com.project.webservice.user.service.impl;

import com.project.rbac.entity.User;
import com.project.webservice.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yinshaobo on 2018/5/7
 */
public class UserServiceImpl implements IUserService {

    @Autowired
    private com.project.rbac.service.IUserService userService;

    @Override
    public User getUser(int id) {
        return userService.selectByPrimaryKey(id);
    }
}
