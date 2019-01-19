package com.project.bean.service;


import com.project.bean.bean.Guest;
import com.project.common.service.IBaseService;

/**
 * Created by yinshaobo on 2018/5/9
 */
public interface IGuestService extends IBaseService<Guest, Integer> {

    /**
     * 根据ip地址查找用户
     *
     * @param ip
     * @return
     */
    Guest findOneByIP(String ip);
}
