package com.doosan.nao.filesHandlingTest;

import java.awt.AWTException;
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
 * This class is used to test the batch Order Upload test
 * 
 * @author sjs
 * 
 */
public class BatchOrderUploadTest extends TestInitializer {

	private static final String BATCH_ORDER_UPLOAD_TEST = "BatchOrderUploadTest";
	private static final String BATCH_ORDER_UPLOAD_FILE_INPUT = "BatchOrderUpload_File_input_I";
	private static final String VALID_FILE_PATH = "validfilepath";
	private static final String INVALID_FILE_PATH = "invalidfilepath";
	private static final String INVALID_LINE_ITEMS_FILE_PATH = "invalidlineitemsfilepath";
	private static final String VALIDFILE_TESTCASE_NAME = "validFile";
	private static final String INVALIDFILE_TESTCASE_NAME = "invalidFile";
	private static final String INVALID_LINEITEMS_TESTCASE_NAME = "invalidLineItems";
	private static final String INVALID = "InValid";
	private static final String VALID = "Valid";
	private static final String BATCH_ORDER_UPLOAD_LINK_CLICK_X_PATH = "BatchOrderUpload_Link_click_X";
	private static final String BATCH_ORDER_UPLOAD_UPLOAD_BUTTON_CLICK_X_PATH = "BatchOrderUpload_UploadButton_click_X";
	private static final String BATCH_ORDER_UPLOAD_FILE_EXCEEDS_600_LINEITEMS_X_PATH = "BatchOrderUpload_A600File_GetText_X";
	private static final String BATCH_ORDER_UPLOAD_GET_TEXT_INVALID = "BatchOrderUpload_InvalidFile_GetText_X";
	private static final String BATCH_ORDER_UPLOAD_GET_TEXT_VALID = "BatchOrderUpload_ValidFile_GetText_X";

	public EventFiringWebDriver wd=null;
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
	public void initializebathcOrderUploadTest(String browser,
			String browserVersion, String platform, String osVersion)
			throws IOException, URISyntaxException {
		wd=WebdriverSelector.getDriver(wd, browser);
		TestInitializer
				.initialize(browser, browserVersion, platform, osVersion);
	}

	/**
	 * 
	 * This method executes the batch order upload test
	 * 
	 * @param dataSet
	 * @param lineItems
	 * @param invalidFile
	 * @param validfile
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	@Test(dataProvider = BATCH_ORDER_UPLOAD_TEST)
	public void bathcOrderUploadTest(String dataSet, String lineItems,
			String invalidFile, String validfile) throws IOException,
			InterruptedException, AWTException {
		ReportGenerator.setLog("Batch Order Upload Test initiated:::");
		int lineItem = Integer.parseInt(lineItems);
		try {

			TestInitializer.setOrganization(wd);
			// To test if the Line items in Excel exceeds 600 lines
			if (lineItem > 600) {
				testInputFile(
						System.getProperty(Constants.USER_DIRECTORY)
								+ TestInitializer.PROJECT
										.getProperty(INVALID_LINE_ITEMS_FILE_PATH),
						dataSet,
						BATCH_ORDER_UPLOAD_FILE_EXCEEDS_600_LINEITEMS_X_PATH,
						INVALID_LINEITEMS_TESTCASE_NAME);
			}
			// If the Excel file uploaded by user is in invalid format
			if (invalidFile.equalsIgnoreCase(INVALID)) {
				testInputFile(
						System.getProperty(Constants.USER_DIRECTORY)
								+ TestInitializer.PROJECT
										.getProperty(INVALID_FILE_PATH),
						dataSet, BATCH_ORDER_UPLOAD_GET_TEXT_INVALID,
						INVALIDFILE_TESTCASE_NAME);
			}
			// To Test Valid Excel File
			if (validfile.equals(VALID)) {
				testInputFile(System.getProperty(Constants.USER_DIRECTORY)
						+ TestInitializer.PROJECT.getProperty(VALID_FILE_PATH),
						dataSet, BATCH_ORDER_UPLOAD_GET_TEXT_VALID,
						VALIDFILE_TESTCASE_NAME);
			}

		} catch (NoSuchElementException nse) {
			ReportGenerator.setLogAndCreateScreenshot(BATCH_ORDER_UPLOAD_TEST,
					Constants.DEFAULT_TESTNAME, dataSet, Constants.FAILED,
					nse.getMessage(),wd);

		} catch (NoSuchWindowException nswe) {

			ReportGenerator.setLogAndCreateScreenshot(BATCH_ORDER_UPLOAD_TEST,
					Constants.DEFAULT_TESTNAME, dataSet, Constants.FAILED,
					nswe.getMessage(),wd);
		}
		ReportGenerator.setLog("Batch Order Upload Test::: completed");
		ReportGenerator.setLogAndCreateScreenshot(BATCH_ORDER_UPLOAD_TEST,
				Constants.DEFAULT_TESTNAME, dataSet, Constants.PASSED,wd);
	}

	/**
	 * This method validates all the test case for the batch order upload test.
	 * 
	 * @param fileName
	 * @param dataSet
	 * @param xpath
	 * @param testCaseName
	 * 
	 * @throws IOException
	 */
	public void testInputFile(String fileName, String dataSet, String xpath,
			String testCaseName) throws IOException {
		try {
			TestInitializer.getWebElement(BATCH_ORDER_UPLOAD_LINK_CLICK_X_PATH,wd)
					.click();
			TestInitializer.getWebElement(BATCH_ORDER_UPLOAD_FILE_INPUT,wd)
					.sendKeys(fileName);
			TestInitializer.getWebElement(
					BATCH_ORDER_UPLOAD_UPLOAD_BUTTON_CLICK_X_PATH,wd).click();
			if (TestInitializer.getWebElement(xpath,wd).isDisplayed()) {
				ReportGenerator.setLogAndCreateScreenshot(
						BATCH_ORDER_UPLOAD_TEST, testCaseName, dataSet,
						Constants.PASSED,wd);

			}
		} catch (NoSuchElementException nse) {
			ReportGenerator.setLogAndCreateScreenshot(BATCH_ORDER_UPLOAD_TEST,
					testCaseName, dataSet, Constants.FAILED, nse.getMessage(),wd);
		} catch (NoSuchWindowException nswe) {
			ReportGenerator.setLogAndCreateScreenshot(BATCH_ORDER_UPLOAD_TEST,
					testCaseName, dataSet, Constants.FAILED, nswe.getMessage(),wd);
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

	@DataProvider(name = BATCH_ORDER_UPLOAD_TEST)
	public Object[][] getInputFromXLS() throws Exception {
		return InputReader.getInputReader().getDataFromXLS(
				BATCH_ORDER_UPLOAD_TEST);
	}

	/**
	 * Tear down
	 */
	@AfterClass
	public void teardown() {
		TestInitializer.tearDown(wd);
	}
}
