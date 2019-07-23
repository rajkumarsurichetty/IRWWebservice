package com.doosan.nao.init;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.doosan.nao.constants.Constants;
import com.doosan.nao.reports.ReportGenerator;



/*
 * This class is used to initialize the necessary files used to run this
 * application
 */



public class TestInitializer {

	public static String isBrowserAlive="N";
	public static String failureTestData="N";
	public static String failureReason="N";
	public static String failureTestCase="N";
	public static String failureClassName="N";
	
	public static String testCaseId;
	public static String className;
	public static String methodName; 
	public final Logger LOG = LoggerFactory.getLogger(TestInitializer.class);
	public static Properties PROJECT = null;

	public static WebDriverWait wait = null;
	public static boolean isDataProvider = false;
	public static String log4jConfPath;
	private static String log4jFilePath = "log4j.properties";
	public static String errorElementPath = "/test-output/ElementFailScreenShot/";
	public static String quickOrderData = "QuickOrderTestData.xlsx";
	public static String ieExePath = "BrowserSetUp/IEDriverServer.exe";
	public static String chromeExePath = "BrowserSetUp/chromedriver.exe";
	public static ReportGenerator Report = new ReportGenerator();

	
	// private static InputReader inputReader;

	/**
	 * This method used to initialize the property files, Firefox profiles and
	 * Webdriver
	 * 
	 * @param browser
	 * 
	 * @param browserVersion
	 * 
	 * @param platform
	 * 
	 * @param osVersion
	 * @return
	 * 
	 * @throws IOException
	 * @throws URISyntaxException 
	 */

	public static void initialize(String browser, String browserVersion,
			String platform, String osVersion) throws IOException, URISyntaxException {

		PROJECT = new Properties();
			
		InputStream log4jInput=ClassLoader.getSystemClassLoader().getResourceAsStream(log4jFilePath);
		InputStream projectInputFile=ClassLoader.getSystemClassLoader().getResourceAsStream("project.properties");
		
		TestInitializer testInitializer = new TestInitializer();

		PropertyConfigurator.configure(log4jInput);

		PROJECT.load(projectInputFile);
		System.out.println();
		
			}

