# DSQAAssignment

# Test Automation Assignment (Rest Assured + Selenium-WebDriver + Java)

## Start the tests
Open terminal, browse to root directory of project, run the test suite:

mvn clean install test -Dtest=TestSuiteClass

## Test Cases
  - Rest API Tests : Validate GET and DELETE Methods
  - UserListPageTest.java : All Users page tests 
  - EmailFieldTests.java : Test class for email field
  - NameFieldTests.java : Test class for name field
  - PasswordFieldTests.java : Test class for password field
  - NewUserGenericTests.java : Test class for generic new user tests
                                    

## Libraries:

- JUnit 4.9
- selenium-java Client 3.14.0
- webdrivermanager 3.0.0
- extentreports 2.41.2
- log4j 1.2.17
- org.json 20180813



## Requirements

- Chrome browser to be installed (chromeDriver =>2.30)
- Maven 3.0 installed
- Selenium webdriver installed

## Framework
 - Maven build tool, maintaining all the library definition in pom 
 - Page Object Model design pattern for maintaining the separate class for each feature
 - Page Factory Model for defining and locating web elements
 - Logforj logger for defining and logging events
 - Extentreport for effective reporting


## Java
 -java version "1.8.0_112"
 -Java(TM) SE Runtime Environment (build 1.8.0_112-b16)
 -Java HotSpot(TM) 64-Bit Server VM (build 25.112-b16, mixed mode)
 
## Start the tests

Open terminal, browse to root directory of project, run the test suite:

	mvn clean install test -Dtest=TestSuiteClass



## Test Report screenshot

<img width="1237" alt="screen shot 2018-10-14 at 8 51 24 pm" src="https://user-images.githubusercontent.com/14192186/46919748-5dad8e00-d001-11e8-959a-5c68a0b17a93.png">


## Test Report Location

Please find test report under below path 

/TestReport.html

