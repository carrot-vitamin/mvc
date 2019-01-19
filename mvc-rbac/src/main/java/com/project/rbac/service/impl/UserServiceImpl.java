package com.project.rbac.service.impl;

import com.project.common.dao.IBaseDao;
import com.project.common.service.impl.BaseServiceImpl;
import com.project.rbac.dao.IUserDao;
import com.project.rbac.entity.User;
import com.project.rbac.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by yinshaobo on 2018/5/4
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    @Override
    public void setBaseDao(IBaseDao<User, Integer> baseDao) {
        super.setBaseDao(userDao);
    }

    @Override
    public void updateLoginInfo(User user) {
        userDao.updateLoginInfo(user);
    }

    @Override
    @Cacheable(value = "user", key = "#username")
    public int existUsername(String username) {
        return userDao.existUsername(username);
    }
}
