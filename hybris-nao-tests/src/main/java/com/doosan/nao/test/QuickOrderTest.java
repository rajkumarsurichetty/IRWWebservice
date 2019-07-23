package com.doosan.nao.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
 * This class is used to test the quick order
 * 
 * @author sjs
 * 
 */
public class QuickOrderTest {

	public EventFiringWebDriver wd=null;
	public static final String QUICK_ORDER_TEST = "QuickOrderTest";
	public static final String DROP_DOWN_CHANGE_ORG_LINK_X_PATH = "ChangeOrganization_change_link_X";
	public static final String QUICK_ORDER_SELECT_ORGANIZATION_LINK_X_PATH = "QuickOrder4_button_X";
	public static final String QUICK_ORDER_ADD_TO_CART_BUTTON_X_PATH = "QuickOrderItemTableValidation_addtocart_button_X";
	public static final String QUICK_ORDER_PLEASE_SELECT_ERRRO_MESSAGE_X_PATH = "QuickOrderItemTablevalidation_PleaseSelect_GetText_X";
	public static final String QUICK_ORDER_ADD_LINE_BUTTON_X_PATH = "QuickOrderItemTableValidation_emptyaddline_button_X";
	public static final String QUICK_ORDER_ITEM_NUMBER_TEXT_X_PATH = "QuickOrder_PartNumber_TextType_X";
	public static final String QUICK_ORDER_QTY_TEXT_X_PATH = "QuickOrder_Qty_TextType_X";
	public static final String QUICK_ORDER_ITEM_NUMBER_TEXT_START = ".//*[@id='quickOrderTable']/tbody/tr[";
	public static final String QUICK_ORDER_ITEM_NUMBER_TEXT_END = "]/td[3]/input";
	public static final String QUICK_ORDER_QTY_TEXT_START = "html/body/div[2]/div[4]/form/div/div/div[1]/table/tbody/tr[";
	public static final String QUICK_ORDER_QTY_TEXT_END = "]/td[4]/input";
	public static final String QUICK_ORDER_BIN_LOCATION_TEXT_START = ".//*[@id='quickOrderTable']/tbody/tr[";
	public static final String QUICK_ORDER_BIN_LOCATION_TEXT_END = "]/td[5]/input";
	public static final String QUICK_ORDER_COMMENTS_TEXT_START = ".//*[@id='quickOrderTable']/tbody/tr[";
	public static final String QUICK_ORDER_COMMENTS_TEXT_END = "]/td[6]/input";
	public static final String QUICK_ORDER_ERRRO_MESSAGE_START = "html/body/div[2]/div[4]/form/div[1]/div[2]/p[";
	public static final String QUICK_ORDER_ERRRO_MESSAGE_END = "]";
	public static final String QUICK_ORDER_TABLE_X_PATH = "QuickOrderItemTableValidation_fulltable_table_X";
	public static final String QUICK_ORDER_LINE_NO_TEXT_START = "html/body/div[2]/div[4]/form/div[2]/div/div[1]/table/tbody/tr[";
	public static final String QUICK_ORDER_LINE_NO_TEXT_END = "]/td[2]";
	public static final String QUICK_ORDER_ITEM_NUMBER_START = "html/body/div[2]/div[4]/form/div[2]/div/div[1]/table/tbody/tr[";
	public static final String QUICK_ORDER_ITEM_NUMBER_END = "]/td[3]";
	public static final String QUICK_ORDER_ITEM_NUMBER_ERROR_TEXT_START = "html/body/div[2]/div[4]/form/div[2]/div/div[1]/table/tbody/tr[";
	public static final String QUICK_ORDER_ITEM_NUMBER_ERROR_TEXT_END = "]/td[3]/span[2]/p/span";
	public static final String QUICK_ORDER_ITEM_NUMBER_ERROR_LINK_START = "html/body/div[2]/div[4]/form/div[2]/div/div[1]/table/tbody/tr[";
	public static final String QUICK_ORDER_ITEM_NUMBER_ERROR_LINK_END = "]/td[3]/span[2]/div/a";
	public static final String QUICK_ORDER_QUANTITY_ERROR_LINK_START = "html/body/div[2]/div[4]/form/div[2]/div/div[1]/table/tbody/tr[";
	public static final String QUICK_ORDER_QUANTITY_ERROR_LINK_END = "]/td[4]/span[2]/p/span";
	public static final String QUICK_ORDER_BIN_ERROR_LINK_START = "html/body/div[2]/div[4]/form/div[2]/div/div[1]/table/tbody/tr[";
	public static final String QUICK_ORDER_BIN_ERROR_LINK_END = "]/td[3]/span[2]/p/span";
	public static final String QUICK_ORDER_COMMENTS_ERROR_LINK_START = "html/body/div[2]/div[4]/form/div[2]/div/div[1]/table/tbody/tr[";
	public static final String QUICK_ORDER_COMMENTS_ERROR_LINK_END = "]/td[6]/span[2]/p/span";
	public static final String QUICK_ORDER_ERROR_TEXT_X_PATH = "QuickOrderItemTableValidation_error_GetText_X";
	public static final String QUICK_ORDER_ERROR_PAGE_MESSAGE_TEXT_X_PATH = "QuickOrderItemTableValidation_errortotaltext_GetText_X";
	public static final String QUICK_ORDER_ADDTOCART_BUTTON_X_PATH = "QuickOrderItemTableValidation_addtocart_button_X";
	public static final String QUICK_ORDER_REMOVE_BUTTON_X_PATH = "QuickOrderItemTableValidation_remove_button_X";
	public static final String QUICK_ORDER_ERROR_MESSAGE_TEXT_X_PATH = "QuickOrderItemTableValidation_error_GetText_X";
	public static final String QUICK_ORDER_TEST_EMPTY_ADD_TO_CART_CHECK_TESTNAME = "EmptyAddToCartCheck";
	public static final String QUICK_ORDER_TEST_ENTERING_VALUES_INTABLE_TESTNAME = "ValuesIntables";
	public static final String QUICK_ORDER_TEST_VERIFY_PLEASE_ENTERTEXT_TESTNAME = "PleaseEnterTextVerified";
	public static final String QUICK_ORDER_TEST_ERROR_MESSAGE_TESTNAME = "ErrorMessage";
	private File file;
	private FileInputStream fis;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	public Cell cell;
	private int lineCount = 0;
	private int totalAddLine = 0;
	private int addLineCount = 0;
	private int rowCount;
	private int colCount;

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
	public void initializeQuickOrderLineItemTest(String browser,
			String browserVersion, String platform, String osVersion)
			throws IOException, URISyntaxException {
		wd=WebdriverSelector.getDriver(wd, browser);
		TestInitializer
				.initialize(browser, browserVersion, platform, osVersion);
	}

