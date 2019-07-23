package com.doosan.nao.reports;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

public class ReportGenerator {
	private static final Logger LOG = LoggerFactory
			.getLogger(ReportGenerator.class);
	private static Screenshot screenShot = new Screenshot();
	private static DateFormat dateFormat = new SimpleDateFormat(
			"yyyy/MM/dd HH:mm:ss");
	private static Date date = new Date();

	/**
	 * This method used to provide only log details
	 * 
	 * @param logDetails
	 */

	public static void setLog(String logDetails) {
		LOG.info(logDetails);
		Reporter.log(dateFormat.format(date) + "  :   " + logDetails);
		System.out.println(dateFormat.format(date) + "  :   " + logDetails);
	}

	/**
	 * This method is used to generate logs and send the data's to XSLT for
	 * report generation
	 * 
	 * @param className
	 * 
	 * @param testCaseName
	 * 
	 * @param testData
	 * 
	 * @param status
	 * 
	 * @throws IOException
	 * 
	 */

	/*public static void setLogAndCreateScreenshot(String className,
			String testCaseName, String testData, String status,WebDriver wd)
			throws IOException {*/
	public static String setLogAndCreateScreenshot(String className,
			String testCaseName, String testData, String status,WebDriver wd)
			throws IOException {
		System.out.println(className.concat(":").concat(status));
		//System.err.println("enterd set log");
		LOG.info(className.concat(":").concat(status));
		Reporter.log(dateFormat.format(date).concat(":")
				.concat(className.concat(":").concat(status)));
		String path=screenShot.addScreenShotToXSLT(className, testCaseName, testData,
				status, " ",wd);
		//System.err.println("enterd completedd");
		return path;
	}
	

	/**
	 * This method is used to generate logs and send the data's to XSLT for
	 * report generation for failure test cases with the exception message
	 * 
	 * @param className
	 * 
	 * @param testCaseName
	 * 
	 * @param testData
	 * 
	 * @param status
	 * 
	 * @param exceptionMessage
	 * 
	 * @throws IOException
	 */

	/*public static void setLogAndCreateScreenshot(String className,
			String testCaseName, String testData, String status,
			String exceptionMessage,WebDriver wd) throws IOException {*/
	public static String setLogAndCreateScreenshot(String className,
			String testCaseName, String testData, String status,
			String exceptionMessage,WebDriver wd) throws IOException {
		
		System.out.println(className.concat(":").concat(status)+ exceptionMessage);
		LOG.info(className.concat(":").concat(status), exceptionMessage);
		Reporter.log(dateFormat.format(date).concat(":")
				.concat(className.concat(":").concat(status)));
		String path=screenShot.addScreenShotToXSLT(className, testCaseName, testData,
				status, exceptionMessage,wd);
		return path;
	}

}
