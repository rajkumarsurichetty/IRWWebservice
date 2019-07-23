package com.doosan.nao.test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.input.InputReader;
import com.doosan.nao.reports.ReportGenerator;

/**
 * This class is used to Validate Login credentials
 * 
 * @author sjs
 * 
 */
public class LoginTest{

	public static final String LOGIN_TEST = "LoginTest";
	public EventFiringWebDriver wd=null;
	String localStatus;

	String localdataSet;
	@Parameters(value = { "browser", "version", "platform", "osVersion" })
	/**
	 * This method initializes the browser setting before running the test
	 * 
	 * @param browser
	 * @param browserVersion
	 * @param platform
	 * @param osVersion
	 * @throws IOException
	 */
	@BeforeTest
	public void initializeLoginTest(String browser, String browserVersion,
			String platform, String osVersion) throws IOException, URISyntaxException {
		wd=WebdriverSelector.getDriver(wd, browser);
		TestInitializer
				.initialize(browser, browserVersion, platform, osVersion);
	}

	/**
	 * This method executes the testcase for LoginTest
	 * 
	 * @param dataSet
	 * 
	 * @param userName
	 * 
	 * @param password
	 * 
	 * @param verifyUserName
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 */

	@Test(dataProvider = LOGIN_TEST)
	public void loginTest(String dataSet, String userName, String password,
			String verifyUserName) throws IOException, InterruptedException {

		System.out.println(dataSet+":"+userName);
		localdataSet=dataSet;
		
		//ReportGenerator.setLog("LoginTest::: initiated");

		wd.get(TestInitializer.PROJECT
				.getProperty(Constants.DOOSAN_URL));
		System.out.println(TestInitializer.PROJECT.getProperty(Constants.LOGIN_PAGE_USERNAME_TEXT_X_PATH));
		
		TestInitializer.getWebElement(Constants.LOGIN_PAGE_USERNAME_TEXT_X_PATH,wd)
				.sendKeys(userName);
		TestInitializer.getWebElement(Constants.LOGIN_PAGE_PASSWORD_TEXT_X_PATH,wd)
				.sendKeys(password);
		TestInitializer.getWebElement(Constants.LOGIN_PAGE_SUBMIT_BUTTON_X_PATH,wd).click();
		TestInitializer.waitForSometime();
		wd.navigate().to(
				TestInitializer.PROJECT.getProperty(Constants.PARTS_5_URL));
		
		String loginUserName = TestInitializer.getWebElement(
				Constants.LOGIN_PAGE_USERNAME_GET_TEXT_X_PATH,wd).getText();
		if (loginUserName.trim().equals(verifyUserName.trim())) {
			ReportGenerator.setLogAndCreateScreenshot(
					"User name and password is validated successfully",
					LOGIN_TEST, Constants.DEFAULT_TESTNAME, dataSet, Constants.PASSED,wd);
		} else {
			ReportGenerator.setLogAndCreateScreenshot(LOGIN_TEST,
					Constants.DEFAULT_TESTNAME, dataSet, Constants.FAILED,wd);
		}
		localStatus="pass";
	}

	/*
	@AfterMethod
	public void afterTest() throws IOException
	{
		if(localStatus.equals("pass"))
		{
		ReportGenerator.setLog("LoginTest ::: completed");
		ReportGenerator.setLogAndCreateScreenshot(LOGIN_TEST, Constants.DEFAULT_TESTNAME,
				localdataSet, Constants.PASSED);
		} else
		
		{
			ReportGenerator.setLogAndCreateScreenshot(LOGIN_TEST,
					Constants.DEFAULT_TESTNAME, localdataSet, Constants.FAILED,
					"");
			
		
		}
		
		
	}
	*/
	/**
	 * 
	 * This is the default method executed by selenium.
	 * 
	 * @return the input data required to run the test case.
	 * 
	 * @throws Exception
	 */

	@DataProvider(name = LOGIN_TEST)
	public static Object[][] getInputFromXLS() throws Exception {
		
		return InputReader.getInputReader().getDataFromXLS(LOGIN_TEST);
	}

	/**
	 * Tear Down
	 */

	@AfterClass
	public void teardown() {
		TestInitializer.tearDown(wd);
	}

}
