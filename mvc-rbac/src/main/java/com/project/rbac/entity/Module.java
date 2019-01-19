package com.project.rbac.entity;

import com.project.common.entity.BaseDate;

import java.util.List;

/**
 * Created by yinshaobo on 2018/5/29
 * 模块实体
 */
public class Module extends BaseDate {
    private static final long serialVersionUID = -4635843040833460896L;

    private Long id;//ID
    private String code;//菜单代码
    private String title;//菜单项标题
    private String path;//菜单对应url
    private String icon;//菜单图标
    private Long parent;//父菜单ID
    private List<Module> children;//子模块

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public List<Module> getChildren() {
        return children;
    }

    public void setChildren(List<Module> children) {
        this.children = children;
    }
}
