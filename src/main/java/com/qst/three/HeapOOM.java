package com.qst.three;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangchenxi
 * @version 2017/12/06
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }

}