	@Test(dataProvider = QUICK_ORDER_TEST)
	public void quickOrderLineItemTest(String dataSet, String verify,
			String testing) throws IOException, InterruptedException {

		ReportGenerator.setLog("QuickOrder item table excel initialized");
		collectExcelData();
		ReportGenerator.setLog("QuickOrder item table excel completed");
		ReportGenerator
				.setLog("QuickOrder item table test case Login initated");
		TestInitializer.setOrganization(wd);
		TestInitializer.getWebElement(DROP_DOWN_CHANGE_ORG_LINK_X_PATH,wd).click();
		ReportGenerator
				.setLog("QuickOrder item table test case Login completed");
		TestInitializer.getWebElement(
				QUICK_ORDER_SELECT_ORGANIZATION_LINK_X_PATH,wd).click();
		TestInitializer.getWebElement(QUICK_ORDER_ADD_TO_CART_BUTTON_X_PATH,wd)
				.click();
		ReportGenerator
				.setLog("Validation for Add to cart for empty cell is initialized");
		validateAddToCartForEmptyCell(
				QUICK_ORDER_PLEASE_SELECT_ERRRO_MESSAGE_X_PATH,
				QUICK_ORDER_TEST_EMPTY_ADD_TO_CART_CHECK_TESTNAME, dataSet);
		ReportGenerator
				.setLog("Validation for Add to cart for empty cell is completed");
		setQuickOrderTableRows();
		ReportGenerator
				.setLog("Addline button click count check is initialized");
		// decides how many rows to be added
		decideNumberOfAddingRows();
		ReportGenerator.setLog("Addline button click count check is completed");
		addLine(dataSet);
		ReportGenerator
				.setLog("Entering the values in the table from excel is initiated");
		// importing excel values to quick order
		setDataFromExcelToQuickOrderTable(dataSet);
		ReportGenerator.setLog("Remove button check initiated");
		validateRemoveButton();
		ReportGenerator.setLog("Remove button check completed");
		// returns the error messages for invalid items
		collectErrorMessage(dataSet);
		ReportGenerator.setLogAndCreateScreenshot(QUICK_ORDER_TEST,
				Constants.DEFAULT_TESTNAME, dataSet, Constants.PASSED,wd);
	}

