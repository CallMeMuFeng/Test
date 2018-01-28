package com.qst.three;

/**
 * 类说明：
 *
 * @author zhangchenxi
 * @version 2017/07/25
 */
public class ThreadDemo01 {
    //    public static void main(String[] args) {
//        MyThread mt1 = new MyThread("线程a");
//        MyThread mt2 = new MyThread("线程b");
//        MyThread mt3 = new MyThread("线程c");
////        new Thread(mt1).run();
////        new Thread(mt2).run();
////        new Thread(mt3).run();
//        new Thread(mt1).start();
//        new Thread(mt2).start();
//        new Thread(mt3).start();
//    }
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("r1=" + i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("r2=" + i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("r3=" + i);
            }
        }).start();
    }
}
