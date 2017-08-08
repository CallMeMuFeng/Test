package com.qst.three;

/**
 * 类说明：
 *
 * @author zhangchenxi
 * @version 2017/08/03
 */
public class Thread1 implements Runnable {
    private String s;

    public Thread1(String s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(s + i);
        }
    }
}