	/**
	 * 
	 * @param lineNumber
	 * @param columName
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void LineColumnCheck(String lineNumber, String columName)
			throws IOException, InterruptedException {
		WebElement quickOrderTabel = TestInitializer
				.getWebElement(QUICK_ORDER_TABLE_X_PATH,wd);
		List<WebElement> quickOrderTableRowvalues = quickOrderTabel
				.findElements(By.tagName("tr"));
		for (int rowNum = 1; rowNum < quickOrderTableRowvalues.size(); rowNum++) {
			TestInitializer.highlightMyElement(
					wd.findElement(By
							.xpath(QUICK_ORDER_LINE_NO_TEXT_START + rowNum
									+ QUICK_ORDER_LINE_NO_TEXT_END)), 7,wd);
			String loopLineNo = wd
					.findElement(
							By.xpath(QUICK_ORDER_LINE_NO_TEXT_START + rowNum
									+ QUICK_ORDER_LINE_NO_TEXT_END)).getText();
			if (lineNumber.equals(loopLineNo)) {
				if (columName.equals("item") || columName.equals("ite")) {
					if (wd
							.findElement(
									By.xpath(QUICK_ORDER_ITEM_NUMBER_START
											+ rowNum
											+ QUICK_ORDER_ITEM_NUMBER_END))
							.findElements(By.tagName("a")).isEmpty()) {
						TestInitializer
								.highlightMyElement(
										wd
												.findElement(By
														.xpath(QUICK_ORDER_ITEM_NUMBER_ERROR_TEXT_START
																+ rowNum
																+ QUICK_ORDER_ITEM_NUMBER_ERROR_TEXT_END)),
										7,wd);
						ReportGenerator
								.setLog(wd
										.findElement(
												By.xpath(QUICK_ORDER_ITEM_NUMBER_ERROR_TEXT_START
														+ rowNum
														+ QUICK_ORDER_ITEM_NUMBER_ERROR_TEXT_END))
										.getText());
					} else {

						TestInitializer
								.highlightMyElement(
										wd
												.findElement(By
														.xpath(QUICK_ORDER_ITEM_NUMBER_ERROR_LINK_START
																+ rowNum
																+ QUICK_ORDER_ITEM_NUMBER_ERROR_LINK_END)),
										7,wd);
						ReportGenerator
								.setLog(wd
										.findElement(
												By.xpath(QUICK_ORDER_ITEM_NUMBER_ERROR_LINK_START
														+ rowNum
														+ QUICK_ORDER_ITEM_NUMBER_ERROR_LINK_END))
										.getText());
						wd
								.findElement(
										By.xpath(QUICK_ORDER_ITEM_NUMBER_ERROR_LINK_START
												+ rowNum
												+ QUICK_ORDER_ITEM_NUMBER_ERROR_LINK_END))
								.click();
						Thread.sleep(2000L);
						Actions action = new Actions(wd);
						action.sendKeys(Keys.ESCAPE).build().perform();
					}
					break;
				}

				else if (columName.equals("Quantity")
						|| columName.equals("Quantit")) {
					TestInitializer
							.highlightMyElement(wd
											.findElement(By
													.xpath(QUICK_ORDER_QUANTITY_ERROR_LINK_START
															+ rowNum
															+ QUICK_ORDER_QUANTITY_ERROR_LINK_END)),
									7,wd);
					ReportGenerator
							.setLog(wd
									.findElement(
											By.xpath(QUICK_ORDER_QUANTITY_ERROR_LINK_START
													+ rowNum
													+ QUICK_ORDER_QUANTITY_ERROR_LINK_END))
									.getText());

					break;
				} else if (columName.equals("Bin") || columName.equals("Bi")) {
					TestInitializer.highlightMyElement(
							wd.findElement(By
									.xpath(QUICK_ORDER_BIN_ERROR_LINK_START
											+ rowNum
											+ QUICK_ORDER_BIN_ERROR_LINK_END)),
							7,wd);
					ReportGenerator.setLog(wd
							.findElement(
									By.xpath(QUICK_ORDER_BIN_ERROR_LINK_START
											+ rowNum
											+ QUICK_ORDER_BIN_ERROR_LINK_END))
							.getText());
					break;
				} else if (columName.equals("canno")
						|| columName.equals("cann")) {
					TestInitializer
							.highlightMyElement(
									wd
											.findElement(By
													.xpath(QUICK_ORDER_COMMENTS_ERROR_LINK_START
															+ rowNum
															+ QUICK_ORDER_COMMENTS_ERROR_LINK_END)),
									7,wd);
					ReportGenerator
							.setLog(wd
									.findElement(
											By.xpath(QUICK_ORDER_COMMENTS_ERROR_LINK_START
													+ rowNum
													+ QUICK_ORDER_COMMENTS_ERROR_LINK_END))
									.getText());
					break;
				}

			}
		}

	}

	/**
	 * this method set the values to the quick order rows
	 * 
	 * @param rowNum
	 * @param xpathStarting
	 * @param xpathEnd
	 * @param setValue
	 * @throws IOException
	 */
	public  void setValuesInTable(int rowNum, String xpathStarting,
			String xpathEnd, String setValue) throws IOException {
		TestInitializer.highlightMyElement(wd
				.findElement(By.xpath(xpathStarting + rowNum + xpathEnd)), 7,wd);
		wd.findElement(
				By.xpath(xpathStarting + rowNum + xpathEnd)).clear();
		wd.findElement(
				By.xpath(xpathStarting + rowNum + xpathEnd)).sendKeys(setValue);
	}

