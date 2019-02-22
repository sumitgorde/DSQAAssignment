package com.ds.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object class for the page where list of all users is displayed.
 */
public class UserListPageObject extends BasePageObject {

    /**
     * Constructor to assign driver of type WebDriver
     */
    public UserListPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Page Factory for element locations
     */

    @FindBy(xpath = ALL_USERS_PAGE_HEADER)
    private WebElement allUsersPageHeader;

    @FindBy(linkText = NEW_USERS_BUTTON)
    private WebElement newUserButton;

    @FindBy(xpath = ALL_USERS_TABLE_LOCATOR)
    private List<WebElement> allUserTable;

    /**
     * All User page heading
     */
    private static final String ALL_USERS_PAGE_HEADER = "(.//*[normalize-space(text()) and normalize-space(.)='Name'])[1]/preceding::h1[1]";

    /**
     * All Users table locator
     */
    private static final String ALL_USERS_TABLE_LOCATOR = "//*[@id=\"users\"]/tbody/tr";

    /**
     * New User button
     */
    private static final String NEW_USERS_BUTTON = "New User";

    /**
     * Method to check presence of All Users Header
     *
     * @return boolean
     */
    public boolean isAllUsersHeaderDisplayed() {
        return isElementDisplayed(allUsersPageHeader);
    }

    /**
     * Method to check presence of New Users Button
     *
     * @return boolean
     */
    public boolean isNewUsersButtonDisplayed() {
        return isElementDisplayed(newUserButton);
    }

    /**
     * Method to get user table size
     *
     * @return int size of array
     */
    public int userTableSize() {
        return allUserTable.size();
    }

    /**
     * Method to get table row from user table
     *
     * @param index
     * @return String
     */
    public String getElementTextFromUserTable(int index) {
        return allUserTable.get(index).getText();
    }

    /**
     * Method to click New User button
     */
    public void clickNewUser() {
            newUserButton.click();
    }
}
