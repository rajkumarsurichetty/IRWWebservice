package com.doosan.nao.test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.input.InputReader;
import com.doosan.nao.reports.ReportGenerator;

/**
 * This method is used to test the drop down available in the portal
 * 
 * @author sjs
 * 
 */
public class DropDownTest {

	public EventFiringWebDriver wd=null;
	private String dataSet;
	private String searchByOrgNameDropDown;
	private String searchyByOrgNameValue;
	private String searchByCustNoDropDown;
	private String searchByCustNoValue;
	private String changeOrgValue;
	private String changeOrgNameDropDownValue;
	private String changeCustNoDropDownValue;

	private static final String DROPDOWN_TEST = "DropDownTest";
	public static final String DROP_DOWN_CHANGE_ORG_LINK_X_PATH = "ChangeOrganization_change_link_X";

	public static final String DROP_DOWN_CHANGE_ORG_DROP_DOWN_X_PATH = "ChangeOrganization_firstdropdown_dropdown_X";
	public static final String DROP_DOWN_CLEAR_ORG_NAME_TEXT_X_PATH = "ChangeOrganization_firstdropdown_text_X";
	public static final String DROP_DOWN_ORG_NAME_LINK_X_PATH = "ChangeOrganization_firstlink_link_X";
	public static final String DROP_DOWN_CUSTOMER_NO_X_PATH = "ChangeOrganization_seconddropdown_text_X";
	public static final String DROP_DOWN_SELECT_ORG_LINK_X_PATH = "ChangeOrganization_firstlink_link_X";
	public static final String DROP_DOWN_CHANGE_ORG_SEARCH_BUTTON_X_PATH = "ChangeOrganization_submit_button_X";
	public static final String DROP_DOWN_CHANGE_CUST_NO_DROP_DOWN_X_PATH = "ChangeOrganization_seconddropdown_dropdown_X";
	public static final String OPTION = "option";

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
	public void initializeDropDownTest(String browser, String browserVersion,
			String platform, String osVersion) throws IOException, URISyntaxException {
		System.out.println("in");
		wd=WebdriverSelector.getDriver(wd, browser);
		TestInitializer
				.initialize(browser, browserVersion, platform, osVersion);
	}

	/**
	 * This method is used to test the drop down
	 * 
	 * @param dataSet
	 * @param searchByOrgNameDropDown
	 * @param searchyByOrgNameValue
	 * @param searchByCustNoDropDown
	 * @param searchByCustNoValue
	 * @param changeOrgValue
	 * @param changeOrgNameDropDownValue
	 * @param changeCustNoDropDownValue
	 */
	@Factory(dataProvider = DROPDOWN_TEST)
	public DropDownTest(String dataSet, String searchByOrgNameDropDown,
			String searchyByOrgNameValue, String searchByCustNoDropDown,
			String searchByCustNoValue, String changeOrgValue,
			String changeOrgNameDropDownValue, String changeCustNoDropDownValue) {

		this.dataSet = dataSet;
		this.searchByOrgNameDropDown = searchByOrgNameDropDown;
		this.searchyByOrgNameValue = searchyByOrgNameValue;
		this.searchByCustNoDropDown = searchByCustNoDropDown;
		this.searchByCustNoValue = searchByCustNoValue;
		this.changeOrgValue = changeOrgValue;
		this.changeOrgNameDropDownValue = changeOrgNameDropDownValue;
		this.changeCustNoDropDownValue = changeCustNoDropDownValue;
	}

