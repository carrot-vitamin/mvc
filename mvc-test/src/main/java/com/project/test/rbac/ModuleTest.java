package com.project.test.rbac;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.rbac.entity.Module;
import com.project.rbac.service.IModuleService;
import com.project.test.core.AbstractTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yinshaobo on 2018/5/29
 */
public class ModuleTest extends AbstractTest {

    @Autowired
    private IModuleService moduleService;

    @Override
    public void test() throws Exception {
//        PageHelper.startPage(1, 1);
//        List<Module> list = this.moduleService.selectModuleTree();
//        PageInfo info = new PageInfo(list);
//        System.out.println(JSON.toJSONString(info));

        this.moduleService.deleteByIds(new int[]{11, 12});
    }
}
