package com.qst.three;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestStackSOF {
    Map<String, JavaVMStackSOF> map = new HashMap<>(30000);

    @Test
    public void test() {
        for (int i = 0; i < 30000; i++) {
            map.put(String.valueOf(i), new JavaVMStackSOF());
        }
        System.out.println(map.toString());
    }
}
