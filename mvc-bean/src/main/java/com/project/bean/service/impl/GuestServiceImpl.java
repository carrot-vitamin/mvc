package com.project.bean.service.impl;

import com.project.bean.bean.Guest;
import com.project.bean.dao.IGuestDao;
import com.project.bean.service.IGuestService;
import com.project.common.dao.IBaseDao;
import com.project.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yinshaobo on 2018/5/9
 */
@Service
public class GuestServiceImpl extends BaseServiceImpl<Guest, Integer> implements IGuestService {

    @Autowired
    private IGuestDao guestDao;

    @Autowired
    @Override
    public void setBaseDao(IBaseDao<Guest, Integer> baseDao) {
        super.setBaseDao(guestDao);
    }

    @Override
    public Guest findOneByIP(String ip) {
        return this.guestDao.findOneByIP(ip);
    }
}
