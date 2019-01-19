package com.project.controller.rbac;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.common.entity.PageRequest;
import com.project.common.entity.PageResponse;
import com.project.common.entity.Response;
import com.project.rbac.entity.Module;
import com.project.rbac.service.IModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yinshaobo on 2018/5/29
 */
@Controller
@RequestMapping(value = "/rbacModule")
public class ModuleController {

    @Autowired
    private IModuleService moduleService;

    @RequestMapping(value = "view")
    public String moduleView() {
        return "rbac/module/moduleManage";
    }

    @ResponseBody
    @RequestMapping(value = "/pageData")
    public PageResponse pageData(@ModelAttribute PageRequest pageRequest) {
        //查询分页数据
        PageHelper.startPage(pageRequest.getStart() / pageRequest.getLength() + 1, pageRequest.getLength());
        PageInfo pageInfo = new PageInfo(this.moduleService.selectAll());

        //封装响应
        PageResponse pageResponse = new PageResponse();
        pageResponse.setDraw(pageRequest.getDraw());
        pageResponse.setRecordsTotal(pageInfo.getTotal());
        pageResponse.setRecordsFiltered(pageInfo.getTotal());
        pageResponse.setData(pageInfo.getList());

        return pageResponse;
    }

    @ResponseBody
    @GetMapping(value = "/del")
    public Response delete(@RequestParam(value = "ids[]") int[] ids) {
        this.moduleService.deleteByIds(ids);
        return Response.success();
    }

    @ResponseBody
    @GetMapping(value = "/all")
    public Response all() {
        return Response.success(this.moduleService.selectAll());
    }

    @ResponseBody
    @PostMapping(value = "/add")
    public Response add(Module module) {
        this.moduleService.insert(module);
        return Response.success();
    }

    @ResponseBody
    @GetMapping(value = "/findOne/{id}")
    public Response getOne(@PathVariable Long id) {
        return Response.success(this.moduleService.selectByPrimaryKey(id));
    }

    @ResponseBody
    @PostMapping(value = "/update")
    public Response update(Module module) {
        this.moduleService.update(module);
        return Response.success();
    }
}
