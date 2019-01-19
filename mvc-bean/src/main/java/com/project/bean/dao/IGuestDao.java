package com.project.bean.dao;

import com.project.bean.bean.Guest;
import com.project.common.dao.IBaseDao;
import org.springframework.stereotype.Repository;

/**
 * Created by yinshaobo on 2018/5/9
 */
@Repository
public interface IGuestDao extends IBaseDao<Guest, Integer> {

    /**
     * 根据ip地址查找用户
     *
     * @param ip
     * @return
     */
    Guest findOneByIP(String ip);
}
