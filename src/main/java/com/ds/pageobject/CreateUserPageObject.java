package com.ds.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ds.model.User;
import com.ds.utils.RequestPathUrl;
import com.ds.utils.UtililtyFunctions;

/**
 * A page object for a creating new user
 */
public class CreateUserPageObject extends BasePageObject {

    private static final Logger LOGGER = Logger.getLogger(CreateUserPageObject.class);
    /**
     * Constructor to assign driver of type WebDriver
     */
    public CreateUserPageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * PageFactory element assignments
     */
    @FindBy(id = USER_NAME_TEXT_AREA)
    private WebElement userNameField;

    @FindBy(id = EMAIL_TEXT_AREA)
    private WebElement emailField;

    @FindBy(id = PASSWORD_TEXT_AREA)
    private WebElement passwordField;

    @FindBy(id = CONFIRMATION_PASSWORD_TEXT_AREA)
    private WebElement passwordConfirmationField;

    @FindBy(xpath = SUBMIT_BUTTON)
    private WebElement submitButton;

    @FindBy(linkText = ALL_USERS_BUTTON)
    private WebElement allUsersButton;

    @FindBy(xpath = NEW_USER_PAGE_HEADING)
    private WebElement pageHeader;

    @FindBy(xpath = NAME_LABEL)
    private WebElement nameLabel;

    @FindBy(xpath = PASSWORD_LABEL)
    private WebElement passwordLabel;

    @FindBy(xpath = EMAIL_LABEL)
    private WebElement emailLabel;

    @FindBy(xpath = CONFIRM_PASSWORD_LABEL)
    private WebElement passwordConfirmationLabel;

    @FindBy(id = USER_NAME_ERROR)
    private WebElement userNameError;

    @FindBy(id = USER_EMAIL_ERROR)
    private WebElement userEmailError;

    @FindBy(id = USER_PASSWORD_ERROR)
    private WebElement userPwdError;

    @FindBy(id = USER_CONF_PASSWORD_ERROR)
    private WebElement userConfPwdError;

    /**
     * Creating allUsers Object of class AllUsersPageTest
     */
    UserListPageObject allUsers = new UserListPageObject(driver);

    /**
     * Username text edit area from the landing page
     */
    private static final String USER_NAME_TEXT_AREA = "name";

    /**
     * Email text edit area from the landing page
     */
    private static final String EMAIL_TEXT_AREA = "email";

    /**
     * Email text edit area from the landing page
     */
    private static final String PASSWORD_TEXT_AREA = "password";

    /**
     * Email text edit area from the landing page
     */
    private static final String CONFIRMATION_PASSWORD_TEXT_AREA = "confirmationPassword";

    /**
     * Login button from the landing page
     */
    private static final String SUBMIT_BUTTON = "(.//*[normalize-space(text()) and normalize-space(.)='All User'])[1]/following::button[1]";

    /**
     * All Users button from the landing page
     */
    private static final String ALL_USERS_BUTTON = "All User";

    /**
     * New User page heading
     */
    private static final String NEW_USER_PAGE_HEADING = "(.//*[normalize-space(text()) and normalize-space(.)='New User'])[2]/following::label[1]";

    /**
     * New User page heading
     */
    private static final String NAME_LABEL = "(.//*[normalize-space(text()) and normalize-space(.)='Name:'])[1]/following::label[1]";

    /**
     * New User page heading
     */
    private static final String EMAIL_LABEL = "(.//*[normalize-space(text()) and normalize-space(.)='Email:'])[1]/following::label[1]";

    /**
     * New User page heading
     */
    private static final String PASSWORD_LABEL = "(.//*[normalize-space(text()) and normalize-space(.)='Password:'])[1]/following::label[1]";

    /**
     * New User page heading
     */
    private static final String CONFIRM_PASSWORD_LABEL = "/html/body/div/div/div/form/fieldset/div[4]/label";

    /**
     * User name error element
     */
    private static final String USER_NAME_ERROR = "user.name.error";

    /**
     * User email error element
     */
    private static final String USER_EMAIL_ERROR = "user.email.error";

    /**
     * User password error element
     */
    private static final String USER_PASSWORD_ERROR = "user.password.error";

    /**
     * User confirmation password error element
     */
    private static final String USER_CONF_PASSWORD_ERROR = "user.confirmationPassword.error";

    /**
     * Declaring ENUMs for various kinds of submit operations
     */
    public enum Mode {
        ENTER_KEY,
        SUBMIT_BUTTON;
    }

    public String getNameFieldText() {
        return userNameField.getText();
    }

    /**
     * Method to get the text of email field
     *
     * @return String
     */
    public String getEmailFieldText() {
        return emailField.getText();
    }

