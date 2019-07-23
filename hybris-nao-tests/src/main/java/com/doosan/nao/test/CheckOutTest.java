package com.doosan.nao.test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

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
 * This class is used to test the Normal check out flow.
 * 
 * @author sjs
 * 
 * @version 1.0
 */
public class CheckOutTest {

	public EventFiringWebDriver wd=null;
	private static final String CHECKOUT_TEST = "CheckOutTest";
	private static final String QUICK_ORDER_LINK_CLICK_X_PATH = "QuickOrder4_button_X";
	private static final String QUICK_ORDER_PART_NUMBER_TEXT_X_PATH = "QuickOrder_PartNumber_TextType_X";
	private static final String QUICK_ORDER_QUANTITY_TEXT_X_PATH = "QuickOrder_Qty_TextType_X";
	private static final String QUICK_ORDER_ADD_TO_CART_X_PATH = "QuickOrder7_button_X";
	private static final String QUICK_ORDER_CLASS_DROP_DOWN_X_PATH = "QuickOrder8_OrderClass_TextType_X";
	private static final String QUICK_ORDER_CHECKOUT_BUTTON_X_PATH = "QuickOrder9_button_X";
	private static final String QUICK_ORDER_CLEAR_PURCHASE_ORDER_TEXT_X_PATH = "QuickOrder10_clear_X";
	private static final String QUICK_ORDER_CLEAR_SHIP_COMPLETE_TEXT_X_PATH = "QuickOrder_shipcomplete_textType_X";
	private static final String QUICK_ORDER_CLEAR_MODE_TEXT_X_PATH = "QuickOrder_Mode_TextType_X";
	private static final String QUICK_ORDER_CLEAR_CARRIER_TEXT_X_PATH = "QuickOrder_Carrier_TextType_X";
	private static final String QUICK_ORDER_CLEAR_PRIORITY_TEXT_X_PATH = "QuickOrder_Priority_TexType_X";
	private static final String QUICK_ORDER_CLEAR_SHIP_ADDRESS_TEXT_X_PATH = "QuickOrder_ShipAddres_TextType_X";
	private static final String QUICK_ORDER__CONTINUE_BUTTON_X_PATH = "QuickOrder_button_X";
	private static final String QUICK_ORDER_PURCHASE_ORDER_NO_GET_TEXT_X_PATH = "QuickOrder_SamePoNo_getText_X";
	private static final String QUICK_ORDER_ACCEPT_TERMS_CONDITIONS_CHECKBOX_X_PATH = "QuickOrder_AcceptCondtion_checkbox_X";
	private static final String QUICK_ORDER_SUBMIT_ORDER_BUTTON_X_PATH = "QuickOrder_submitOrder_button_X";

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
	public void initializeCheckOutTest(String browser, String browserVersion,
			String platform, String osVersion) throws IOException, URISyntaxException {
		wd=WebdriverSelector.getDriver(wd, browser);
		TestInitializer
				.initialize(browser, browserVersion, platform, osVersion);
	}

	/**
	 * This method is used to execute the test case for check out flow.
	 * 
	 * @param dataSet
	 * @param partNumber
	 * @param qty
	 * @param orderClass
	 * @param purchaseOrderNo
	 * @param shipComplete
	 * @param mode
	 * @param carrier
	 * @param priority
	 * @param shippingAddress
	 * @throws IOException
	 */

