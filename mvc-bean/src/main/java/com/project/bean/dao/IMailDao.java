package com.project.bean.dao;

import com.project.bean.bean.MailInfo;
import com.project.common.dao.IBaseDao;
import org.springframework.stereotype.Repository;

/**
 * Created by yinshaobo on 2018/5/23
 */
@Repository
public interface IMailDao extends IBaseDao<MailInfo, Long> {

}
