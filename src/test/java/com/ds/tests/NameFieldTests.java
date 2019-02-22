package com.ds.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
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
 * Test class for validating New Users name field
 */
public class NameFieldTests extends TestConfig {

    private static final Logger LOGGER = Logger.getLogger(NameFieldTests.class);

    CreateUserPageObject createUser = new CreateUserPageObject(driver);

    UserListPageObject allUsers = new UserListPageObject(driver);

    @Rule
    public TestConfig testWatchRule = new TestConfig();

    /**
     * Create one new user before starting the test
     */
    @BeforeClass
    public static void createNewUser() throws InterruptedException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        test = report.startTest("New User name field validations");
        Mode mode = Mode.ENTER_KEY;
        User user = TestDataGenerator.createUser();
        LOGGER.info("Email " + user.getEmail());
        CreateUserPageObject login = new CreateUserPageObject(driver);
        login.createNewUserFromMainPage(user);
        login.pressSubmit(mode);

        UserListPageObject allUsers = new UserListPageObject(driver);
        allUsers.clickNewUser();
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }

    /**
     * LOGGER the ending of tests
     */
    @AfterClass
    public static void logTestEnd() {
        LOGGER.info("Leaving NewUserCreationNameFieldTests");
    }

    /**
     * Test case to verify error when trying to create new user with blank Name field
     *
     * @throws IOException,InterruptedException
     */
    @Test
    public void verifyCreatingNewUserWithBlankName() throws IOException {
        final String currentMethodName = "verifyCreatingNewUserWithBlankName()";
        LOGGER.info("Start " + currentMethodName);
        Mode mode = Mode.SUBMIT_BUTTON;
        User user = new User();
        LOGGER.info("Email " + user.getEmail());
        createUser.createNewUserFromMainPage(user);
        createUser.pressSubmit(mode);
        assertTrue(createUser.isUserEmailErrorExists());
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }
}
