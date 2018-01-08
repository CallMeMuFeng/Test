package com.qst.three;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 一：Lambda表达式的基础语法：Java8中引入了一个新的操作符“->”，称为箭头操作符或者Lambda操作符
 * 将Lambda表达式拆分为两部分：
 * <p>
 * 左侧：Lambda表达式的参数列表
 * 右侧：Lambda表达式所需执行的功能，即Lambda体
 * <p>
 * 语法格式一：无参数，无返回值
 * () -> System.out.println("Hello Lambda");
 * <p>
 * 语法格式二：有一个参数，并且无返回值
 * (x) -> System.out.println(x);
 * <p>
 * 语法格式三：若只有一个参数，小括号可以省略不写
 * x -> System.out.println(x);
 * <p>
 * 语法格式四：有两个以上参数，有返回值，并且Lambda体中有多条语句
 * Comparator<Integer> com = (o1, o2) -> {
 * System.out.println("函数式接口");
 * return Integer.compare(o1, o2);
 * };
 * <p>
 * 语法格式五：若Lambda体重只有一条语句，return和大括号都可以省略不写
 * Comparator<Integer> com = (o1, o2) -> Integer.compare(o1, o2);
 * <p>
 * 语法格式六：Lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器可以通过上下文推断出类型，即“类型推断”
 * <p>
 * 二：Lambda表达式需要函数式接口的支持
 * 若接口中只有一个抽象方法，就叫函数式接口，可以使用@FunctionalInterface修饰，可以检查是否是函数式接口，也就是说该注解注解的方法必须是函数式接口
 */
public class TestLambda2 {

    @Test
    public void test1() {
        int num = 0;//jdk1.7之前，必须是final，1.8开始默认是final，不用加final，无法++
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!" + num);
            }
        };

        r.run();

        System.out.println("----------------------------");

        Runnable r1 = () -> System.out.println("Hello Lambda!");
        r1.run();
    }

    @Test
    public void test2() {
        Consumer<String> con = (t) -> System.out.println(t);
        Consumer<String> con1 = t -> System.out.println(t);
        con.accept("我，威武！");
        con1.accept("我，威武！");
    }

    @Test
    public void test3() {
        Comparator<Integer> com = (o1, o2) -> {
            System.out.println("函数式接口");
            return Integer.compare(o1, o2);
        };
    }

    @Test
    public void test4() {
        Comparator<Integer> com = (o1, o2) -> Integer.compare(o1, o2);
    }

    //需求：对一个数进行运算
    @Test
    public void test6() {
        Integer integer = operation(100, (i) -> i * i);
        System.out.println(integer);

        System.out.println(operation(200, (x) -> x + 200));
    }

    public Integer operation(Integer num, MyFunction mf) {
        return mf.getValue(num);
    }
}
