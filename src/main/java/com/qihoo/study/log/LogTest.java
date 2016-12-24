package com.qihoo.study.log;

import com.qihoo.study.log.package1.Test1;
import com.qihoo.study.log.package2.Test2;

/**
 * Created by luoyong on 16-12-6.
 */
public class LogTest {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.print();

        Test2 test2 = new Test2();
        test2.print();
    }
}
