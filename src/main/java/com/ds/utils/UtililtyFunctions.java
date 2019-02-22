package com.ds.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class defines all the utility Functions
 */
public class UtililtyFunctions {

    /**
     * This method will get the placeholder attribute value of an element
     *
     * @param WebElement
     * @return String
     */
    public static String getPlaceholderAttributeValue(WebElement ele) {
        return ele.getAttribute("placeholder");
    }

    /**
     * Capture screenshot and save in screenshots folder
     *
     * @return screenshot file path
     */
    public static String capture(WebDriver driver) throws IOException {
        //source file location
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //Destination file location
        File Dest = new File(RequestPathUrl.TEST_SCREENSHOTS + System.currentTimeMillis() + ".png");
        String errflpath = Dest.getAbsolutePath();

        //Move file from source to destination
        FileUtils.copyFile(scrFile, Dest);
        return errflpath;
    }

    /**
     * Get the name of currently executed function
     *
     * @return String
     */
    public static String getCurrentMethodName() {
        return Thread.currentThread().getStackTrace()[2].getClassName()
                + "."
                + Thread.currentThread().getStackTrace()[2].getMethodName();
    }


}
