package com.project.test.core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yinshaobo on 2018/5/4
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration(locations = {
        "classpath*:/META-INF/spring/spring-*.xml"/*,*/
        /*"classpath*:/META-INF/hibernate.cfg.xml"*/}) //加载配置文件
@Transactional //控制事务，如果不加入这个注解配置，事务控制就会完全失效！
@Rollback(false) //druid配置之后junit数据库操作结束会自动回滚
@ActiveProfiles({"dev"})
public abstract class AbstractTest {

    private String className = this.getClass().getName();

    @Before
    public void before() {
        System.out.println("单元测试开始 ... ... ： " + className);
    }

    @Test
    public abstract void test() throws Exception;

    @After
    public void after() {
        System.out.println("单元测试结束 ... ... ：" + className);
    }

}
