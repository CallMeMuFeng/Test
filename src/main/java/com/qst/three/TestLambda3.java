package com.qst.three;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 中内置的四大核心函数式接口
 * <p>
 * Consumer<T>：消费型接口
 * void accept(T t);
 * <p>
 * Supplier<T>：供给型接口
 * T get();
 * <p>
 * Function<T,R>：函数型接口
 * R apply(T t);
 * <p>
 * Predicate<T>：断言型接口
 * boolean test(T t);
 */
public class TestLambda3 {

    @Test
    public void test1() {
        happy(10000, (m) -> System.out.println("消费" + m + "元"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {
        List<Integer> list = getNumList(10, () -> (int) (Math.random() * 100));
        list.forEach(System.out::println);
    }

    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }

    @Test
    public void test3() {
        String str = strHandler("\t\t\t，我，威武！", (s) -> s.trim());
        System.out.println(str);
    }

    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList("Hello", "atert", "Lambda", "www", "ok");
        List<String> strList = filterStr(list, (s) -> s.length() > 3);
        strList.forEach(System.out::println);
    }

    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        list.forEach(s -> {
            if (pre.test(s)) {
                strList.add(s);
            }
        });
        return strList;
    }
}
