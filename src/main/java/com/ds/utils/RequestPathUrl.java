package com.ds.utils;

/**
 * Constant class for all the test constants
 */
public class RequestPathUrl {

    /**
     * Test URL definition
     */

    public static final String BASE_URL = "http://85.93.17.135:9000";

    public static final String USER = "/user";

    public static final String NEW_USER = BASE_URL + USER + "/new";

    public static final String SAVE_USER = BASE_URL + USER + "/save";

    /**
     * Get ALL USERS API URL definition
     */
    public static final String GET_USERS = BASE_URL + USER + "/all/json";

    /**
     * Delete ALL USERS API URL definition
     */
    public static final String DELETE_USERS = BASE_URL + USER + "/all";

    /**
     * ALL USERS URL definition
     */
    public static final String ALL_USERS = BASE_URL + "/users/all";

    /**
     * Root folder path
     */
    public static final String PATH_ROOT = System.getProperty("user.dir");

    /**
     * Test Report file
     */
    public static final String TEST_REPORT_FILE = "/TestReport.html";

    /**
     * Test Screenshots folder location
     */
    public static final String TEST_SCREENSHOTS = "screenshots/";

    /**
     * Test logs location
     */
    public static final String TEST_LOGS = "/logfile.log";
}
