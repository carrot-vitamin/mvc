package com.project.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yinshaobo on 2018/5/29
 * 公共时间实体
 */
public class BaseDate implements Serializable {

    private static final long serialVersionUID = 606186574865305631L;
    private Date createDate;//创建时间
    private Date updateDate;//更新时间
    private String creator;//创建人
    private String updator;//更新人

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }
}
