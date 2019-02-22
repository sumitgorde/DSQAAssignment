package com.ds.tests;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.BeforeClass;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.ds.restservice.APIMethods;
import com.ds.utils.RequestPathUrl;
import com.ds.utils.UtililtyFunctions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * A base for all of the Web tests within this package Responsible for setting
 * up the Selenium WebDriver
 */
public class TestConfig extends TestWatcher {

	private static final Logger LOGGER = Logger.getLogger(TestConfig.class);
	/**
	 * Create a web driver.
	 */
	protected static WebDriver driver;

	/**
	 * Create test variable of ExtentTest type for extent reports
	 */
	protected static ExtentTest test;

	/**
	 * Create report variable of ExtentReports type for extent reports
	 */
	protected static ExtentReports report = new ExtentReports(
			RequestPathUrl.PATH_ROOT.concat(RequestPathUrl.TEST_REPORT_FILE));

	private static final String BROWSER_CHROME = "CHROME";

	private static final String BROWSER_FIREFOX = "FIREFOX";

	private static final String BROWSER_SAFARI = "SAFARI";

	@BeforeClass
	public static void setupClass() throws InterruptedException, IOException {
		// Check the state of driver
		if (driver == null) {

			/**
			 * Configure log4j.xml for logging
			 */
			DOMConfigurator.configure("log4j.xml");

			/**
			 * Set log4j config file in the system properties
			 */
			System.setProperty("log4j2.configurationFile", RequestPathUrl.PATH_ROOT.concat("/log4j2.properties"));

			instantiateDriver();

			/**
			 * Delete all the users before staring the test
			 */
			APIMethods.deleteUsers();

			/**
			 * Open the test URL
			 */
			driver.get(RequestPathUrl.NEW_USER);
		}
	}

	private static void instantiateDriver() throws IOException {

		try {
			Properties prop = getBrowserFromPropertyFile();
			String selectedDriver = prop.get("SelectedDriver").toString();

			switch (selectedDriver) {
			case BROWSER_CHROME:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case BROWSER_FIREFOX:
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case BROWSER_SAFARI:
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
				break;
			default:
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
			driver.manage().window().maximize();
		} catch (IOException e) {
			LOGGER.info("Property file not found. Setting default browser to Chrome");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}

	private static Properties getBrowserFromPropertyFile() throws IOException {
		Properties prop = new Properties();
		InputStream input = TestConfig.class.getClassLoader().getResourceAsStream("config.properties");

		prop.load(input);
		return prop;
	}

	public static void main(String args[]) throws IOException {
		instantiateDriver();
	}

	@Override
	protected void failed(Throwable e, Description d) {
		try {
			test.log(LogStatus.FAIL,
					test.addScreenCapture(UtililtyFunctions.capture(driver)) + d.getClassName() +"."+ d.getMethodName());
		} catch (IOException e1) {
			LOGGER.error("Error in saving results to the ExtentReport");
		}
	}

	@Override
	protected void succeeded(Description d) {

		test.log(LogStatus.PASS, d.getClassName()+"." + d.getMethodName());

	}
}
