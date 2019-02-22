package com.ds.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

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
import com.ds.testdata.TestDataGenerator;
import com.ds.utils.UtililtyFunctions;

/**
 * Test class for validating Password field
 */
public class PasswordFieldTests extends TestConfig {

    private static final Logger LOGGER = Logger.getLogger(PasswordFieldTests.class);

    static CreateUserPageObject createUser = new CreateUserPageObject(driver);

    static UserListPageObject allUsers = new UserListPageObject(driver);

    @Rule
    public TestConfig testWatchRule = new TestConfig();

    /**
     * Create one new user before starting the test
     */
    @BeforeClass
    public static void createNewUser() throws InterruptedException {
        test = report.startTest("New User Password field validations");
        try {
            Mode mode = CreateUserPageObject.Mode.ENTER_KEY;
            User user = TestDataGenerator.createUser();
            LOGGER.info("Email " + user.getEmail());
            createUser.createNewUserFromMainPage(user);
            createUser.pressSubmit(mode);
        } catch (NoSuchElementException e) {
            LOGGER.error("Element not found");
        } finally {
            allUsers.clickNewUser();
        }
    }

    /**
     * LOGGER the ending of tests
     */
    @AfterClass
    public static void logTestEnd() {
        LOGGER.info("Leaving NewUserCreationPasswordFieldTests");
    }

    /**
     * Test case to verify error when trying to create new user with blank password
     * field and valid confirm password field
     *
     * @throws IOException,InterruptedException
     */
    @Test
    public void verifyCreatingNewUserWithBlankPwdFieldAndValidCnfPasswordField()
            throws IOException,
            InterruptedException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        CreateUserPageObject.Mode mode = CreateUserPageObject.Mode.SUBMIT_BUTTON;
        User user = TestDataGenerator.createUser();
        user.setPasswordHash("");
        user.setConfPasswordHash(new TestDataGenerator().password());
        LOGGER.info("Email " + user.getEmail());
        createUser.createNewUserFromMainPage(user);
        createUser.pressSubmit(mode);
        assertTrue(createUser.isUserPasswordErrorExists());
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }

    /**
     * Test case to verify error when trying to create new user with valid password
     * field and blank confirm password field
     *
     * @throws IOException,InterruptedException
     */
    @Test
    public void verifyCreatingNewUserWithValidPwdFieldAndBlankCnfPasswordField()
            throws IOException,
            InterruptedException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        CreateUserPageObject.Mode mode = CreateUserPageObject.Mode.SUBMIT_BUTTON;
        User user = TestDataGenerator.createUser();
        user.setConfPasswordHash("");
        LOGGER.info("Email " + user.getEmail());
        createUser.createNewUserFromMainPage(user);
        createUser.pressSubmit(mode);
        assertTrue(createUser.isUserConfirmPasswordErrorExists());
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }

    /**
     * Test case to verify error when trying to create new user with valid password
     * field and different confirm password field
     *
     * @throws IOException,InterruptedException
     */
    @Test
    public void verifyCreatingNewUserWithValidPwdFieldAndDifferentCnfPasswordField()
            throws IOException,
            InterruptedException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        CreateUserPageObject.Mode mode = CreateUserPageObject.Mode.SUBMIT_BUTTON;
        User user = TestDataGenerator.createUser();
        user.setConfPasswordHash(new TestDataGenerator().password());
        LOGGER.info("Email " + user.getEmail());
        createUser.createNewUserFromMainPage(user);
        createUser.pressSubmit(mode);
        assertTrue(createUser.isUserConfirmPasswordErrorExists());
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }

    /**
     * Test case to verify error when trying to create new user with password length < 6
     *
     * @throws IOException,InterruptedException
     */
    @Test
    public void verifyCreatingNewUserWithPasswordMinLength() throws IOException, InterruptedException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        CreateUserPageObject.Mode mode = CreateUserPageObject.Mode.SUBMIT_BUTTON;
        User user = TestDataGenerator.createUser();
        user.setPasswordHash("qwed");
        user.setConfPasswordHash("qwed");
        LOGGER.info("Email " + user.getEmail());
        createUser.createNewUserFromMainPage(user);
        createUser.pressSubmit(mode);
        assertTrue(createUser.isUserPasswordErrorExists());
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }

}
