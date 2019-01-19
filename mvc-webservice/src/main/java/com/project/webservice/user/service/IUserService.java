package com.project.webservice.user.service;


import com.project.rbac.entity.User;

import javax.jws.WebService;

/**
 * Created by yinshaobo on 2018/5/7
 */
@WebService
public interface IUserService {

    User getUser(int id);
}
