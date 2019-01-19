package com.project.test.rbac;

import com.project.rbac.service.IUserService;
import com.project.test.core.AbstractTest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yinshaobo on 2018/5/4
 */
public class UserTest extends AbstractTest {

    @Autowired
    private IUserService userService;

    public void test() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("username", "小王");
//        map.put("password", "123456");
//        User user = userService.selectOne(map);
//        logger.info("user --> [{}]", JSON.toJSONString(user));

//        User user = new User();
//        user.setUsername("小尹");
//        user.setEmail("123@qq.com");
//        user.setTelephone("156789");
//        user.setPassword("123456");
//        this.userService.insert(user);

//        User user = this.userService.selectByPrimaryKey(1);
//        logger.info("user --> [{}]", JSON.toJSONString(user));

        int count = this.userService.existUsername("admin1");
        System.out.println("**********************  " + count);
    }

}
