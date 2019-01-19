package com.project.bean.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yinshaobo on 2018/5/9
 * 访客信息类
 */
public class Guest implements Serializable {
    private static final long serialVersionUID = 5455996684533691411L;

    private int id;
    private String ip;
    private Date firstTime;//首次访问时间
    private Date lastTime;//最后一次访问时间
    private long times;//访问次数

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }
}
