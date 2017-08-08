package com.qst.three;

/**
 * 类说明：
 *
 * @author zhangchenxi
 * @version 2017/07/25
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("线程a");
        MyThread mt2 = new MyThread("线程b");
        MyThread mt3 = new MyThread("线程c");
        new Thread(mt1).start();
        new Thread(mt2).start();
        new Thread(mt3).start();
    }
}