    /**
     * Method to get the text of password field
     *
     * @return String
     */
    public String getPasswordFieldText() {
        return passwordField.getText();
    }

    /**
     * Method to get the text of confirm password field
     *
     * @return String
     */
    public String getConfirmPasswordFieldText() {
        return passwordConfirmationField.getText();
    }

    /**
     * Method to check if page header is displayed
     *
     * @return boolean
     */
    public boolean isHeaderDisplayed() {
        return isElementDisplayed(pageHeader);
    }

    /**
     * Method to check if Name label is displayed
     *
     * @return boolean
     */
    public boolean isNameLabelDisplayed() {
        return isElementDisplayed(nameLabel);
    }

    /**
     * Method to check if email label is displayed
     *
     * @return boolean
     */
    public boolean isEmailLabelDisplayed() {
        return isElementDisplayed(emailLabel);
    }

    /**
     * Method to check if password label is displayed
     *
     * @return boolean
     */
    public boolean isPasswordLabelDisplayed() {
        return isElementDisplayed(passwordLabel);
    }

    /**
     * Method to check if confirm password is displayed
     *
     * @return boolean
     */
    public boolean isConfirmPasswordDisplayed() {
        return isElementDisplayed(passwordConfirmationLabel);
    }

    /**
     * Method to check if All users button is displayed
     *
     * @return boolean
     */
    public boolean isAllUsersButtonDisplayed() {
        return isElementDisplayed(allUsersButton);
    }

    /**
     * Method to check if Submit button is displayed
     *
     * @return boolean
     */
    public boolean isSubmitButtonDisplayed() {
        return isElementDisplayed(submitButton);
    }

    /**
     * Method to get field name placeholder text
     *
     * @return String
     */
    public String getNameFieldPlaceholderText() {
        return UtililtyFunctions.getPlaceholderAttributeValue(userNameField);
    }

    /**
     * Method to get field email placeholder text
     *
     * @return String
     */
    public String getEmailFieldPlaceholderText() {
        return UtililtyFunctions.getPlaceholderAttributeValue(emailField);
    }

    /**
     * Method to get field password placeholder text
     *
     * @return String
     */
    public String getPasswordFieldPlaceholderText() {
        return UtililtyFunctions.getPlaceholderAttributeValue(passwordField);
    }

    /**
     * Method to get field confirm password placeholder text
     *
     * @return String
     */
    public String getConfirmPasswordFieldPlaceholderText() {
        return UtililtyFunctions.getPlaceholderAttributeValue(passwordConfirmationField);
    }

    /**
     * Method to check if name error displayed
     *
     * @return boolean
     */
    public boolean isUserNameErrorExists() {
        return isElementDisplayed(userNameError);
    }

    /**
     * Method to check if email error displayed
     *
     * @return boolean
     */
    public boolean isUserEmailErrorExists() {
        return isElementDisplayed(userEmailError);
    }

    /**
     * Method to check if password error displayed
     *
     * @return boolean
     */
    public boolean isUserPasswordErrorExists() {
        return isElementDisplayed(userPwdError);
    }

    /**
     * Method to check if confirm password error displayed
     *
     * @return boolean
     */
    public boolean isUserConfirmPasswordErrorExists() {
        return isElementDisplayed(userConfPwdError);
    }

    /**
     * Method to click All User button
     */
    public void clickAllUsersButton() {
        try {
            allUsersButton.click();
        } catch (NoSuchElementException e) {
            LOGGER.error("Element not present " , e);
        }
    }

    /**
     * Method to create user with login credentials
     */
    public void createNewUserFromMainPage(User user) {
        try {
            userNameField.clear();
            userNameField.sendKeys(user.getName());
            emailField.clear();
            emailField.sendKeys(user.getEmail());
            passwordField.clear();
            passwordField.sendKeys(user.getPasswordHash());
            passwordConfirmationField.clear();
            passwordConfirmationField.sendKeys(user.getConfPasswordHash());
        } catch (NoSuchElementException e) {
            LOGGER.error("Element not present " , e);
        }
    }

    /**
     * Method to Submit the New user request based on the ENUM passed
     *
     * @param enum
     *            Mode
     */
    public void pressSubmit(Mode currentMode){
        switch (currentMode) {
        case ENTER_KEY:
            submitButton.sendKeys(Keys.ENTER);
            wait.until(ExpectedConditions.urlToBe(RequestPathUrl.ALL_USERS));
            break;
        case SUBMIT_BUTTON:
            wait.until(ExpectedConditions.elementToBeClickable(submitButton));
            submitButton.click();
            break;
        }
    }
}