	/**
	 * This method is used to test the change organization drop down
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Test(priority = 1)
	public void changeOrganizationTest() throws IOException,
			InterruptedException {

		ReportGenerator
				.setLog("DropDownTest: changeOrganizationTest() initiated");

		try {

			TestInitializer.setOrganization(wd);
			TestInitializer.getWebElement(DROP_DOWN_CHANGE_ORG_LINK_X_PATH,wd)
					.click();
			Select selectOrgDropdown = new Select(
					TestInitializer
							.getWebElement(DROP_DOWN_CHANGE_ORG_DROP_DOWN_X_PATH,wd));
			selectOrgDropdown.selectByVisibleText(searchByOrgNameDropDown);
			List<WebElement> orgDropDownList = selectOrgDropdown.getOptions();
			for (WebElement webElement : orgDropDownList) {
				ReportGenerator.setLog("Option is ::" + webElement.getText());
			}
			TestInitializer.getWebElement(
					Constants.HOME_PAGE_ORG_NAME_TEXT_X_PATH,wd).clear();
			TestInitializer.getWebElement(
					Constants.HOME_PAGE_ORG_NAME_TEXT_X_PATH,wd).sendKeys(
					searchyByOrgNameValue);
			Select sel1 = new Select(
					TestInitializer
							.getWebElement(DROP_DOWN_CHANGE_CUST_NO_DROP_DOWN_X_PATH,wd));
			sel1.selectByVisibleText(searchByCustNoDropDown);
			List<WebElement> custNoDropDown = sel1.getOptions();
			for (WebElement webElement : custNoDropDown) {
				ReportGenerator.setLog("Option is ::" + webElement.getText());
			}
			TestInitializer.getWebElement(DROP_DOWN_CUSTOMER_NO_X_PATH,wd)
					.sendKeys(searchByCustNoValue);
			TestInitializer.getWebElement(
					Constants.HOME_PAGE_ORG_SEARCH_BUTTON_X_PATH,wd).click();
			TestInitializer.getWebElement(DROP_DOWN_SELECT_ORG_LINK_X_PATH,wd)
					.click();
			TestInitializer.getWebElement(DROP_DOWN_CHANGE_ORG_LINK_X_PATH,wd)
					.click();
			ReportGenerator.setLogAndCreateScreenshot(DROPDOWN_TEST,
					Constants.DEFAULT_TESTNAME, dataSet, Constants.PASSED,wd);
		} catch (Exception e) {
			ReportGenerator.setLogAndCreateScreenshot(DROPDOWN_TEST,
					Constants.DEFAULT_TESTNAME, dataSet,
					Constants.FAILED + e.getMessage(),wd);
		}
		try {
			TestInitializer.getWebElement(DROP_DOWN_CLEAR_ORG_NAME_TEXT_X_PATH,wd)
					.sendKeys(changeOrgValue);
			TestInitializer.getWebElement(
					DROP_DOWN_CHANGE_ORG_SEARCH_BUTTON_X_PATH,wd).click();
			TestInitializer.getWebElement(DROP_DOWN_ORG_NAME_LINK_X_PATH,wd)
					.click();
			ReportGenerator.setLogAndCreateScreenshot(DROPDOWN_TEST,
					Constants.DEFAULT_TESTNAME, dataSet, Constants.PASSED,wd);
		} catch (Exception e) {
			ReportGenerator.setLogAndCreateScreenshot(DROPDOWN_TEST,
					Constants.DEFAULT_TESTNAME, dataSet, Constants.FAILED,
					e.getMessage(),wd);
		}
		ReportGenerator
				.setLog("DropDownTest: changeOrganizationTest() completed");
		ReportGenerator.setLogAndCreateScreenshot(DROPDOWN_TEST,
				Constants.DEFAULT_TESTNAME, dataSet, Constants.PASSED,wd);
	}

	/**
	 * This method is used to validate whether the drop down is disabled or not.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */

	@Test(priority = 2)
	public void dropDownDisableCheck() throws IOException, InterruptedException {
		ReportGenerator
				.setLog("DropDownTest: dropDownDisableCheck() initiated");
		TestInitializer.getWebElement(DROP_DOWN_CHANGE_ORG_LINK_X_PATH,wd).click();
		Select sel = new Select(
				TestInitializer
						.getWebElement(DROP_DOWN_CHANGE_ORG_DROP_DOWN_X_PATH,wd));
		sel.selectByVisibleText(changeOrgNameDropDownValue);
		WebElement firstOption = sel.getFirstSelectedOption();
		ReportGenerator.setLog(firstOption.getText());

		WebElement we = TestInitializer
				.getWebElement(DROP_DOWN_CHANGE_CUST_NO_DROP_DOWN_X_PATH,wd);
		List<WebElement> l = we.findElements(By.tagName(OPTION));
		for (int i = 0; i <= l.size() - 1; i++) {
			boolean x = l.get(i).isEnabled();

			if (!x) {
				String x1 = l.get(i).getText();
				if (changeOrgNameDropDownValue.equals(x1)) {

					ReportGenerator
							.setLog("Your selection is deselected in Second Dropdown :"
									+ changeOrgNameDropDownValue
									+ ", the deselected option is : ");
				}
			}
		}
		Select DropDownSelect = new Select(
				TestInitializer
						.getWebElement(DROP_DOWN_CHANGE_CUST_NO_DROP_DOWN_X_PATH,wd));
		DropDownSelect.selectByVisibleText(changeCustNoDropDownValue);
		WebElement we1 = TestInitializer
				.getWebElement(DROP_DOWN_CHANGE_ORG_DROP_DOWN_X_PATH,wd);
		List<WebElement> nextDropDown = we1.findElements(By.tagName(OPTION));
		for (int i = 0; i <= nextDropDown.size() - 1; i++) {
			boolean isEnabled = l.get(i).isEnabled();
			if (!isEnabled) {
				String x1 = l.get(i).getText();
				if (changeCustNoDropDownValue.equals(x1)) {
					ReportGenerator
							.setLog("Your selection is deselected in Second Dropdown :"
									+ changeCustNoDropDownValue
									+ ", the deselected option is : ");
				}
			}
		}
		ReportGenerator
				.setLog("DropDownTest: dropDownDisableCheck() completed");
	}

	/**
	 * 
	 * This is the default method executed by selenium.
	 * 
	 * @return the input data required to run the test case.
	 * 
	 * @throws Exception
	 */

	@DataProvider(name = DROPDOWN_TEST)
	public static Object[][] getInputFromXLS() throws Exception {

		return InputReader.getInputReader().getDataFromXLS(DROPDOWN_TEST);
	}

	/**
	 * Tear down
	 */

	@AfterClass
	public void teardown() {
		TestInitializer.tearDown(wd);
	}
}
