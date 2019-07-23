package com.doosan.nao.input;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.reports.ReportGenerator;


/**
 * This class is used to get the input data's from the Excel Sheets.
 * 
 * @author vinoth kumar T
 * 
 * @version 1.0
 * 
 */

public class InputReader {

	public static Object[][] data = null;
	private final String YES = "Y";
	private String inputExcelController = "SingleInputTestData.xlsx";
	private String multipleInputExcel = "MultiInputTestData.xlsx";

	private static InputReader inputReader;

	ClassLoader classLoader = getClass().getClassLoader();

	public static InputReader getInputReader() {
		if (inputReader == null) {
			inputReader = new InputReader();
		}
		return inputReader;
	}

	/**
	 * This method will get the input from Excel Sheet for single input test
	 * cases
	 * 
	 * @param TestCaseName
	 * 
	 * @return data object
	 */

	public Object[][] getInputFromSingleInputTestData(String TestCaseName) {
		ReportGenerator.setLog("getInputFromSingleInputTestData initated::"
				+ TestCaseName);
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(ClassLoader.getSystemClassLoader().getResourceAsStream(inputExcelController));
			XSSFSheet TcSheet = workbook.getSheet(TestCaseName);
			int TcRow = TcSheet.getLastRowNum();
			data = new Object[1][TcRow + 1];
			for (int i = 0; i <= TcRow; i++) {
				TcSheet.getRow(i).getCell(5).setCellType(CellType.STRING);//Changed here 
				data[0][i] = TcSheet.getRow(i).getCell(5).getStringCellValue();
			}
		} catch (FileNotFoundException e) {
			ReportGenerator.setLog(e.getMessage());
		} catch (IOException ioe) {
			ReportGenerator.setLog(ioe.getMessage());
		}
		ReportGenerator.setLog("getInputFromSingleInputTestData completed::"
				+ TestCaseName);
		return data;
	}

	/**
	 * This method will get the input from Excel Sheet for multiple input test
	 * cases
	 * 
	 * @param TestCaseName
	 * 
	 * @return data object
	 */

	private Object[][] getInputFromMultiInputTestData(String TestCaseName) {
		XSSFWorkbook workbook;
		ReportGenerator.setLog("getInputFromMultiInputTestData initated::"
				+ TestCaseName);
		try {
			System.err.println("Entered mul");
			workbook = new XSSFWorkbook(ClassLoader.getSystemClassLoader().getResourceAsStream(TestCaseName+".xlsx"));
			XSSFSheet tcSheetName = workbook.getSheet(TestCaseName);
			int lastRowNum = tcSheetName.getLastRowNum();
			int lastColNum = tcSheetName.getRow(1).getLastCellNum();
			data = new Object[lastColNum][lastRowNum + 1];
			for (int i = 0; i <= lastRowNum; i++) {
				for (int j = 0; j < lastColNum; j++) {
					tcSheetName.getRow(i).getCell(j)
							.setCellType(CellType.STRING);//chnaged for j1.8 and poi 4 
					data[j][i] = tcSheetName.getRow(i).getCell(j)
							.getStringCellValue();
				}
			}
		} catch (FileNotFoundException e) {
			ReportGenerator.setLog(e.getMessage());
		} catch (IOException ioe) {
			ReportGenerator.setLog(ioe.getMessage());
		}
		ReportGenerator.setLog("getInputFromMultiInputTestData completed::"
				+ TestCaseName);
		return data;
	}

	/**
	 * Once the RunMode is set as Y, this method will be called and verifies
	 * whether the the particular test case needs to be run with single set of
	 * data or multiple set of data
	 * 
	 * @param testCaseName
	 * 
	 * @return data Object
	 */

	private Object[][] verifyInputMode(String testCaseName) {
		ReportGenerator.setLog("RunModeDataSearch initated::" + testCaseName);
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(ClassLoader.getSystemClassLoader().getResourceAsStream(inputExcelController));
			XSSFSheet sheetName = workbook.getSheet("Test Case");
			int rowCount = sheetName.getLastRowNum();
			for (int k = 1; k <= rowCount; k++) {
				// retrieving test name from Excel Sheet
				String testName = sheetName.getRow(k).getCell(0)
						.getStringCellValue();
				if (testName.equals(testCaseName)) {
					// Decides which test data should be executed(Single /
					// Multiple data)
					String multiInputData = sheetName.getRow(k).getCell(3)
							.getStringCellValue();
					if (multiInputData.equals(YES)) {
						getInputFromMultiInputTestData(testCaseName);
						break;
					} else {
						getInputFromSingleInputTestData(testCaseName);
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			ReportGenerator.setLog(e.getMessage());
		} catch (IOException ioe) {
			ReportGenerator.setLog(ioe.getMessage());
		} catch (Exception e) {
			ReportGenerator.setLog(e.getMessage());
		}
		ReportGenerator.setLog("RunModeDataSearch completed::" + testCaseName);
		return data;
	}

	/**
	 * This method will be called to verify the whether particular test case
	 * needs to be executed or not. If runMode is Y will execute the test case.
	 * If N will not execute the testcase
	 * 
	 * @param TestCaseName
	 * 
	 * @return boolean
	 */
	public boolean verifyRunMode(String TestCaseName) {
		ReportGenerator.setLog("RunModeVerification initited::" + TestCaseName);
		XSSFWorkbook workbook;
		try {

			workbook = new XSSFWorkbook(ClassLoader.getSystemClassLoader().getResourceAsStream(inputExcelController));
			XSSFSheet tcSheetName = workbook.getSheet("Test Case");
			int tcRowNum = tcSheetName.getLastRowNum();
			for (int k = 1; k <= tcRowNum; k++) {
				String RunMode = tcSheetName.getRow(k).getCell(2)
						.getStringCellValue();
				String tcName = tcSheetName.getRow(k).getCell(0)
						.getStringCellValue();
				if (RunMode.equalsIgnoreCase(YES) && tcName.equalsIgnoreCase(TestCaseName)) {
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			ReportGenerator.setLog(e.getMessage());
		} catch (IOException ioe) {
			ReportGenerator.setLog(ioe.getMessage());
		}
		ReportGenerator
				.setLog("RunModeVerification completed::" + TestCaseName);
		return false;
	}

	/**
	 * This method is used to get the input data from XLS sheet
	 * 
	 * @param fileName
	 * 
	 * @return data Object
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 */

	public Object[][] getDataFromXLS(String fileName) {
		
		
		ReportGenerator.setLog("getDataFromXLS initiated::" + fileName);
		Object[][] data = null;
		try {
			if (verifyRunMode(fileName)) {
				data = verifyInputMode(fileName);
				TestInitializer.isDataProvider = true;
				System.err.println("test");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			ReportGenerator.setLog("Errror occured while getDataFromXLS ::"
					+ fileName);
		}
		return data;
	}

}
