package com.doosan.nao.test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;

import org.openqa.selenium.NoSuchWindowException;
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
 * 
 * This class is used to test the export to excel while doing quick order
 * 
 * @author sjs
 * 
 */
public class QuickOrderExportFileTest {

	public EventFiringWebDriver wd=null;
	public static final String QUICK_ORDER_EXPORT_FILE_TEST = "QuickOrderExportFileTest";
	public static final String DROP_DOWN_CHANGE_ORG_LINK_X_PATH = "ChangeOrganization_change_link_X";
	public static final String QUICK_ORDER_EXPORT_FILE_SELECT_ORG_LINK_X_PATH = "QuickOrder4_button_X";
	public static final String QUICK_ORDER_EXPORT_FILE_ITEM_NUMBER_TEXT_X_PATH = "QuickOrder_PartNumber_TextType_X";
	public static final String QUICK_ORDER_EXPORT_FILE_QTY_TEXT_X_PATH = "QuickOrder_Qty_TextType_X";
	public static final String QUICK_ORDER_EXPORT_FILE_EXPORT_TO_EXCEL_BUTTON_X_PATH = "QuickOrder_ExportToExcel_button_X";

	@Parameters(value = { "browser", "version", "platform", "osVersion" })
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
	@BeforeTest
	public void initializeExportToExcel(String browser, String browserVersion,
			String platform, String osVersion) throws IOException, URISyntaxException {
		wd=WebdriverSelector.getDriver(wd, browser);
		TestInitializer
				.initialize(browser, browserVersion, platform, osVersion);
	}

	/**
	 * This method executes the test case
	 * 
	 * @param dataSet
	 * 
	 * @param itemNumber
	 * 
	 * @param quantity
	 * 
	 * @throws IOException
	 */

	@Test(dataProvider = QUICK_ORDER_EXPORT_FILE_TEST)
	public void testExportToExcel(String dataSet, String itemNumber,
			String quantity) throws IOException {

		try {
			ReportGenerator.setLog("Login initiated in Export to excel");
			TestInitializer.setOrganization(wd);
			TestInitializer.getWebElement(DROP_DOWN_CHANGE_ORG_LINK_X_PATH,wd)
					.click();
			ReportGenerator
					.setLog("Login initiated in Export to excel is Validated sucessfull");
			TestInitializer.getWebElement(
					QUICK_ORDER_EXPORT_FILE_SELECT_ORG_LINK_X_PATH,wd).click();
			TestInitializer.getWebElement(
					QUICK_ORDER_EXPORT_FILE_ITEM_NUMBER_TEXT_X_PATH,wd).sendKeys(
					itemNumber);
			TestInitializer.getWebElement(
					QUICK_ORDER_EXPORT_FILE_QTY_TEXT_X_PATH,wd).sendKeys(quantity);
			TestInitializer.getWebElement(
					QUICK_ORDER_EXPORT_FILE_EXPORT_TO_EXCEL_BUTTON_X_PATH,wd)
					.click();
			ReportGenerator.setLog("Checking Save button");
			ReportGenerator.setLogAndCreateScreenshot(
					QUICK_ORDER_EXPORT_FILE_TEST, Constants.DEFAULT_TESTNAME,
					dataSet, Constants.PASSED,wd);
		} catch (NoSuchElementException nse) {
			ReportGenerator.setLogAndCreateScreenshot(
					QUICK_ORDER_EXPORT_FILE_TEST, Constants.DEFAULT_TESTNAME,
					dataSet, Constants.FAILED, nse.getMessage(),wd);
		} catch (NoSuchWindowException nswe) {
			ReportGenerator.setLogAndCreateScreenshot(
					QUICK_ORDER_EXPORT_FILE_TEST, Constants.DEFAULT_TESTNAME,
					dataSet, Constants.FAILED, nswe.getMessage(),wd);
		}
	}

	/**
	 * 
	 * This is the default method executed by selenium.
	 * 
	 * @return the input data required to run the test case.
	 * 
	 * @throws Exception
	 */

	@DataProvider(name = QUICK_ORDER_EXPORT_FILE_TEST)
	public static Object[][] getInputFromXLS() throws Exception {
		return InputReader.getInputReader().getDataFromXLS(
				QUICK_ORDER_EXPORT_FILE_TEST);
	}

	/**
	 * Tear down
	 */
	@AfterClass
	public void teardown() {
		TestInitializer.tearDown(wd);
	}
}