package com.ds.pageobject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is the Base class for all the Page Objects
 */
public class BasePageObject {

    protected WebDriver driver;

    protected WebDriverWait wait;

    private static final int TIMEOUT_IN_SECONDS = 10;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS);
    }


    /**
     * This method will check if an element exists on the page
     *
     * @param WebElement
     * @return boolean
     */
    public static boolean isElementDisplayed(WebElement ele) {
        try {
            return ele.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
