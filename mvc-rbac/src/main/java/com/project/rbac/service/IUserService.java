package com.project.rbac.service;


import com.project.common.service.IBaseService;
import com.project.rbac.entity.User;

/**
 * Created by yinshaobo on 2018/5/4
 */
public interface IUserService extends IBaseService<User, Integer> {

    void updateLoginInfo(User user);

    /**
     * 获取用户名数目，用于判断用户名是否存在
     *
     * @param username
     * @return
     */
    int existUsername(String username);
}
