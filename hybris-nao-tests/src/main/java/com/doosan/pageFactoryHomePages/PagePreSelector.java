package com.doosan.pageFactoryHomePages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.doosan.nao.PageFactory.CheckPriceAndAvailabityPage;
import com.doosan.nao.PageFactory.HomePage;
import com.doosan.nao.PageFactory.LoginPage;
import com.doosan.nao.PageFactory.SelectOrgPage;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;

public class PagePreSelector extends TestInitializer {

	public HomePage homePage;
	public LoginPage  loginPage;
	public SelectOrgPage  selectOrgPage;
	public CheckPriceAndAvailabityPage  checkPriceAndAvailabityPage;
	

	public void initializePrePageSelector(EventFiringWebDriver wd)
	{
		initializePrePageSelector(wd);
		homePage=PageFactory.initElements(wd, HomePage.class);
		loginPage=PageFactory.initElements(wd, LoginPage.class);
		selectOrgPage=PageFactory.initElements(wd, SelectOrgPage.class);
		checkPriceAndAvailabityPage=PageFactory.initElements(wd, CheckPriceAndAvailabityPage.class);
	}
	
	public void selectHomePage(EventFiringWebDriver wd, String isBrowserAlive) throws IOException, URISyntaxException, InterruptedException
	{
		homePage=PageFactory.initElements(wd, HomePage.class);
		loginPage=PageFactory.initElements(wd, LoginPage.class);
		selectOrgPage=PageFactory.initElements(wd, SelectOrgPage.class);
		checkPriceAndAvailabityPage=PageFactory.initElements(wd, CheckPriceAndAvailabityPage.class);
		
		if (isBrowserAlive=="N")
		{
		wd=WebdriverSelector.getDriver(wd, "firefox");
		
		initialize("firefox", "", "","");
		
			wd.get(PROJECT.getProperty("DoosanPassportURL"));
		}
				
		  
			if(isBrowserAlive=="N")
			{		
				
			loginPage.enterUserName("b.shephard");
			loginPage.enterPassword("Welcome1");
			loginPage.clickLoginButton();
			Thread.sleep(10000L);
			}
			
			wd.get(PROJECT.getProperty("DoosanParts5URL"));
			System.out.println(1);
			
			System.out.println(2);
			if (!selectOrgPage.verifyWelcomeText(wd,"b.shephard".trim()))
			{
				
				isBrowserAlive="N";
				wd.quit();
			}
			if(isBrowserAlive=="N")
			{

			selectOrgPage.searchByFirstDropdown("Brand");
			selectOrgPage.searchByContainingOptionDropdown("Doosan");
			selectOrgPage.clickSearchButton();
			selectOrgPage.clickFirstOrgLink(wd);
			

			}
	}
}
