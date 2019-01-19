package com.project.test.thread;

/**
 * Created by yinshaobo on 2018/5/20
 */
public class ThreadDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("**********");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
