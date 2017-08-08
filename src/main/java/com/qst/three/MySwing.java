package com.qst.three;

import javax.swing.*;
import java.awt.*;

/**
 * 类说明：
 *
 * @author zhangchenxi
 * @version 2017/07/21
 */
public class MySwing extends JFrame {
//    public static void main(String[] args) {
//        new MySwing();
//    }

    /**
     * {
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
     */
    private static void createAndShowGUI() {
        // 确保一个漂亮的外观风格
        JFrame.setDefaultLookAndFeelDecorated(true);

        // 创建及设置窗口
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = frame.getContentPane();

        // 添加 "Hello World" 标签
        JLabel label = new JLabel("Hello World");
        container.add(label);

        JButton jb = new JButton("按钮");
        JPanel jp = new JPanel();
//        jp.setSize(200, 120);
        jp.add(jb);
        jp.setPreferredSize(new Dimension(150,70));
        container.add(jp);

        // 显示窗口
        frame.pack();
        frame.setSize(200, 150);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // 显示应用 GUI
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }


//    private MySwing() {
//        Container container = this.getContentPane();
//        container.setLayout(null);
//        JButton bl = new JButton();
//        bl.setText("弹出对话框");
//        bl.setSize(800,450);
//        bl.setHorizontalAlignment(SwingConstants.CENTER);
//        bl.setBounds(10, 10, 100, 21);
//        bl.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                new MyJDialog(MySwing.this).setVisible(true);
//            }
//        });
//        container.add(bl);
//        setVisible(true);
//        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        setSize(1600,900);
//
//    }
//
//    class MyJDialog extends JDialog {
//        public MyJDialog(MySwing frame) {
//            super(frame, "第一个JDialog窗体", true);
//            Container container = getContentPane();
//            container.add(new JLabel("这是一个对话框"));
//            setBounds(120, 120, 100, 100);
//            setSize(700,500);
//        }
//    }

}
