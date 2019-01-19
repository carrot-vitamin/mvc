package com.project.controller;

import com.project.common.dwr.DwrHelper;
import com.project.common.entity.Constants;
import com.project.rbac.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yinshaobo on 2018/5/25
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private DwrHelper dwrHelper;

    @ResponseBody
    @GetMapping("/push")
    public Date push(HttpServletRequest request) {
        dwrHelper.sendMessageAuto(((User) request.getSession().getAttribute(Constants.USER_SESSION_KEY)).getId() + "", new SimpleDateFormat("HH:mm:ss").format(new Date()));
        return new Date();
    }
}
