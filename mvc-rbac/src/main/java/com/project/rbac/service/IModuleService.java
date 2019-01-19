package com.project.rbac.service;

import com.project.common.service.IBaseService;
import com.project.rbac.entity.Module;

import java.util.List;

/**
 * Created by yinshaobo on 2018/5/29
 */
public interface IModuleService extends IBaseService<Module, Long> {

    /**
     * 查询模块树
     *
     * @return
     */
    List<Module> selectModuleTree();

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(int[] ids);
}
