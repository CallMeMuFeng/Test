package com.qst.three;

/**
 * 类说明：
 *
 * @author zhangchenxi
 * @version 2017/07/25
 */
class MyThread implements Runnable{
    private String name;
    public MyThread(String name) {
        super();
        this.name = name;
    }
    @Override
    public void run(){
        for(int i=0;i<30;i++){
            System.out.println("线程开始："+this.name+",i="+i);
        }
    }
}

