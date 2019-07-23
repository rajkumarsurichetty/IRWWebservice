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
 * This class is used to test whether the pagination in parts portal
 * 
 * @author sjs
 * 
 */
public class PaginationTest {

	public EventFiringWebDriver wd=null;
	public static final String PAGINATION_TEST = "PaginationTest";
	public static final String DROP_DOWN_CHANGE_ORG_LINK_X_PATH = "ChangeOrganization_change_link_X";
	public static final String PAGINATION_FIRSTPAGE_TESTNAME = "FirstPage";
	public static final String PAGINATION_LASTPAGE_TESTNAME = "LastPage";
	public static final String PAGINATION_PAGE_RESULT_X_PATH = "FirstPageLastPage_Result_GetText_X";

	private String totalItemCounts;
	private String totalFirstPageItemCounts;
	private String totalLastPageItemCounts;

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
	public void initializePaginationTest(String browser, String browserVersion,
			String platform, String osVersion) throws IOException, URISyntaxException {
		wd=WebdriverSelector.getDriver(wd, browserVersion);
		TestInitializer
				.initialize(browser, browserVersion, platform, osVersion);
	}

	/**
	 * This method is used to execute the pagination test case
	 * 
	 * @param dataSet
	 * @param firstPage
	 * @param lastPage
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@Test(dataProvider = PAGINATION_TEST)
	public void firstPageLastPageTest(String dataSet, String firstPage,
			String lastPage) throws IOException, InterruptedException {

		TestInitializer.setOrganization(wd);
		TestInitializer.getWebElement(DROP_DOWN_CHANGE_ORG_LINK_X_PATH,wd).click();
		TestInitializer.waitForSometime();
		if (firstPage.equalsIgnoreCase(PAGINATION_FIRSTPAGE_TESTNAME)) {
			TestInitializer.getWebElement(
					"FirstPageLastPage_Firsbutton_Click_X",wd).click();
			ReportGenerator
					.setLog("First page button clicked and page moved to first button");
			totalItemCounts = TestInitializer.getWebElement(
					PAGINATION_PAGE_RESULT_X_PATH,wd).getText();

			String[] pageNo = totalItemCounts.split(" ");
			String firstPageNo = pageNo[2];
			String lastPageNo = pageNo[4];
			if (firstPageNo.equals("1") && lastPageNo.equals("20")) {
				ReportGenerator.setLogAndCreateScreenshot(PAGINATION_TEST
						.concat("_").concat(PAGINATION_FIRSTPAGE_TESTNAME),
						PAGINATION_FIRSTPAGE_TESTNAME, dataSet,
						Constants.PASSED,wd);
			} else {
				ReportGenerator.setLogAndCreateScreenshot(PAGINATION_TEST
						.concat("_").concat(PAGINATION_FIRSTPAGE_TESTNAME),
						PAGINATION_FIRSTPAGE_TESTNAME, dataSet,
						Constants.FAILED,wd);
			}
		}
		if (lastPage.equalsIgnoreCase(PAGINATION_LASTPAGE_TESTNAME)) {

			TestInitializer.getWebElement(
					"FirstPageLastPage_Lastbutton_Click_X",wd).click();
			totalLastPageItemCounts = TestInitializer.getWebElement(
					PAGINATION_PAGE_RESULT_X_PATH,wd).getText();
			if (totalItemCounts.equals(totalLastPageItemCounts)) {
				whileWait();
			}
			totalFirstPageItemCounts = TestInitializer.getWebElement(
					PAGINATION_PAGE_RESULT_X_PATH,wd).getText();
			String[] resultString = totalFirstPageItemCounts.split(" ");
			String tempString = resultString[4];
			String tempString2 = resultString[6];
			ReportGenerator.setLog("Total row count:" + tempString2 + " : "
					+ tempString);
			if (tempString2.equals(tempString)) {
				ReportGenerator
						.setLogAndCreateScreenshot(PAGINATION_TEST.concat("_")
								.concat(PAGINATION_LASTPAGE_TESTNAME),
								PAGINATION_LASTPAGE_TESTNAME, dataSet,
								Constants.PASSED,wd);
			} else {
				ReportGenerator
						.setLogAndCreateScreenshot(PAGINATION_TEST.concat("_")
								.concat(PAGINATION_LASTPAGE_TESTNAME),
								PAGINATION_LASTPAGE_TESTNAME, dataSet,
								Constants.FAILED,wd);
			}
		}

	}

	public void whileWait() throws InterruptedException, IOException {
		while (totalItemCounts.equals(totalLastPageItemCounts)) {
			totalItemCounts = TestInitializer.getWebElement(
					PAGINATION_PAGE_RESULT_X_PATH,wd).getText();
			if (!totalItemCounts.equals(totalLastPageItemCounts)) {
				break;
			}

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

	@DataProvider(name = PAGINATION_TEST)
	public static Object[][] getInputFromXLS() throws Exception {
		return InputReader.getInputReader().getDataFromXLS(PAGINATION_TEST);
	}

	/**
	 * Tear Down
	 */

	@AfterClass
	public void teardown() {
		TestInitializer.tearDown(wd);
	}
}
