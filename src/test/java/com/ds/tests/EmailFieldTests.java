package com.ds.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.ds.model.User;
import com.ds.pageobject.CreateUserPageObject;
import com.ds.pageobject.CreateUserPageObject.Mode;
import com.ds.pageobject.UserListPageObject;
import com.ds.restservice.APIMethods;
import com.ds.testdata.TestDataGenerator;
import com.ds.utils.UtililtyFunctions;

import io.restassured.response.Response;

/**
 * Test class for validating New Users Email field
 */
public class EmailFieldTests extends TestConfig {

    private static final Logger LOGGER = Logger.getLogger(EmailFieldTests.class);

    CreateUserPageObject createUser = new CreateUserPageObject(driver);

    UserListPageObject allUsers = new UserListPageObject(driver);

    @Rule
    public TestConfig testWatchRule = new TestConfig();

    /**
     * Create one new user before starting the test
     */
    @BeforeClass
    public static void createNewUser() throws InterruptedException {
        LOGGER.info("Start " + UtililtyFunctions.getCurrentMethodName());
        test = report.startTest("New User Email field validations");
        try {
            Mode mode = Mode.ENTER_KEY;
            User user = TestDataGenerator.createUser();
            LOGGER.info("Email :: " + user.getEmail());
            CreateUserPageObject login = new CreateUserPageObject(driver);
            login.createNewUserFromMainPage(user);
            login.pressSubmit(mode);
        } catch (NoSuchElementException e) {
            LOGGER.error("Element not found");
        } finally {
            UserListPageObject allUsers = new UserListPageObject(driver);
            allUsers.clickNewUser();
        }
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }

    /**
     * LOGGER the ending of tests
     */
    @AfterClass
    public static void logTestEnd() {
        LOGGER.info("Leaving UserCreationEmailFieldTests");
    }

    /**
     * Test case to verify error when trying to create new user of existing email
     *
     * @throws IOException,InterruptedException
     */
    @Test
    public void verifyCreatingNewUserWithExistingEmail() throws IOException, InterruptedException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        CreateUserPageObject.Mode mode = CreateUserPageObject.Mode.SUBMIT_BUTTON;
        Response response = APIMethods.getUsers();
        List<User> users = Arrays.asList(response.getBody().as(User[].class));
        User existingUser = users.get(0);
        User newUser = TestDataGenerator.createUser();
        newUser.setEmail(existingUser.getEmail());
        LOGGER.info("Email :: " + existingUser.getEmail());
        createUser.createNewUserFromMainPage(newUser);
        createUser.pressSubmit(mode);
        assertTrue(createUser.isUserEmailErrorExists());
        LOGGER.info("End " + currentMethodName);
    }

    /**
     * Test case to verify error when trying to create new user without "@" symbol in email
     *
     * @throws IOException,InterruptedException
     */
    @Test
    public void verifyCreatingNewUserWithoutAtSymbolInEmail() throws IOException, InterruptedException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        //try {
        Mode mode = Mode.SUBMIT_BUTTON;
        User user = TestDataGenerator.createUser();
        user.setEmail("asdck.com");
        LOGGER.info("Email :: " + user.getEmail());
        createUser.createNewUserFromMainPage(user);
        createUser.pressSubmit(mode);
        assertTrue(createUser.isUserEmailErrorExists());
        LOGGER.info("End " + currentMethodName);
    }

    /**
     * Test case to verify error when trying to create new user of without ".com" in the email
     *
     * @throws IOException,InterruptedException
     */
    @Test
    public void verifyCreatingNewUserWithoutdotcomInEmail() throws IOException, InterruptedException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        CreateUserPageObject.Mode mode = Mode.SUBMIT_BUTTON;
        User user = TestDataGenerator.createUser();
        user.setEmail("asc@wer");
        LOGGER.info("Email :: " + user.getEmail());
        createUser.createNewUserFromMainPage(user);
        createUser.pressSubmit(mode);
        assertTrue(createUser.isUserEmailErrorExists());
        LOGGER.info("End " + currentMethodName);
    }

    /**
     * Test case to verify error when trying to create new user without prefix in email
     *
     * @throws IOException,InterruptedException
     */
    @Test
    public void verifyCreatingNewUserWithoutPrefixInEmail() throws IOException, InterruptedException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        CreateUserPageObject.Mode mode = Mode.SUBMIT_BUTTON;
        User user = TestDataGenerator.createUser();
        user.setEmail("@testData.com");
        LOGGER.info("Email :: " + user.getEmail());
        createUser.createNewUserFromMainPage(user);
        createUser.pressSubmit(mode);
        assertTrue(createUser.isUserEmailErrorExists());
        LOGGER.info("End " + currentMethodName);
    }

}
