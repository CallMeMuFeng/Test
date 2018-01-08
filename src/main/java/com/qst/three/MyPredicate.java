package com.qst.three;

@FunctionalInterface
public interface MyPredicate<T> {

    boolean test(T t);

}