	/**
	 * This method is used to set the profile for firefox.
	 * 
	 * @return
	 */
	public static FirefoxProfile setPreferencesForFirefox() {
		FirefoxProfile profile = new FirefoxProfile();
		String path = System.getProperty("user.dir")
				+ "\\test-output\\ExportedExcel";
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", path);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference(
				"browser.helperApps.neverAsk.saveToDisk",
				"application/msword,application/csv,text/csv,image/png ,"
						+ "image/jpeg, application/pdf, text/html,text/plain,"
						+ "application/octet-stream"
						+ "application/x-msexcel,application/excel,application/x-excel,application/excel,"
						+ "application/x-excel,application/excel,application/vnd.ms-excel,"
						+ "application/x-excel,application/x-msexcel");
		profile.setPreference("browser.download.manager.showWhenStarting",
				false);
		profile.setPreference("browser.download.manager.focusWhenStarting",
				false);
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		profile.setPreference("browser.download.manager.closeWhenDone", false);
		profile.setPreference("browser.download.manager.showAlertOnComplete",
				false);
		profile.setPreference("browser.download.manager.useWindow", false);
		profile.setPreference("browser.download.manager.showWhenStarting",
				false);
		profile.setPreference(
				"services.sync.prefs.sync.browser.download.manager.showWhenStarting",
				false);
		profile.setPreference("pdfjs.disabled", true);
		return profile;
	}

	/**
	 * This method is used to get corrresponding web element for path key in the
	 * parts portal
	 * 
	 * @param pathKey
	 * 
	 * @return web element for the corresponding Xpath
	 * @throws IOException
	 */

	public static WebElement getWebElement(String pathKey, WebDriver webDriver) throws IOException {
		
		String LocatorSelection = pathKey.substring(pathKey.length() - 1,
				pathKey.length());

		waitForElementPresent(pathKey, webDriver);
		if (LocatorSelection.equals(Constants.FIND_ELEMENT_BY_NAME)) {
			return webDriver.findElement(By.name(PROJECT.getProperty(pathKey)));
		} else if (LocatorSelection.equals(Constants.FIND_ELEMENT_BY_ID)) {
			return webDriver.findElement(By.id(PROJECT.getProperty(pathKey)));
		} else {
			return webDriver
					.findElement(By.xpath(PROJECT.getProperty(pathKey)));
		}
	}

	/**
	 * This method will wait for the web element to get loaded in the page. Once
	 * loaded will load and highlight the web element
	 * 
	 * @param pathKey
	 * 
	 * @throws IOException
	 * 
	 */

	public static void waitForElementPresent(String pathKey, WebDriver webdriver) throws IOException {
		String LocatorSelection = pathKey.substring(pathKey.length() - 1,
				pathKey.length());
		if (LocatorSelection.equals(Constants.FIND_ELEMENT_BY_XPATH)) {
			WebDriverWait wait1 = new WebDriverWait(webdriver, 7);
			wait1.until(ExpectedConditions.presenceOfElementLocated(By
					.xpath(PROJECT.getProperty(pathKey))));
			//highlightMyElement(webdriver.findElement(By.xpath(PROJECT
				//	.getProperty(pathKey))), 7,webdriver);
		} else if (LocatorSelection.equals(Constants.FIND_ELEMENT_BY_NAME)) {
			WebDriverWait wait1 = new WebDriverWait(webdriver, 7);
			wait1.until(ExpectedConditions.presenceOfElementLocated(By
					.name((PROJECT.getProperty(pathKey)))));
			//highlightMyElement(webdriver.findElement(By.name(PROJECT
				//	.getProperty(pathKey))), 7,webdriver);
		} else if (LocatorSelection.equals(Constants.FIND_ELEMENT_BY_ID)) {

			WebDriverWait wait1 = new WebDriverWait(webdriver, 7);
			wait1.until(ExpectedConditions.presenceOfElementLocated(By
					.id(PROJECT.getProperty(pathKey))));
			//highlightMyElement(
				//	webdriver.findElement(By.id(PROJECT.getProperty(pathKey))),
					//7,webdriver);
		}
	}

	/*
	 * public static InputReader getInputReader(){
	 * 
	 * return inputReader; }
	 */
	/**
	 * This method will load the drop down corresponding to Xpath and input key
	 * 
	 * @param XpathKey
	 * @param InputKey
	 * 
	 */
	public static void dropdown(String XpathKey, String InputKey, WebDriver webdriver) {
		Select sel = new Select(webdriver.findElement(By.xpath(PROJECT
				.getProperty(XpathKey))));
		int y = Integer.parseInt(InputKey);
		sel.selectByIndex(y);
	}

	/**
	 * This method is used to make the test to wait for sometime before
	 * executing it.
	 * 
	 * @throws IOException
	 * 
	 * @throws InterruptedException
	 */
	public static void waitForSometime() throws IOException,
			InterruptedException {
		Thread.sleep(10000L);
	}

	/**
	 * This method is used to highlight the element
	 * 
	 * @param element
	 * 
	 * @param waitSeconds
	 * 
	 * @throws IOException
	 */
	public static void highlightMyElement(WebElement element, int waitSeconds, WebDriver webdriver)
			{
		for (int i = 0; i < waitSeconds; i++) {
			JavascriptExecutor js = (JavascriptExecutor) webdriver;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "color: red; border: 5px solid red;");
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "");

		}

	}

	/**
	 * This method is used to scroll down to the bottom of the page.
	 */
	public static void scrollDown(WebDriver webdriver) {
		JavascriptExecutor js = (JavascriptExecutor) webdriver;
		js.executeScript("javascript:window.scrollBy(0,300000)");
	}

	public static void Dataprovidercheck(boolean TF) {
		isDataProvider = TF;
	}

	/**
	 * This method is used to get the current workspace directory.
	 * 
	 * @return CurrentWorkSpace
	 */

	public static String getCurrentWorkSpaceDir() {
		String userDir = System.getProperty("user.dir");
		System.out.println(userDir);
		String[] test = userDir.split("\\\\");
		String CurrentWorkSpace = "";
		for (int i = test.length - 2; i >= 0; i--) {
			CurrentWorkSpace = test[i] + "\\" + CurrentWorkSpace;
		}
		return CurrentWorkSpace;
	}

	/**
	 * This method is used to set the organization.
	 */
	public static void setOrganization(WebDriver wd) {
		ReportGenerator.setLog("setOrganization() initiated::");
		try {

			/*
			webdriver.get(PROJECT
					.getProperty(Constants.DOOSAN_URL));
			getWebElement(
					Constants.LOGIN_PAGE_USERNAME_TEXT_X_PATH, webdriver).sendKeys(
					TestInitializer.PROJECT.getProperty("rajkumars"));
			getWebElement(
					Constants.LOGIN_PAGE_PASSWORD_TEXT_X_PATH, webdriver).sendKeys(
					TestInitializer.PROJECT.getProperty("welcome3"));
			getWebElement(
					Constants.LOGIN_PAGE_SUBMIT_BUTTON_X_PATH, webdriver).click();
			waitForSometime();
			webdriver.navigate().to(
					TestInitializer.PROJECT.getProperty(Constants.PARTS_5_URL));
			getWebElement(
					Constants.HOME_PAGE_ORG_NAME_TEXT_X_PATH, webdriver)
					.sendKeys(
							TestInitializer.PROJECT
									.getProperty(Constants.ORGANIZATION));
			getWebElement(
					Constants.HOME_PAGE_ORG_SEARCH_BUTTON_X_PATH, webdriver).click();
			getWebElement(
					Constants.HOME_PAGE_ORG_SELECT_ORG_LINK_X_PATH, webdriver).click();
					
					*/
			
			wd.get(PROJECT.getProperty("DoosanPassportURL"));
			getWebElement(Constants.LOGIN_PAGE_USERNAME_TEXT_X_PATH,wd).sendKeys("rajkumars");
			getWebElement(Constants.LOGIN_PAGE_PASSWORD_TEXT_X_PATH,wd).sendKeys("welcome3");
			getWebElement(Constants.LOGIN_PAGE_SUBMIT_BUTTON_X_PATH,wd).submit();
			Thread.sleep(10000L);
			
			wd.navigate().to(PROJECT.getProperty("DoosanParts5URL"));

			if(wd.getTitle().contains("Certificate Error"))
			{
		    wd.findElement(By.id("overridelink")).click();
			}
		    
		    
			try {
			wd.findElement(By.linkText("Change")).click();
			} catch (Throwable t)
			{
				
			}
			
			WebDriverWait waitForSearchByDropdown=new WebDriverWait(wd, 30);
			waitForSearchByDropdown.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[2]/select")));
			
			Select selectBrand=new Select(wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[2]/select")));
			selectBrand.selectByVisibleText("Brand");

			WebDriverWait waitForOrgSection=new WebDriverWait(wd, 30);
			waitForOrgSection.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")));
			
			
			Select selectBrandByInput=new Select(wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")));
			selectBrandByInput.selectByVisibleText("Doosan".trim());
			wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[2]/td[3]/input")).sendKeys("1040141");
			wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/button")).click();
			
			WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 30);
			waitForFirstOrgLink.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")));

			wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")).click();

			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		ReportGenerator.setLog("setOrganization() completed::");
	}
	/**
	 * This method gets the file from the Class 
	 * 
	 * @param fileName
	 * 
	 * @return
	 */
	public File getFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		
		return new File(classLoader.getResource(fileName).getFile());
	}

	/**
	 * This method is used to close the web driver once the test case is
	 * executed.
	 */

	public static void tearDown(WebDriver webdriver) {
		webdriver.close();
	}

	public static String getPropertyFile()
	
	{
		String location = TestInitializer.class.getProtectionDomain().getCodeSource().getLocation().toString();
	    String[] splits = location.split("/");
	    
	    System.out.println(location);
	    String configFolder="";
	    for (int i=1;i<splits.length-3;i++)
	    {
	    	configFolder=configFolder+splits[i]+File.separator;
	    	System.out.println(configFolder);
	    }
		return configFolder;
		
	}
	
	public static void waitforpagetoload(EventFiringWebDriver wd)
	{
		for (int i = 0; i <= 60; i++) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	       boolean pagestatus = ((JavascriptExecutor)wd).executeScript("return document.readyState").equals("complete");
	       if (pagestatus == true) {
	              break;
	          }
	        }
	} 
	public static void waitForElement(WebDriver wd, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(wd, 160);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}

/**
	 * This for Updating Status in TEstRail
	 * @param testRunId
	 * @param testCaseId
	 * @param status
	 * @param error
	 * @throws IOException
	 * @throws APIException
	 */
	public static void addResultForTestCase(String testRunId,String testCaseId, int status, String error)  {

        //String testRunId = "2266";index.php?/api/v2/close_run/:run_id

        APIClient client = new APIClient("https://testrail.prod.corp.doosan.com/testrail/");
        client.setUser("rajkumars");
        client.setPassword("Welcome@5");
       
        Map data = new HashMap();
        data.put("status_id", status);
        data.put("comment",error );
        try {
			JSONObject c3 = (JSONObject) client.sendPost("add_result_for_case/"+testRunId+"/"+testCaseId+"",data );
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       //client.sendPost();

    }
}
