package com.project.rbac.dao;

import com.project.common.dao.IBaseDao;
import com.project.rbac.entity.Module;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yinshaobo on 2018/5/29
 */
@Repository
public interface IModuleDao extends IBaseDao<Module, Long> {

    /**
     * 根据父节点查询子节点
     *
     * @param parentId
     * @return
     */
    List<Module> selectByParentId(Long parentId);

    /**
     * 查询父节点
     *
     * @return
     */
    List<Module> selectParentModules();

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(int[] ids);
}