	@Test(dataProvider = CHECKOUT_TEST)
	public void validateCheckOutTest(String dataSet, String partNumber,
			String qty, String orderClass, String purchaseOrderNo,
			String shipComplete, String mode, String carrier, String priority,
			String shippingAddress) throws IOException {
		ReportGenerator.setLog("Check out Test::: initiated");
		{
			try {
				ReportGenerator.setLog("Logging initiated");
				TestInitializer.setOrganization(wd);
				TestInitializer.getWebElement(QUICK_ORDER_LINK_CLICK_X_PATH,wd)
						.click();
				TestInitializer.getWebElement(
						QUICK_ORDER_PART_NUMBER_TEXT_X_PATH,wd).sendKeys(
						partNumber);
				TestInitializer.getWebElement(QUICK_ORDER_QUANTITY_TEXT_X_PATH,wd)
						.sendKeys(qty);
				TestInitializer.getWebElement(QUICK_ORDER_ADD_TO_CART_X_PATH,wd)
						.click();
				TestInitializer.dropdown(QUICK_ORDER_CLASS_DROP_DOWN_X_PATH,
						orderClass,wd);
				TestInitializer.getWebElement(
						QUICK_ORDER_CHECKOUT_BUTTON_X_PATH,wd).click();
				TestInitializer.getWebElement(
						QUICK_ORDER_CLEAR_PURCHASE_ORDER_TEXT_X_PATH,wd).clear();
				TestInitializer.getWebElement(
						QUICK_ORDER_CLEAR_PURCHASE_ORDER_TEXT_X_PATH,wd).sendKeys(
						purchaseOrderNo);
				TestInitializer.dropdown(
						QUICK_ORDER_CLEAR_SHIP_COMPLETE_TEXT_X_PATH,
						shipComplete,wd);
				TestInitializer.dropdown(QUICK_ORDER_CLEAR_MODE_TEXT_X_PATH,
						mode,wd);
				TestInitializer.dropdown(QUICK_ORDER_CLEAR_CARRIER_TEXT_X_PATH,
						carrier,wd);
				TestInitializer.dropdown(
						QUICK_ORDER_CLEAR_PRIORITY_TEXT_X_PATH, priority,wd);
				TestInitializer.getWebElement(
						QUICK_ORDER_CLEAR_SHIP_ADDRESS_TEXT_X_PATH,wd).sendKeys(
						shippingAddress);
				TestInitializer.getWebElement(
						QUICK_ORDER__CONTINUE_BUTTON_X_PATH,wd).click();
				int randomNum = 0;
				try {
					Random random = new Random();
					randomNum = random.nextInt(10);

					if (TestInitializer.getWebElement(
							QUICK_ORDER_PURCHASE_ORDER_NO_GET_TEXT_X_PATH,wd)
							.isDisplayed()) {
						TestInitializer.getWebElement(
								QUICK_ORDER_CLEAR_PURCHASE_ORDER_TEXT_X_PATH,wd)
								.clear();
						TestInitializer.getWebElement(
								QUICK_ORDER_CLEAR_PURCHASE_ORDER_TEXT_X_PATH,wd)
								.sendKeys(purchaseOrderNo + randomNum);
						TestInitializer.getWebElement(
								QUICK_ORDER__CONTINUE_BUTTON_X_PATH,wd).click();
					}
				} catch (Exception e) {
					ReportGenerator.setLogAndCreateScreenshot(CHECKOUT_TEST,
							Constants.DEFAULT_TESTNAME, dataSet,
							Constants.FAILED, e.getMessage(),wd);
				}
				TestInitializer.getWebElement(
						QUICK_ORDER_ACCEPT_TERMS_CONDITIONS_CHECKBOX_X_PATH,wd)
						.click();
				TestInitializer.getWebElement(
						QUICK_ORDER_SUBMIT_ORDER_BUTTON_X_PATH,wd).click();
			} catch (IOException e) {

				ReportGenerator.setLogAndCreateScreenshot(CHECKOUT_TEST,
						Constants.DEFAULT_TESTNAME, dataSet, Constants.FAILED,
						e.getMessage(),wd);
			}
		}
		ReportGenerator.setLog("Check out Test completed:::");
		ReportGenerator.setLogAndCreateScreenshot(CHECKOUT_TEST,
				Constants.DEFAULT_TESTNAME, dataSet, Constants.PASSED,wd);
	}

	/**
	 * 
	 * This is the default method executed by selenium.
	 * 
	 * @return the input data required to run the test case.
	 * 
	 * @throws Exception
	 */

	@DataProvider(name = CHECKOUT_TEST)
	public static Object[][] getInputFromXLS() throws Exception {
		return InputReader.getInputReader().getDataFromXLS(CHECKOUT_TEST);
	}

	/**
	 * Tear down
	 */

	@AfterClass
	public void teardown() {
		TestInitializer.tearDown(wd);
	}
}