	/**
	 * Reads the data from excel sheet
	 * 
	 * @throws IOException
	 */

	public void collectExcelData() throws IOException {
		file = new TestInitializer().getFile(TestInitializer.quickOrderData);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("QuickOrderItemTableValidation");
		rowCount = sheet.getLastRowNum() + 1;
		colCount = sheet.getRow(1).getLastCellNum();
		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				cell = sheet.getRow(i).getCell(j);
				sheet.getRow(i).getCell(j).setCellFormula(null);

			}
		}

	}

	/**
	 * 
	 * @param errorMessageXpath
	 * @param testCaseName
	 * @param dataSet
	 * @throws IOException
	 */
	public void validateAddToCartForEmptyCell(String errorMessageXpath,
			String testCaseName, String dataSet) throws IOException {
		try {
			if (TestInitializer.getWebElement(errorMessageXpath,wd).isDisplayed()) {
				ReportGenerator.setLogAndCreateScreenshot(QUICK_ORDER_TEST,
						testCaseName, dataSet, Constants.PASSED,wd);
			} else {
				ReportGenerator.setLogAndCreateScreenshot(QUICK_ORDER_TEST,
						testCaseName, dataSet, Constants.FAILED,wd);
			}
		} catch (Exception t) {
			ReportGenerator.setLogAndCreateScreenshot(QUICK_ORDER_TEST,
					testCaseName, dataSet, Constants.FAILED, t.getMessage(),wd);
		}
	}

	/**
	 * This method is used to load the date from excel to quick order page
	 * 
	 * @param dataSet
	 * 
	 * @throws IOException
	 */
	public void setDataFromExcelToQuickOrderTable(String dataSet)
			throws IOException {
		try {
			for (int rowNum = 1; rowNum <= totalAddLine; rowNum++) {
				String setItemValue = sheet.getRow(rowNum).getCell(1)
						.getStringCellValue();
				String setQuantityValue = sheet.getRow(rowNum).getCell(2)
						.getStringCellValue();
				String setBinValue = sheet.getRow(rowNum).getCell(3)
						.getStringCellValue();
				String setCommentValue = sheet.getRow(rowNum).getCell(4)
						.getStringCellValue();

				if (!setItemValue.equals("NA")) {
					setValuesInTable(rowNum,
							QUICK_ORDER_ITEM_NUMBER_TEXT_START,
							QUICK_ORDER_ITEM_NUMBER_TEXT_END, setItemValue);
				}
				if (!setQuantityValue.equals("NA")) {

					setValuesInTable(rowNum, QUICK_ORDER_QTY_TEXT_START,
							QUICK_ORDER_QTY_TEXT_END, setQuantityValue);
				}
				if (!setBinValue.equals("NA")) {
					setValuesInTable(rowNum,
							QUICK_ORDER_BIN_LOCATION_TEXT_START,
							QUICK_ORDER_BIN_LOCATION_TEXT_END, setBinValue);
				}
				if (!setCommentValue.equals("NA")) {
					setValuesInTable(rowNum, QUICK_ORDER_COMMENTS_TEXT_START,
							QUICK_ORDER_COMMENTS_TEXT_END, setCommentValue);
				}
			}
			TestInitializer.getWebElement(QUICK_ORDER_ADDTOCART_BUTTON_X_PATH,wd)
					.click();
			ReportGenerator.setLogAndCreateScreenshot(QUICK_ORDER_TEST,
					QUICK_ORDER_TEST_ENTERING_VALUES_INTABLE_TESTNAME, dataSet,
					Constants.PASSED,wd);
		}

		catch (Exception t) {

			ReportGenerator.setLogAndCreateScreenshot(QUICK_ORDER_TEST,
					QUICK_ORDER_TEST_ENTERING_VALUES_INTABLE_TESTNAME, dataSet,
					Constants.FAILED, t.getMessage(),wd);
		}

	}

	/**
	 * This method set the rows for quick order table
	 */

	public void setQuickOrderTableRows() {
		for (int colNumber = colCount; colNumber > 1; colNumber--) {
			for (int rowNumber = rowCount; rowNumber > 1; rowNumber--) {
				if (!sheet.getRow(rowNumber - 1).getCell(colNumber - 1)
						.getStringCellValue().equals("NA")) {
					if (lineCount < rowNumber) {
						lineCount = rowNumber;
					}
				}
			}
		}
	}

	/**
	 * This method adds the line item from excel to quick order page
	 * 
	 * @param dataSet
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void addLine(String dataSet) throws IOException,
			InterruptedException {
		for (int addLine = 1; addLine <= addLineCount; addLine++) {
			TestInitializer.scrollDown(wd);
			Thread.sleep(2000L);
			TestInitializer.getWebElement(QUICK_ORDER_ADD_LINE_BUTTON_X_PATH,wd)
					.click();
			try {
				ReportGenerator
						.setLog("Please enter atleaset one line verification is initialized");
				if (addLine == 1
						&& TestInitializer.getWebElement(
								QUICK_ORDER_PLEASE_SELECT_ERRRO_MESSAGE_X_PATH,wd)
								.isDisplayed()) {
					ReportGenerator.setLogAndCreateScreenshot(QUICK_ORDER_TEST,
							QUICK_ORDER_TEST_VERIFY_PLEASE_ENTERTEXT_TESTNAME,
							dataSet, Constants.PASSED,wd);
					TestInitializer.getWebElement(
							QUICK_ORDER_ITEM_NUMBER_TEXT_X_PATH,wd).sendKeys(
							TestInitializer.PROJECT.getProperty("itemNumber"));
					TestInitializer.getWebElement(QUICK_ORDER_QTY_TEXT_X_PATH,wd)
							.sendKeys(
									TestInitializer.PROJECT
											.getProperty("quantity"));

				}
			} catch (Exception e) {
				ReportGenerator.setLogAndCreateScreenshot(QUICK_ORDER_TEST,
						QUICK_ORDER_TEST_VERIFY_PLEASE_ENTERTEXT_TESTNAME,
						dataSet, Constants.FAILED,wd);
			}
		}
	}

	/**
	 * This method is used to collect the error messages for invalid lines
	 * 
	 * @param dataSet
	 * @throws IOException
	 */
	public void collectErrorMessage(String dataSet) throws IOException {
		try {
			ReportGenerator
					.setLog("Getting all error message list is initiated");
			ReportGenerator.setLog(TestInitializer.getWebElement(
					QUICK_ORDER_ERROR_TEXT_X_PATH,wd).getText());
			WebElement errorMessage = TestInitializer
					.getWebElement(QUICK_ORDER_ERROR_PAGE_MESSAGE_TEXT_X_PATH,wd);
			List<WebElement> errorMessageCount = errorMessage.findElements(By
					.tagName("p"));
			for (int PageCount = 1; PageCount <= errorMessageCount.size(); PageCount++) {
				TestInitializer.highlightMyElement(
						wd.findElement(By
								.xpath(QUICK_ORDER_ERRRO_MESSAGE_START
										+ PageCount
										+ QUICK_ORDER_ERRRO_MESSAGE_END)), 7,wd);
				String x = wd.findElement(
						By.xpath(QUICK_ORDER_ERRRO_MESSAGE_START + PageCount
								+ QUICK_ORDER_ERRRO_MESSAGE_END)).getText();
				String[] SplitErrors = x.split(" ");
				String PleaseEnterError = SplitErrors[1];
				String ItemError = SplitErrors[3];
				String LineNumber = PleaseEnterError.substring(0,
						PleaseEnterError.length() - 1);
				String ColumId = ItemError.substring(0, ItemError.length() - 1);
				LineColumnCheck(LineNumber, ColumId);
			}
			TestInitializer.getWebElement(QUICK_ORDER_REMOVE_BUTTON_X_PATH,wd)
					.click();
			ReportGenerator.setLogAndCreateScreenshot(QUICK_ORDER_TEST,
					QUICK_ORDER_TEST_ERROR_MESSAGE_TESTNAME, dataSet,
					Constants.PASSED,wd);
		} catch (Exception t) {
			ReportGenerator.setLogAndCreateScreenshot(QUICK_ORDER_TEST
					.concat(QUICK_ORDER_TEST_ERROR_MESSAGE_TESTNAME),
					QUICK_ORDER_TEST_ERROR_MESSAGE_TESTNAME, dataSet,
					Constants.FAILED, t.getMessage(),wd);
		}
	}

	/**
	 * This method checks whether the remove button is disabled state or not
	 * 
	 * @throws IOException
	 */

	public void validateRemoveButton() throws IOException {
		try {
			TestInitializer.getWebElement(QUICK_ORDER_REMOVE_BUTTON_X_PATH,wd)
					.isEnabled();
		} catch (Exception e) {
			if (TestInitializer.getWebElement(
					QUICK_ORDER_ERROR_MESSAGE_TEXT_X_PATH,wd).isDisplayed()) {
				ReportGenerator
						.setLog("Remove all invalid lines button is not enabled please check it ");
			} else {
				ReportGenerator.setLog("This is normal entry");
			}
		}

	}

	/**
	 * This method decides how many rows needs to be added to the quick order
	 * page
	 */
	public void decideNumberOfAddingRows() {
		totalAddLine = lineCount - 1;
		if (totalAddLine == 0) {
			addLineCount = (totalAddLine / 10);
		} else {
			addLineCount = (totalAddLine / 10) + 1;
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
	@DataProvider(name = QUICK_ORDER_TEST)
	public static Object[][] getInputFromXLS() throws Exception {
		return InputReader.getInputReader().getDataFromXLS(QUICK_ORDER_TEST);
	}

	/**
	 * Tear down
	 */
	@AfterClass
	public void teardown() {
		TestInitializer.tearDown(wd);
	}

}
