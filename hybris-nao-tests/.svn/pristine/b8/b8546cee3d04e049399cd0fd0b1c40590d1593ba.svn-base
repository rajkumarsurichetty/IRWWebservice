package com.doosan.pageFactoryHomePages;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;

public class AllMakesPageValidator extends TestInitializer {

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
			loginPage.enterPassword("Welcome3");
			loginPage.clickLoginButton();
			Thread.sleep(10000L);
		}

		//wd.get(PROJECT.getProperty("DoosanParts5URL"));
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
	public void VerifyChain() {
		homePage.clickAllMakes(wd);
		

		Assert.assertEquals("Chain", "Apache Tomcat/7.0.59 - Error report");
//		getAllLinksNameFromAllMakes(allMakesPage.Chains);
	//	isBrowserAlive = "A";
	}

	@Test(priority = 2,dependsOnMethods="VerifyChain",enabled=false)
	public void createOrdersWithAccessoriesAndRepair() {
		homePage.clickAllMakes(wd);
		Actions ac = new Actions(wd);
		ac.moveToElement(allMakesPage.Chains).build().perform();
		List<WebElement> l = allMakesPage.mouseOverWindow.findElements(By
				.tagName("li"));
		l.get(0).click();
		wd.findElement(By.xpath(".//*[@id='tableId']/tbody/tr[1]/td[1]/a"))
				.click();
		wd.findElement(By.xpath(".//*[@id='addToCard']")).click();
		wd.findElement(By.xpath("html/body/div[5]/div[3]/div/button[2]"))
				.click();
		isBrowserAlive = "A";
	}

	//
	// @Test(priority=2)
	// public void VerifyChemicalsAndSolvents()
	// {
	//
	// homePage.clickAllMakes(wd);
	// getAllLinksNameFromAllMakes(allMakesPage.ChemicalsAndSolvents);
	// isBrowserAlive="A";
	// }
	//

	@Test(priority = 3,dependsOnMethods="VerifyChain",enabled=false)
	public void VerifyDoosanAndGeithAttachments() {

		homePage.clickAllMakes(wd);
		getAllLinksNameFromAllMakes(allMakesPage.DoosanAndGeithAttachments);
		isBrowserAlive = "A";
	}

	@Test(priority = 4,dependsOnMethods="VerifyChain",enabled=false)
	public void VerifyHeavyDutyBatteries() {

		homePage.clickAllMakes(wd);
		getAllLinksNameFromAllMakes(allMakesPage.HeavyDutyBatteries);
		isBrowserAlive = "A";
	}

	@Test(priority = 5,dependsOnMethods="VerifyChain",enabled=false)
	public void VerifyGroundengaging() {

		homePage.clickAllMakes(wd);
		getAllLinksNameFromAllMakes(allMakesPage.Groundengaging);
		isBrowserAlive = "A";
	}

	@Test(priority = 6,dependsOnMethods="VerifyChain",enabled=false)
	public void VerifyImpactTools() {

		homePage.clickAllMakes(wd);
		getAllLinksNameFromAllMakes(allMakesPage.ImpactTools);
		isBrowserAlive = "A";
	}

	@Test(priority = 7,enabled=false)
	public void VerifyMerchandise() {

		homePage.clickAllMakes(wd);
		getAllLinksNameFromAllMakes(allMakesPage.Merchandise);
		isBrowserAlive = "A";
	}

	@Test(priority = 8,dependsOnMethods="VerifyChain",enabled=false)
	public void VerifyOringKits() {

		homePage.clickAllMakes(wd);
		getAllLinksNameFromAllMakes(allMakesPage.OringKits);
		isBrowserAlive = "A";
	}

	@Test(priority = 9,dependsOnMethods="VerifyChain",enabled=false)
	public void VerifyOildriProducts() {

		homePage.clickAllMakes(wd);
		getAllLinksNameFromAllMakes(allMakesPage.OildriProducts);
		isBrowserAlive = "A";
	}

	@Test(priority = 10,dependsOnMethods="VerifyChain",enabled=false)
	public void VerifyOilsAndFluids() {

		homePage.clickAllMakes(wd);
		getAllLinksNameFromAllMakes(allMakesPage.OilsAndFluids);
		isBrowserAlive = "A";
	}

	@Test(priority = 10,dependsOnMethods="VerifyChain",enabled=false)
	public void VerifyProtectiveTrackPads() {

		homePage.clickAllMakes(wd);
		getAllLinksNameFromAllMakes(allMakesPage.ProtectiveTrackPads);
		isBrowserAlive = "A";
	}

	@Test(priority = 10,dependsOnMethods="VerifyChain",enabled=false)
	public void VerifyRemanStartersAlternators() {

		homePage.clickAllMakes(wd);
		getAllLinksNameFromAllMakes(allMakesPage.RemanStartersAlternators);
		isBrowserAlive = "A";
	}

	@Test(priority = 10,enabled=false)
	public void VerifyRetailDisplaySolutions() {

		homePage.clickAllMakes(wd);
		getAllLinksNameFromAllMakes(allMakesPage.RetailDisplaySolutions);
		isBrowserAlive = "A";
	}

	@Test(priority = 11,dependsOnMethods="VerifyChain",enabled=false)
	public void VerifySeats() {

		homePage.clickAllMakes(wd);
		getAllLinksNameFromAllMakes(allMakesPage.Seats);
		isBrowserAlive = "A";
	}

	@Test(priority = 12,dependsOnMethods="VerifyChain",enabled=false)
	public void verifyShopTools() {
		homePage.clickAllMakes(wd);
		getAllLinksNameFromAllMakes(allMakesPage.ShopTools);
	}

	@Test(priority = 13,dependsOnMethods="VerifyChain",enabled=false)
	public void verifyUndercarriage() {
		homePage.clickAllMakes(wd);
		getAllLinksNameFromAllMakes(allMakesPage.Undercarriage);
	}

	@Test(priority = 14,dependsOnMethods="VerifyChain",enabled=false)
	public void verifyValvolineLubesAndCoolants() {
	homePage.clickAllMakes(wd);
		getAllLinksNameFromAllMakes(allMakesPage.ValvolineLubesAndCoolants);
	}

//	public void getAllLinksNameFromAllMakes(WebElement linkElement) {
//		Actions ac = new Actions(wd);
//		ac.moveToElement(linkElement).build().perform();
//		List<WebElement> l = allMakesPage.mouseOverWindow.findElements(By
//				.tagName("li"));
//		for (int i = 0; i < l.size(); i++) {
//			System.out.println(l.get(i).getText());
//		}
//
//	}
	
	public void getAllLinksNameFromAllMakes(WebElement linkElement) {
		
		Actions ac = new Actions(wd);
		ac.moveToElement(linkElement).build().perform();
		List<WebElement> l = linkElement.findElements(By.xpath("html/body/div[2]/div[4]/div[2]/div/div[1]/div/div[2]/div[2]/ul/li[2]/ul/li["));
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i).getText());
		}
	}
	
}
