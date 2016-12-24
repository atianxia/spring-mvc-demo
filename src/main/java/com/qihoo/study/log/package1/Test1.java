package com.qihoo.study.log.package1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by luoyong on 16-12-6.
 */
public class Test1 {
    public static Logger logger = LoggerFactory.getLogger(Test1.class);

    public void print(){
        logger.info("test1");
    }

}
