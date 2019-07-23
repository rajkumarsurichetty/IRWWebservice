package com.doosan.nao.reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Screenshot {

	final File currentDirFile = new File(".");
	final String helper = currentDirFile.getAbsolutePath();
	final String currentDir = helper.substring(0, helper.length() - 1);
	final String logFolder = "logs";

	//final String testOutput = "test-output";//Hybris\reports\Screenshots
	//final String screenshot = "screenshot";
	//final String scrfilepath = testOutput + File.separator + screenshot;
	final String Screenshots = "Screenshots";
	final String scrfilepath = "//che-dt-idc1/Hybris/reports/Screenshots";//che-dt-idc1/reports/
	final String archive = "archive";
	private static int report = 0;
	private final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";

	/**
	 * 
	 * @param scr
	 * 
	 * @param dst
	 * 
	 * @throws IOException
	 */
	static void copyfile(File scr, File dst) throws IOException

	{
		if (scr.isDirectory()) {
			if (!dst.exists()) {
				dst.mkdir();
			}

			String[] FilePaths = scr.list();
			for (String Filepath : FilePaths) {
				File ScrFile = new File(scr, Filepath);
				File DstFile = new File(dst, Filepath);
				copyfile(ScrFile, DstFile);
			}
		}

		else {
			FileInputStream from = null;
			FileOutputStream to = null;
			from = new FileInputStream(scr);
			to = new FileOutputStream(dst);

			byte[] buffer = new byte[4096];
			int bytereads = 0;
			while ((bytereads - from.read(buffer)) != 1) {
				to.write(buffer, 0, bytereads);
			}

			from.close();
			to.close();

		}
	}

	/**
	 * This method will called by this method ScreenShot_AddToXSLT. It will
	 * delete the existing screenshot folder and create the new screenshot
	 * folder for new set of inputs
	 * 
	 * @param file
	 * 
	 * @throws IOException
	 */
	public static void delete(File file) throws IOException {

		if (file.isDirectory()) {

			// directory is empty, then delete it
			if (file.list().length == 0) {

				file.delete();

			} else {

				// list all the directory contents
				String files[] = file.list();

				for (String temp : files) {
					// construct the file structure
					File fileDelete = new File(file, temp);

					// recursive delete
					delete(fileDelete);
				}

				// check the directory again, if empty then delete it
				if (file.list().length == 0) {
					file.delete();

				}
			}

		} else {
			// if file, then delete it
			file.delete();

		}
	}

	public void copyLogFile(String srcLog, String dstLog) {
		final DateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH.mm.ss");
		final Date date = new Date();

		try {
			File sourceFile = new File(srcLog);
			String logFilePath = dstLog + File.separator + "logs"
					+ File.separator + dateFormat.format(date) + "test.log";
			File dstFile = new File(logFilePath);
			FileUtils.copyFile(sourceFile, dstFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will called every failed cases and pass cases to take screen
	 * shot and adding to xslt reports
	 * 
	 * @param className
	 * 
	 * @param testCaseName
	 * 
	 * @param testData
	 * 
	 * @param status
	 * 
	 * @param failureReason
	 * 
	 * @throws IOException
	 */
	/*public void addScreenShotToXSLT(String className, String testCaseName,
			String testData, String status, String failureReason,WebDriver wd)
			throws IOException {*/
	public String addScreenShotToXSLT(String className, String testCaseName,
			String testData, String status, String failureReason,WebDriver wd)
			throws IOException {
		final String previousScreenshots = "PreviousScreenshots";
		final DateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd-HH.mm.ss");
		final Date date = new Date();
		final String colorGreen = "green";
		final String colorRed = "red";
		final String colorOrange = "Orange";
		final String otherReason = "";

		final String logFileName = "test.log";
//Chnaged for Testrail status
		/*final String dstfilepath = testOutput + File.separator + archive
				+ File.separator + previousScreenshots
				+ dateFormat.format(date);

		final String archiveFilepath = testOutput + File.separator + archive;
		File dscreate = new File(dstfilepath);

		File file = new File(scrfilepath);

		final String archiveLog = currentDir + testOutput + File.separator
				+ archive;
*/final String dstfilepath = "//che-dt-idc1/Hybris/archive/"+previousScreenshots+dateFormat.format(date);

final String archiveFilepath = "//che-dt-idc1/Hybris/archive";
File dscreate = new File(dstfilepath);

File file = new File(scrfilepath);

final String archiveLog = currentDir + "//che-dt-idc1/Hybris/archive";// + File.separator+ archive;
		final String srcLogFilepath = currentDir + logFileName;
		final File srcLogFile = new File(currentDir + logFileName);

		File archiveFile = new File(archiveFilepath);
		if (srcLogFile.exists()) {
			copyLogFile(srcLogFilepath, archiveLog);
		}

		if (!archiveFile.exists()) {
			archiveFile.mkdir();
		}

		if (report == 0) {

			if (!dscreate.exists()) {
				dscreate.mkdir();
			}

			if (file.exists()) {
				//copyfile(new File(scrfilepath), new File(dstfilepath));
				System.out.println("i am try to delete file");
				
				//delete(file);
				clearFile(srcLogFilepath);
			}

			if (!file.exists()) {
				file.mkdir();
			}
			
			report++;
		}
		System.setProperty(ESCAPE_PROPERTY, "false");
		File srcFile = ((TakesScreenshot) wd)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(scrfilepath + File.separator
					+dateFormat.format(date)+ className + "_" + testCaseName + "_" + testData + "_"
					+ status + ".jpg"));
			//System.err.println("verify if condition");
			if (status.equalsIgnoreCase("Passed")) {

				generateReport(className, testCaseName, testData, status,
						colorGreen, otherReason);
			} else if (!status.equalsIgnoreCase("Failed")
					&& !status.equalsIgnoreCase("Passed")) {

				generateReport(className, testCaseName, testData, status,
						colorOrange, otherReason);
			}

			else {

				generateReport(className, testCaseName, testData, status,
						colorRed, failureReason);
			}
		} catch (IOException e)

		{
			ReportGenerator.setLog(e.getMessage());
		}
		Reporter.setCurrentTestResult(null);
		return  dateFormat.format(date)+ className + "_" + testCaseName + "_" + testData + "_"
					+ status + ".jpg";
	}

	/**
	 * This method is used to generate the report
	 * 
	 * @param className
	 * 
	 * @param testCaseName
	 * 
	 * @param testData
	 * 
	 * @param status
	 * 
	 * @param color
	 * 
	 * @param reason
	 */

	private void generateReport(String className, String testCaseName,
			String testData, String status, String color, String reason) {

		Reporter.log("<tr><td><a href='" + "file:///" + currentDir
				+ File.separator + scrfilepath + File.separator + className
				+ "_" + testCaseName + "_" + testData + "_" + status
				+ ".jpg'> <img src='" + "file:///" + currentDir
				+ File.separator + scrfilepath + File.separator + className
				+ "_" + testCaseName + "_" + testData + "_" + status
				+ ".jpg' height='100' width='100'/>"
				+ "<b><strong><font size='" + "3" + "' color='" + "OrangeRed"
				+ "'></font></strong></b>" + "<b><font size='" + "3"
				+ "' color='" + "Indigo" + "'>" + className + "_"
				+ testCaseName + "_" + testData + "_" + "<font size='" + "3"
				+ "' color='" + color + "'>" + status
				+ "</font></b></a></td></tr>");
		if (!reason.isEmpty()) {
			Reporter.log("<font size='" + "3" + "' color='" + "Tomato"
					+ "'>Reason for Failure   :  </font>" + "<font size='"
					+ "3" + "' color='" + "DarkSlateGray" + "'>" + reason
					+ "</font>");
		}

	}

	public static void clearFile(String fileLocation) {
		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(fileLocation));
			bw.write("");
			bw.flush();
			bw.close();

		} catch (IOException ioe) {
			ReportGenerator.setLog(ioe.getMessage());
		}
	}

}
