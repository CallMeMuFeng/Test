package com.qst.three;

import java.util.Arrays;

/**
 * 类说明：
 *
 * @author zhangchenxi
 * @version 2017/08/01
 */
public class MyClass<T> {
    private String name;
    private Integer age;
    private T[] friends;
    private T no;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public T[] getFriends() {
        return friends;
    }

    public void setFriends(T[] friends) {
        this.friends = friends;
    }

    public T getNo() {
        return no;
    }

    public void setNo(T no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friends=" + Arrays.toString(friends) +
                ", no=" + no +
                '}';
    }
}
