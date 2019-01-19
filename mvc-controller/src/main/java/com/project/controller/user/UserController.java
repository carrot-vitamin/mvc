package com.project.controller.user;

import com.alibaba.fastjson.JSON;
import com.project.common.entity.Constants;
import com.project.common.entity.Response;
import com.project.common.entity.ResponseCode;
import com.project.rbac.entity.User;
import com.project.rbac.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by yinshaobo on 2018/5/7
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;

    @ResponseBody
    @GetMapping(value = "/login")
    public Response login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password, HttpServletRequest request) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("username", username);
        paramsMap.put("password", password);
        User user = userService.selectOne(paramsMap);
        if (user == null) {
            return Response.fail(ResponseCode.USER_OR_PASS_ERROR);
        } else {
            user.setLoginTimes(user.getLoginTimes() + 1);
            this.userService.updateLoginInfo(user);
            request.getSession().setAttribute(Constants.USER_SESSION_KEY, user);
            request.getSession().setAttribute(request.getSession().getId(), request.getSession().getId());
            logger.info("用户[{}]登陆成功！", JSON.toJSONString(user));
        }
        return Response.success();
    }

    @ResponseBody
    @PostMapping(value = "/register")
    public Response register(@ModelAttribute User user, @RequestParam(value = "file", required = false) MultipartFile file) {
        //判断用户名重复
        if (this.userService.existUsername(user.getUsername()) > 0) {
            return Response.fail(ResponseCode.USER_NAME_EXISTED);
        } else {
            try {
                if (file != null && StringUtils.isNotBlank(file.getOriginalFilename())) {
                    String path = "/mvc-picupload";
                    logger.info("用户[{}]上传资料路径：[{}]", user.getUsername(), path);
                    File targetFile = new File(path, user.getUsername() + "-" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "-" + file.getOriginalFilename());
                    if (!targetFile.exists()) {
                        targetFile.mkdirs();
                    }
                    file.transferTo(targetFile);
                    user.setFilePath(targetFile.getAbsolutePath());
                }
                this.userService.insert(user);
                logger.info("新用户注册成功！【{}】", JSON.toJSONString(user));
            } catch (IOException e) {
                logger.error("用户注册出现异常！{}", e);
                return Response.fail(ResponseCode.REGIST_ERROR);
            }
        }
        return Response.success();
    }

    @GetMapping(value = "/userManage")
    public String userManage() {
        return "user/userManage";
    }

    @ResponseBody
    @GetMapping(value = "/getAll")
    public Map getAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", this.userService.selectList(null));
        return map;
    }

    /**
     * 根据id查找用户
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/findOne/{id}")
    public User findOne(@PathVariable int id) {
        return this.userService.selectByPrimaryKey(id);
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/delete/{id}")
    public Response delete(@PathVariable int id) {
        this.userService.deleteByPrimaryKey(id);
        logger.info("删除用户信息：ID ---> 【{}】成功！", id);
        return Response.success();
    }

    @ResponseBody
    @PostMapping(value = "/update")
    public Response update(@ModelAttribute User user) {
        this.userService.update(user);
        logger.info("更新用户信息： ---> 【{}】成功！", JSON.toJSONString(user));
        return Response.success();
    }
}
