package com.ds.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.ds.model.User;
import com.ds.pageobject.CreateUserPageObject;
import com.ds.pageobject.CreateUserPageObject.Mode;
import com.ds.pageobject.UserListPageObject;
import com.ds.testdata.TestDataGenerator;
import com.ds.utils.UtililtyFunctions;

/**
 * Test class for validating Generic features of New Users page
 */
public class NewUserGenericTests extends TestConfig {

    private static final Logger LOGGER = Logger.getLogger(NewUserGenericTests.class);

    CreateUserPageObject login = new CreateUserPageObject(driver);

    UserListPageObject allUsers = new UserListPageObject(driver);

    @Rule
    public TestConfig testWatchRule = new TestConfig();

    /**
     * Create one new user before starting the test
     */
    @BeforeClass
    public static void setUpTestName() {
        test = report.startTest("New User Page Generic features validations");
    }

    /**
     * Test case to verify creating user by all valid credentials by clicking SUBMIT button
     *
     * @throws IOException
     *             , InterruptedException
     */
    @Test
    public void verifyCreateUserByEnteringValidCredentials() throws InterruptedException, IOException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        Mode mode = CreateUserPageObject.Mode.SUBMIT_BUTTON;
        User user = TestDataGenerator.createUser();
        login.createNewUserFromMainPage(user);
        login.pressSubmit(mode);
        assertTrue(allUsers.isAllUsersHeaderDisplayed());
        allUsers.clickNewUser();
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }

    /**
     * Test case to verify creating user by all valid credentials by clicking ENTER button
     *
     * @throws IOException
     *             , InterruptedException
     */
    @Test
    public void verifyCreateUserSubmitUsingEnterKey() throws InterruptedException, IOException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        User user = TestDataGenerator.createUser();
        login.createNewUserFromMainPage(user);
        CreateUserPageObject.Mode mode = CreateUserPageObject.Mode.ENTER_KEY;
        login.pressSubmit(mode);
        assertTrue(allUsers.isAllUsersHeaderDisplayed());
        allUsers.clickNewUser();
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }

    /**
     * Test case to verify error on creating user by all blank text fields
     *
     * @throws IOException
     *             , InterruptedException
     */
    @Test
    public void verifyCreateUserByAllFieldsBlank() throws InterruptedException, IOException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        CreateUserPageObject.Mode mode = CreateUserPageObject.Mode.SUBMIT_BUTTON;
        User user = new User();
        login.createNewUserFromMainPage(user);
        login.pressSubmit(mode);
        assertTrue(login.isUserNameErrorExists());
        assertTrue(login.isUserEmailErrorExists());
        assertTrue(login.isUserPasswordErrorExists());
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }

    /**
     * Test case to verify all the fields to reset on page refresh
     *
     * @throws IOException
     *             , InterruptedException
     */
    @Test
    public void verifyPageRefreshAfterFieldsEntry() throws IOException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        User user = new User();
        login.createNewUserFromMainPage(user);
        driver.navigate().refresh();
        assertEquals(login.getNameFieldText(), "");
        assertEquals(login.getEmailFieldText(), "");
        assertEquals(login.getPasswordFieldText(), "");
        assertEquals(login.getConfirmPasswordFieldText(), "");
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }
}
