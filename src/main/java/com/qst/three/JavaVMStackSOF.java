package com.qst.three;

/**
 * @author zhangchenxi
 * @version 2017/12/06
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLength() {
        stackLength++;
        stackLength();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLength();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
