package com.qst.three;

import org.junit.Test;

import java.util.*;

public class TestLambda {

    //原来的匿名内部类
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    //Lambda表达式
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.55),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 3333.33),
            new Employee("田七", 8, 7777.77)
    );

    //需求：获取当前公司中员工年龄大于25的员工信息
//    public void test3() {
//        List<Employee> list = filterEmployees(employees);
//        for (Employee e : list) {
//            System.out.println(e);
//        }
//    }

    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> employeeMyPredicate) {
        List<Employee> emps = new ArrayList<>();

        for (Employee e : list) {
            if (employeeMyPredicate.test(e)) {
                emps.add(e);
            }
        }
        return emps;
    }

    @Test
    public void test5() {
        List<Employee> list = filterEmployee(employees, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() >= 35;
            }
        });
    }

    @Test
    public void tes6() {
        List<Employee> list = filterEmployee(employees, (e) -> e.getSalary() >= 5000);
        list.forEach(System.out::println);
//        list.forEach(e-> System.out.println(e));
    }

    @Test
    public void test7() {
        employees.stream().filter((e) -> e.getSalary() >= 5000)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("=================================");
        employees.stream().map(Employee::getName)
                .forEach(System.out::println);
    }

    @Test
    public void test8() {
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    @Test
    public void test9() {
        String str = strHandler("\t\t\t 我，威武！", (x) -> x.trim());
        System.out.println(str);
        String str2 = strHandler("qdas", (s) -> s.toUpperCase());
        System.out.println(str2);
        String str3 = strHandler(("asdqweasf"), (q) -> q.substring(1, 3));
        System.out.println(str3);
    }

    public String strHandler(String str, MyFun mf) {
        return mf.getValue(str);
    }

    @Test
    public void test10() {
        op(100L, 200L, (x, y) -> x + y);

        op(100L, 200L, (x, y) -> x * y);
    }

    //需求：对于两个Long型处理
    public void op(Long l1, Long l2, MyFunction2<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }
}
