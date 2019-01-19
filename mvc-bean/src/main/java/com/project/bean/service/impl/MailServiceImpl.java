package com.project.bean.service.impl;

import com.project.bean.bean.MailInfo;
import com.project.bean.dao.IMailDao;
import com.project.bean.service.IMailService;
import com.project.common.dao.IBaseDao;
import com.project.common.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yinshaobo on 2018/5/23
 */
@Service
public class MailServiceImpl extends BaseServiceImpl<MailInfo, Long> implements IMailService {

    @Autowired
    private IMailDao mailDao;

    @Autowired
    @Override
    public void setBaseDao(IBaseDao<MailInfo, Long> baseDao) {
        super.setBaseDao(mailDao);
    }
}
