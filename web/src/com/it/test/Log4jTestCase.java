package com.it.test;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Administrator on 2016/6/13.
 */
public class Log4jTestCase {
    @Test
    public void testLog4j() {
        Logger logger = LoggerFactory.getLogger(Log4jTestCase.class);
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
        //logger.fatal("fatal message");


    }


}
