package com.qst.three;

import org.junit.Test;

import java.util.*;

public class TestCollection {

    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.subList(0, 2).add("4");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            if (iterator.next().equals("3")){
                iterator.remove();
                System.out.println(list.size());
            }
        }
//        list.remove("3");
        System.out.println(list);
//        ArrayList<String> list1 = (ArrayList<String>) list.subList(0, 2);
    }

    @Test
    public void test2() {
        String[] s = new String[]{"1", "2", "3"};
//        List<String> list = Arrays.asList(s);
        List<String> list = new ArrayList<>(Arrays.asList(s));
        System.out.println(list.add("4"));
    }

    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("1")) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    @Test
    public void test4() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        for (String s : list) {
            if (s.equals("2")) {
                list.remove(s);
            }
        }
        System.out.println(list);
    }

    @Test
    public void test5(){
        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a==b);
    }

}
