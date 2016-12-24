package com.qihoo.study.log.package2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by luoyong on 16-12-6.
 */
public class Test2 {
    public static Logger logger = LoggerFactory.getLogger(Test2.class);

    public void print() {
        logger.info("test2");
    }
}
