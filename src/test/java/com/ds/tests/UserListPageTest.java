package com.ds.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.junit.AfterClass;
import org.junit.Assert;
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
 * Test class for validating All Users Page
 */
public class UserListPageTest extends TestConfig {

    private static final Logger LOGGER = Logger.getLogger(TestConfig.class);

    private static CreateUserPageObject createUserPage = new CreateUserPageObject(driver);

    private static UserListPageObject userListPage = new UserListPageObject(driver);

    @Rule
    public TestConfig testWatchRule = new TestConfig();

    /**
     * Create 5 new users before starting the tests
     *
     * @throws InterruptedException
     */
    @BeforeClass
    public static void createFiveNewUsers() throws InterruptedException {
        LOGGER.info("Entering into AllUsersPageTest");
        test = report.startTest("UserListPageTest");
        for (int i = 0; i < 5; i++) {
            try {
                Mode mode = Mode.ENTER_KEY;
                User user = TestDataGenerator.createUser();
                LOGGER.info("Email created :: " + user.getEmail());
                createUserPage.createNewUserFromMainPage(user);
                createUserPage.pressSubmit(mode);
            } catch (NoSuchElementException e) {
                System.out.println("Element not found");
            } finally {
                userListPage.clickNewUser();

            }
        }
    }

    /**
     * LOGGER the ending of tests
     */
    @AfterClass
    public static void logTestEnd() {
        LOGGER.info("Leaving AllUsersPageTest");
    }

    /**
     * Test case to verify page header on user List page
     *
     * @throws IOException,InterruptedException
     */
    @Test
    public void verifyAllUserPageHeader() throws IOException, InterruptedException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        createUserPage.clickAllUsersButton();
        assertTrue(userListPage.isAllUsersHeaderDisplayed());
        userListPage.clickNewUser();
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }

    /**
     * Test case to verify New User button on All Users page
     *
     * @throws IOException,InterruptedException
     */
    @Test
    public void verifyCreateUserButtonDisplay() throws IOException, InterruptedException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        createUserPage.clickAllUsersButton();
        assertTrue(userListPage.isNewUsersButtonDisplayed());
        userListPage.clickNewUser();
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }

    /**
     * Test case to verify Users table size by comparing with REST GET service
     *
     * @throws IOException,InterruptedException
     */
    @Test
    public void verifyUsersTableSize() throws IOException, InterruptedException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        createUserPage.clickAllUsersButton();
        Response response = APIMethods.getUsers();
        LOGGER.info("Total users :: " + response.getBody().asString());
        JSONArray obj = new JSONArray(response.asString());
        Assert.assertEquals(obj.length(), userListPage.userTableSize());
        userListPage.clickNewUser();
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }

    /**
     * Test case to verify newly created user to be appearing at the bottom of table
     *
     * @throws IOException,InterruptedException
     */
    @Test
    public void verifyUsersCreatedListedAtTheLastRow() throws IOException, InterruptedException {
        final String currentMethodName = UtililtyFunctions.getCurrentMethodName();
        LOGGER.info("Start " + currentMethodName);
        Mode mode = Mode.ENTER_KEY;
        User user = TestDataGenerator.createUser();
        LOGGER.info("Email created :: " + user.getEmail());
        createUserPage.createNewUserFromMainPage(user);
        createUserPage.pressSubmit(mode);
        assertTrue(
            userListPage.getElementTextFromUserTable(userListPage.userTableSize() - 1).contains(user.getEmail()));
        userListPage.clickNewUser();
        LOGGER.info("End " + UtililtyFunctions.getCurrentMethodName());
    }
}
