package com.ds.tests;

import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.ds.model.User;
import com.ds.restservice.APIMethods;
import com.ds.utils.UtililtyFunctions;

import io.restassured.response.Response;

public class RestApiTests extends TestConfig {

    private static final Logger LOGGER = Logger.getLogger(RestApiTests.class);

    @Rule
    public TestConfig testWatchRule = new TestConfig();

    @BeforeClass
    public static void setUpTestName() {
        test = report.startTest("RestApiTest");
    }

    @Test
    public void listOfAllRegisteredUsers() {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        Response response = null;
        response = APIMethods.getUsers();
        List<User> users = getUserListFromResponse(response);
        for (User user : users) {
            LOGGER.info(user.getName() + "\t" + user.getEmail() + "\n");
        }
        assertEquals(SC_OK, response.getStatusCode());
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }

    @Test
    public void deleteAllUsers() {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        Response response = null;
        response = APIMethods.deleteUsers();
        assertEquals(SC_OK, response.getStatusCode());
        response = APIMethods.getUsers();
        assertTrue(getUserListFromResponse(response).isEmpty());
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }

    private List<User> getUserListFromResponse(Response response) {

        List<User> users = Arrays.asList(response.getBody().as(User[].class));
        return users;
    }

}
