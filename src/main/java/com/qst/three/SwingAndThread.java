package com.qst.three;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * 类说明：
 *
 * @author zhangchenxi
 * @version 2017/08/15
 */
public class SwingAndThread extends JFrame {
    private JLabel jl = new JLabel();
    private static Thread t;
    private int count = 0;
    private Container container = getContentPane();

    public SwingAndThread() {
        setBounds(1200, 800, 1000, 400);
        container.setLayout(null);
        URL url= null;
        try {
            url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1502817839610&di=fd1a1841dfd66e88a2ddaa503b226210&imgtype=0&src=http%3A%2F%2Fscimg.jb51.net%2Fallimg%2F150811%2F14-150Q1142KAF.jpg");
        }catch (Exception e){

        }
        System.out.println(url);
        Icon icon = new ImageIcon(url);
        jl.setIcon(icon);
        //设置图片在标签的最左方
        jl.setHorizontalAlignment(SwingConstants.LEFT);
        jl.setBounds(10, 10, 200, 50);
        jl.setOpaque(true);
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count <= 800) {
                    //将标签的横坐标用变量表示
                    jl.setBounds(count, 10, 200, 50);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    count += 50;
                    if (count > 800) {
                        //当图标到达标签的最右边时，使其回到标签最左边
                        count = 0;
                    }
                }
            }
        });
        t.start();
        container.add(jl);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] a) {
        new SwingAndThread();
    }
}
