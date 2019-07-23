package com.doosan.pageFactoryHomePages;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.doosan.nao.PageFactory.AllMakesPage;
import com.doosan.nao.PageFactory.BatchOrderUploadPage;
import com.doosan.nao.PageFactory.CheckPriceAndAvailabityPage;
import com.doosan.nao.PageFactory.HomePage;
import com.doosan.nao.PageFactory.LoginPage;
import com.doosan.nao.PageFactory.QuickOrderPage;
import com.doosan.nao.PageFactory.SelectOrgPage;
import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;
import com.doosan.nao.reports.ReportGenerator;

public class HomePageValidator extends TestInitializer {

	private String isBrowserAlive = "N";
	public EventFiringWebDriver wd = null;
	private String localTestData;

	public HomePage homePage = null;
	public AllMakesPage allMakesPage = null;
	public LoginPage loginPage = null;
	public SelectOrgPage selectOrgPage = null;
	public CheckPriceAndAvailabityPage checkPriceAndAvailabityPage = null;
	public BatchOrderUploadPage batchOrderUploadPage = null;
	public QuickOrderPage quickOrderPage = null;

	public String validFile = System.getProperty("user.dir") + File.separator
			+ "src" + File.separator + "main" + File.separator + "resources"
			+ File.separator + "ValidFile.xls";
	public String inValidFile = System.getProperty("user.dir") + File.separator
			+ "src" + File.separator + "main" + File.separator + "resources"
			+ File.separator + "InvalidFile.xls";
	public String MoreLineInvalidFile = System.getProperty("user.dir")
			+ File.separator + "src" + File.separator + "main" + File.separator
			+ "resources" + File.separator + "InvalidLineItems.xls";

	@BeforeMethod
	public void setUpForBatchOrderUploadValidator() throws IOException,
			URISyntaxException, InterruptedException {

		if (isBrowserAlive == "N") {
			wd = WebdriverSelector.getDriver(wd, "firefox");

			initialize("firefox", "", "", "");

			wd.get(PROJECT.getProperty("DoosanPassportURL"));
		}

		homePage = PageFactory.initElements(wd, HomePage.class);
		loginPage = PageFactory.initElements(wd, LoginPage.class);
		selectOrgPage = PageFactory.initElements(wd, SelectOrgPage.class);
		checkPriceAndAvailabityPage = PageFactory.initElements(wd,
				CheckPriceAndAvailabityPage.class);
		batchOrderUploadPage = PageFactory.initElements(wd,
				BatchOrderUploadPage.class);
		allMakesPage = PageFactory.initElements(wd, AllMakesPage.class);

		if (isBrowserAlive == "N") {

			loginPage.enterUserName("rajkumars");
			loginPage.enterPassword("Welcome1");
			loginPage.clickLoginButton();
			Thread.sleep(10000L);
		}

		wd.get("http://parts3.qa.corp.doosan.com/");
		System.out.println(1);

		System.out.println(2);
		if (!selectOrgPage.verifyWelcomeText(wd,"b.shephard".trim())) {

			isBrowserAlive = "N";
			//wd.quit();
		}
		if (isBrowserAlive == "N") {

			selectOrgPage.searchByFirstDropdown("Brand");
			selectOrgPage.searchByContainingOptionDropdown("Doosan");
			selectOrgPage.clickSearchButton();
			selectOrgPage.clickFirstOrgLink(wd);

		}

		System.out.println("i am before compelted");
	}

	@Test(priority = 1)
	public void clickSearchInvoices() throws IOException {
		wd.findElement(By.linkText("Search Invoices")).click();
	
		if("Search Invoices".equals("Apache Tomcat/7.0.59 - Error report"))
		{
			
		} else {
			
			ReportGenerator.setLogAndCreateScreenshot("SearchInvoices~"+"firefox", Constants.DEFAULT_TESTNAME, localTestData, Constants.FAILED,"",wd);
			Assert.assertEquals("Search Invoices", "Apache Tomcat/7.0.59 - Error report");
		}

		
//		getAllLinksNameFromAllMakes(allMakesPage.Chains);
	//	isBrowserAlive = "A";
	}
}
