package com.ds.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.ds.utils.RequestPathUrl;


/**
 * Empty Class for initialising the test suite by using @RunWith annotation
 *
 * @param SuiteClass
 *            name
 */

@RunWith(Suite.class)

@Suite.SuiteClasses({
        RestApiTests.class,
        NewUserGenericTests.class,
        EmailFieldTests.class,
        NameFieldTests.class,
        PasswordFieldTests.class,
        UserListPageTest.class,
         })

public class TestSuiteClass extends TestConfig {

    private static final Logger LOGGER = Logger.getLogger(TestConfig.class);

    @SuppressWarnings("deprecation")
    @BeforeClass
    public static void setTests() throws IOException {
        FileUtils.write(new File(RequestPathUrl.PATH_ROOT.concat(RequestPathUrl.TEST_LOGS)), "");
    }

    @AfterClass
    public static void finishTests() {
        if (driver != null) {
            LOGGER.info("=====Browser Session Ended=====");
            driver.quit();
            report.flush();
        }
    }
}
