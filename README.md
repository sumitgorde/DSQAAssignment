# DSQAAssignment

# Test Automation Assignment (Rest Assured + Selenium-WebDriver + Java)

## Start the tests
Open terminal, browse to root directory of project, run the test suite:

	mvn clean install test -Dtest=TestSuiteClass

## Test Cases/ Scenarios
  - Rest API Tests : Validate GET and DELETE Methods
  	- listOfAllRegisteredUsers
	- deleteAllUsers
  - UserListPageTest.java : All Users page validations
  	- verifyAllUserPageHeader
	- verifyCreateUserButtonDisplay
	- verifyUsersTableSize
	- verifyUsersCreatedListedAtTheLastRow
  - EmailFieldTests.java : Email field validations
	- verifyCreatingNewUserWithoutAtSymbolInEmail
	- verifyCreatingNewUserWithExistingEmail
	- verifyCreatingNewUserWithoutdotcomInEmail
	- verifyCreatingNewUserWithoutPrefixInEmail
  - NameFieldTests.java : Name field validations
  	- verifyCreatingNewUserWithBlankName
  - PasswordFieldTests.java : Password field validations
	- verifyCreatingNewUserWithValidPwdFieldAndBlankCnfPasswordField
	- verifyCreatingNewUserWithBlankPwdFieldAndValidCnfPasswordField
	- verifyCreatingNewUserWithValidPwdFieldAndDifferentCnfPasswordField
	- verifyCreatingNewUserWithPasswordMinLength
  - NewUserGenericTests.java : Test class for generic new user tests
	- verifyCreateUserSubmitUsingEnterKey
	- verifyCreateUserByAllFieldsBlank
	- verifyCreateUserByEnteringValidCredentials
	- verifyPageRefreshAfterFieldsEntry
                                    
## Framework
 - Maven build tool, maintaining all the library definition in pom 
 - Page Object Model design pattern for maintaining the separate class for each feature
 - Page Factory Model for defining and locating web elements
 - Rest Assured and Selenium webdriver libraries to drive API and UI automation.
 - javafaker to generate the fake test data.
 - Log4j logger for defining and logging events
 - Extentreport for reporting

## Libraries:

- JUnit 4.9
- selenium-java Client 3.14.0
- webdrivermanager 3.0.0
- javafaker 0.16
- extentreports 2.41.2
- log4j 1.2.17
- org.json 20180813

## Requirements

- Chrome browser to be installed (chromeDriver =>2.30)
- Maven 3.0 installed
- Selenium webdriver installed

## Java
 -java version "1.8.0_112"
 -Java(TM) SE Runtime Environment (build 1.8.0_112-b16)
 -Java HotSpot(TM) 64-Bit Server VM (build 25.112-b16, mixed mode)
 
## Start the tests

Open terminal, browse to root directory of project, run the test suite:

	mvn clean install test -Dtest=TestSuiteClass


## Test Report screenshot

![capture](https://user-images.githubusercontent.com/45860684/53211486-39119480-3639-11e9-87ab-7c8eab143690.PNG)


## Test Report Location

Please find test report under below path 

/TestReport.html


