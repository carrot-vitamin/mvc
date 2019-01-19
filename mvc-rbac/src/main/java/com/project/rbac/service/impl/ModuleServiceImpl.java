package com.project.rbac.service.impl;

import com.project.common.dao.IBaseDao;
import com.project.common.service.impl.BaseServiceImpl;
import com.project.rbac.dao.IModuleDao;
import com.project.rbac.entity.Module;
import com.project.rbac.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yinshaobo on 2018/5/29
 */
@Service
public class ModuleServiceImpl extends BaseServiceImpl<Module, Long> implements IModuleService {

    @Autowired
    private IModuleDao moduleDao;

    @Autowired
    @Override
    public void setBaseDao(IBaseDao<Module, Long> baseDao) {
        super.setBaseDao(moduleDao);
    }

    @Override
    public List<Module> selectModuleTree() {
        List<Module> moduleTree = this.moduleDao.selectParentModules();
        if (moduleTree != null) {
            for (Module parent : moduleTree) {
                treeSearch(parent);
            }
        }
        return moduleTree;
    }

    @Override
    public void deleteByIds(int[] ids) {
        this.moduleDao.deleteByIds(ids);
    }

    /**
     * 遍历单个节点的子节点
     *
     * @param module
     */
    public void treeSearch(Module module) {
        List<Module> children = this.moduleDao.selectByParentId(module.getId());
        if (children != null) {
            module.setChildren(children);
            for (Module module1 : children) {
                treeSearch(module1);
            }
        }
    }
}
