package com.qihoo.study.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * Created by luoyong on 16-10-24.
 */
public class LogbackTest {

	public static void main(String[] args) {
//		Logger logger = LoggerFactory.getLogger("com.qihoo.study.logback.LogbackTest");
//		logger.debug("Hello world.");
//		
//
//	    // print internal state
//	    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//	    StatusPrinter.print(lc);
	    
		// get a logger instance named "com.foo". Let us further assume that the
		// logger is of type  ch.qos.logback.classic.Logger so that we can
		// set its level
		ch.qos.logback.classic.Logger logger = 
		        (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.foo");
		//set its Level to INFO. The setLevel() method requires a logback logger
		logger.setLevel(Level. INFO);

		Logger barlogger = LoggerFactory.getLogger("com.foo.Bar");

		// This request is enabled, because WARN >= INFO
		logger.warn("Low fuel level.");

		// This request is disabled, because DEBUG < INFO. 
		logger.debug("Starting search for nearest gas station.");

		// The logger instance barlogger, named "com.foo.Bar", 
		// will inherit its level from the logger named 
		// "com.foo" Thus, the following request is enabled 
		// because INFO >= INFO. 
		barlogger.info("Located nearest gas station.");

		// This request is disabled, because DEBUG < INFO. 
		barlogger.debug("Exiting gas station search");
	    
	}
}
