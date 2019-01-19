package com.project.test.user;

import com.alibaba.fastjson.JSON;
import com.project.bean.bean.Guest;
import com.project.bean.service.IGuestService;
import com.project.test.core.AbstractTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by yinshaobo on 2018/5/9
 */
public class GuestTest extends AbstractTest {

    @Autowired
    private IGuestService guestService;


    @Override
    public void test() throws Exception {
        Guest guest = new Guest();
        guest.setIp("123");
        guest.setFirstTime(new Date());
        guest.setLastTime(new Date());
//        this.guestService.insert(guest);
//        guest = this.guestService.findOneByIP("123");
        System.out.println("guest ---> [{}],{}" + JSON.toJSONString(guest));
        guest.setTimes(2);
        this.guestService.update(guest);
//        guest = this.guestService.findOneByIP("123");
        System.out.println("guest ---> [{}],{}" + JSON.toJSONString(guest));
    }
}
