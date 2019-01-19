package com.project.rbac.dao;

import com.project.common.dao.IBaseDao;
import com.project.rbac.entity.User;
import org.springframework.stereotype.Repository;


/**
 * Created by yinshaobo on 2018/5/4
 */
@Repository
public interface IUserDao extends IBaseDao<User, Integer> {

    /**
     * 更新用户登陆信息
     *
     * @param user
     */
    void updateLoginInfo(User user);

    /**
     * 获取用户名数目，用于判断用户名是否存在
     *
     * @param username
     * @return
     */
    int existUsername(String username);


}
