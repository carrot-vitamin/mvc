package com.project.controller;

import com.alibaba.fastjson.JSON;
import com.project.bean.bean.Guest;
import com.project.bean.service.IGuestService;
import com.project.rbac.entity.Module;
import com.project.rbac.service.IModuleService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yinshaobo on 2018/5/17
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String LOGIN = "login";
    private static final String MAIN = "main";
    private static final String REGISTER = "register";

    @Autowired
    private IGuestService guestService;

    @Autowired
    private IModuleService moduleService;

    /**
     * 登陆和注册页面跳转
     *
     * @param flag
     * @param request
     * @return
     */
    @GetMapping(value = "index")
    public String login(@RequestParam(value = "flag", required = false) String flag, HttpServletRequest request) {
        if (StringUtils.isNotBlank(flag) && flag.equals(REGISTER)) return REGISTER;
        String ip = this.getGuestRealAddress(request);
        logger.info("访客访问，IP --- > {}", ip);
        //根据ip在数据库查找访客信息
        Guest guest = this.guestService.findOneByIP(ip);
        if (guest == null) {
            guest = new Guest();
            guest.setIp(ip);
            this.guestService.insert(guest);
            logger.info("插入访客信息：{}", JSON.toJSONString(guest));
        } else {
            this.guestService.update(guest);
            logger.info("更新访客信息：{}", JSON.toJSONString(guest));
        }
        return LOGIN;
    }

    /**
     * 主页面
     *
     * @return
     */
    @GetMapping(value = "main")
    public String main(ModelMap map) {
        //初始化菜单
        List<Module> menuList = moduleService.selectModuleTree();
        map.addAttribute("menuList", menuList);
        return MAIN;
    }

    /**
     * 系统登出
     *
     * @param request
     * @return
     */
    @GetMapping(value = "logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(request.getSession().getId());
        return LOGIN;
    }

    /**
     * 获取访客真实ip
     *
     * @param request
     * @return
     */
    private String getGuestRealAddress(HttpServletRequest request) {
        String ip = null;
        //X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }
        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }
        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
