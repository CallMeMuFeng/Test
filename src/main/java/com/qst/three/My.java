package com.qst.three;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;

/**
 * 类说明：
 *
 * @author zhangchenxi
 * @version 2017/08/01
 */
public class My {

    /**
     * DecimalFormat
     */
    @Test
    public void test1() {
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(0.1251111));
        BigDecimal bigDecimal = new BigDecimal(0);
        System.out.println("BigDecimal:" + bigDecimal.intValue());

        String i = (String) null;
        System.out.println("强转null:" + i);

        Double d = 0.00;
        System.out.println(d.equals(0.0));
    }

    /**
     * BigDecimal
     */
    @Test
    public void test2() {
        BigDecimal b = new BigDecimal(12.345).setScale(2, RoundingMode.UP);
        System.out.println(b);
    }

    /**
     * Lambda表达式
     */
    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("BC");
        list.add("DEF");
        String a = "hi";
        list.forEach(e -> {
            e += a;
            System.out.println(e);
        });
    }

    /**
     * string排序
     */
    @Test
    public void test4() {
        String s = "BCA";
        char[] c = s.toCharArray();
        Arrays.sort(c);
        String s1 = String.copyValueOf(c);
        System.out.println(s1);
    }

    /**
     * stringBuffer
     */
    @Test
    public void test5() {
        StringBuffer sb = new StringBuffer();
        sb.append("a");
        sb.append("b").append('c' + " ").append(123);
        System.out.println(sb);
    }

    /**
     * 强转string与toString的效率对比
     */
    @Test
    public void Test6() {
        List<Object> list = new ArrayList<>();
        list.add("abc");
        long l1;
        long l2;

        l1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            String s = (String) list.get(0);
        }
        l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);

        l1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            String s = list.get(0).toString();
        }
        l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
    }

    /**
     * ==跟equals
     */
    @Test
    public void test7() {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
    }

    /**
     * ==跟equals
     */
    @Test
    public void test8() {
        String s1 = "s";
        String s2 = "s";
        String s3 = new String("s");
        String s4 = new String("asd");
        String s5 = new String("asd");
        System.out.println(s1 == s2);
        System.out.println(s3 == s1);
        System.out.println(s4 == s5);
        System.out.println(s3.intern() == s1.intern());
        System.out.println(s4.intern() == s5.intern());
    }

    /**
     * swing
     */
    @Test
    public void test9() {
        JFrame jf = new JFrame("创建一个JFrame窗体哈哈哈");
        Container container = jf.getContentPane();
        JLabel jl = new JLabel("这是一个JFrame窗体");
        container.add(jl);
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        container.setBackground(Color.WHITE);
        jf.setVisible(true);
        jf.setSize(1600, 800);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     *
     */
    @Test
    public void test10() {
        String s = "aabbcccddaaaaan";
        Character c = s.charAt(0);
        int sum = 1;
        String s1 = "";

        if (s.length() == 1) {
            s1 = s + 1;
        }

        for (int i = 1; i < s.length(); i++) {
            if (c.equals(s.charAt(i))) {
                sum++;
            } else {
                s1 = s1 + c + sum;
                sum = 1;
                c = s.charAt(i);
                if (i == s.length() - 1) {
                    s1 = s1 + c + 1;
                }
            }
        }
        if (s.length() > 1 && s.charAt(s.length() - 1) == s.charAt(s.length() - 2)) {
            s1 = s1 + s.charAt(s.length() - 1) + sum;
        }
        System.out.println(s1);
    }

    /**
     * 泛型
     */
    @Test
    public void test11() {
        MyClass<Date> myClass = new MyClass<>();
        myClass.setName("three！");
        myClass.setAge(20);
        myClass.setFriends(new Date[]{new Date()});
        myClass.setNo(new Date());
        System.out.println(myClass);
    }

    /**
     * 泛型
     */
    @Test
    public void test12() {
        MyClass<String> myClass = new MyClass<>();
        myClass.setNo("asd");
        myClass.setNo("asd");
        myClass.setAge(20);
        myClass.setFriends(new String[]{"s", "sa", "sda"});
        System.out.println(myClass);
    }

    /**
     * 泛型
     */
    @Test
    public void test13() {
        List<String> list1 = new ArrayList<>();
        list1.add("asd");
        List<Integer> list2 = new ArrayList<>();
        list2.add(123);
        List<? extends Comparable> list3 = list1;
        System.out.println(list3.get(0));
        list3 = list2;
        System.out.println(list3.get(0));
    }

    /**
     * 调用泛型
     */
    @Test
    public void test14() {
        List<Integer> list = new ArrayList<>();
        list.add(123);
        System.out.println(test15(list));
    }

    /**
     * 泛型
     *
     * @param list
     * @return
     */
    public String test15(List<? extends Number> list) {
        return list.toString();
    }

    /**
     * IO流
     */
    @Test
    public void test16() {
        String s = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz23456789";
        Random random = new Random();
        char[] result = new char[4];
        int len = s.length();
        for (int i = 0; i < 4; i++) {
            result[i] = s.charAt(random.nextInt(len));
        }
        File file = new File("/home/asus/test.txt");
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
//            fos = new FileOutputStream(file);
//            fos.write(s.getBytes());
            fis = new FileInputStream("/home/asus/test.txt");
            Long l = file.length();
            byte[] b = new byte[l.intValue()];
            fis.read(b);
            System.out.println(new String(b));
        } catch (IOException e) {

        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {

                }
            }
        }
    }

    /**
     * 多线程
     */
    @Test
    public void test17() {
        Thread1 thread1 = new Thread1("hello");
        Thread1 thread2 = new Thread1("world");
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//
//        }
        new Thread(thread1).start();
//        System.out.println("333");
        new Thread(thread2).start();
//        System.out.println("444");
    }

    /**
     * 多线程单元测试不管用，main方法管用
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1("hello");
        Thread1 thread2 = new Thread1("world");
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//
//        }
        new Thread(thread1).start();
//        System.out.println("333");
        new Thread(thread2).start();
//        System.out.println("444");
    }

    /**
     * 删除文件
     */
    @Test
    public void test18() {
        File file = new File("/home/asus/text.txt");
        if (file.exists()) {
            file.delete();
            System.out.println("成功");
        } else {
            System.out.println("文件不存在！");
        }
    }

    @Test
    public void test19() {
        List<String> list = new ArrayList<>(10000000);
        for (int i = 0; i < 10000000; i++) {
            list.add(new String("a"));
        }
        long l1 = System.currentTimeMillis();
        list.forEach(e -> {

        });
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
        long l3 = System.currentTimeMillis();
        for (String s : list) {

        }
        long l4 = System.currentTimeMillis();
        System.out.println(l4 - l3);
    }

    @Test
    public void test20() {
        String a = "asd";
        a += "qwe";
        System.out.println(a);
    }

    @Test
    public void test21() {
        String a = "asd";
        for (int i = 0; i < 1; i++) {
            a += "qwe";
        }
        System.out.println(a);
    }
}
