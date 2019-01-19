package com.project.test.thread;

import com.project.test.core.AbstractTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by yinshaobo on 2018/5/20
 */
public class ThreadPoolTest extends AbstractTest {

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Override
    public void test() throws Exception {
        executor.execute(new ThreadDemo());
        System.out.println("ok");
        Thread.sleep(3000);//防止测试主线程停止，而线程池内仍存在运行中的线程引发异常
    }
}
