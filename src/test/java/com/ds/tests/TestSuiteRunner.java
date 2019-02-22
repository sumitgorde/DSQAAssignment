package com.ds.tests;


import org.apache.log4j.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Class for initialising the test runner
 */
public class TestSuiteRunner {

    private static final Logger LOGGER = Logger.getLogger(TestConfig.class);

    public static void main(String[] args) {
        /**
         * Initialise Result class for collecting the test case run details
         */
        Result result = JUnitCore.runClasses(TestSuiteClass.class);

        for (Failure failure : result.getFailures()) {
            LOGGER.error(failure.toString());
        }

        LOGGER.info("=====" + result.wasSuccessful());
    }
}
