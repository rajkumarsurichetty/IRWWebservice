package com.doosan.pageFactoryHomePages;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.doosan.nao.constants.Constants;
import com.doosan.nao.init.TestInitializer;
import com.doosan.nao.init.WebdriverSelector;

public class ClaimsPageValidator extends TestInitializer {

	public static EventFiringWebDriver wd = null;

	public static void main(String[] args) throws InterruptedException,
			IOException, URISyntaxException {
		// TODO Auto-generated method stub

		wd = WebdriverSelector.getDriver(wd, "firefox");

		initialize("firefox", "", "", "");
		wd.get(PROJECT.getProperty("DoosanPassportURL"));
		getWebElement(Constants.LOGIN_PAGE_USERNAME_TEXT_X_PATH, wd).sendKeys(
				"priyar");
		getWebElement(Constants.LOGIN_PAGE_PASSWORD_TEXT_X_PATH, wd).sendKeys(
				"Welcome1");
		getWebElement(Constants.LOGIN_PAGE_SUBMIT_BUTTON_X_PATH, wd).submit();
		Thread.sleep(10000L);
		wd.navigate().to(PROJECT.getProperty("DoosanParts5URL"));
		WebDriverWait waitForSearchByDropdown = new WebDriverWait(wd, 600);
		waitForSearchByDropdown
				.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[2]/select")));

		Select selectBrand = new Select(
				wd.findElement(By
						.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[2]/select")));
		selectBrand.selectByVisibleText("Brand");

		WebDriverWait waitForOrgSection = new WebDriverWait(wd, 600);
		waitForOrgSection
				.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")));

		Select selectBrandByInput = new Select(
				wd.findElement(By
						.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")));
		selectBrandByInput.selectByVisibleText("Doosan");
		// wd.findElement(By.xpath("html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[2]/td[3]/input")).sendKeys("0001166428");
		wd.findElement(
				By.xpath("html/body/div[2]/div[3]/div/div[3]/form/button"))
				.click();

		WebDriverWait waitForFirstOrgLink = new WebDriverWait(wd, 600);
		waitForFirstOrgLink
				.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a")));

		wd.findElement(
				By.xpath("html/body/div[2]/div[3]/div/div[3]/div[2]/table/tbody/tr[1]/td[2]/a"))
				.click();
		wd.findElement(By.linkText("Create a New Parts Claim")).click();
		wd.findElement(By.id("sdrButton")).click();

		WebElement drop = wd.findElement(By.id("pastdays_select"));
		Select selc = new Select(drop);
		selc.selectByIndex(3);
		wd.findElement(By.id("search_btn")).click();
		WebDriverWait waitForFirstOrgLink1 = new WebDriverWait(wd, 600);
		waitForFirstOrgLink1
				.until(ExpectedConditions.presenceOfElementLocated(By
						.xpath("html/body/div[2]/div[2]/div[2]/div[4]/div/table/tbody/tr[1]/td[1]/a")));

		wd.findElement(By.className("active_btn")).click();
		wd.findElement(
				By.xpath("html/body/div[2]/div[2]/form/div[6]/div[4]/div[2]/table/tbody/tr[1]/td[1]/input[1]"))
				.click();
		WebElement drop1 = wd.findElement(By.name("formEntries[0].reasonCode"));
		Select sel = new Select(drop1);
		List<WebElement> l = sel.getOptions();
		ArrayList<String> arra=new ArrayList<String>();
		for (int i = 1; i < l.size(); i++) {
			String data = l.get(i).getText();
			System.out.println(" Options are :"+data);			
			sel.selectByIndex(i);
			//WebElement answer=wd.findElement(By.className("answer_td"));
			List<WebElement> options = wd.findElements(By
					.className("question_name"));
		
			//options.removeAll(Collections.singleton(null));
			for (int j = 0; j < options.size(); j++) {
				
				String test=options.get(j).getText();
				if(options.get(j).isDisplayed())
				{
					System.out.println(test);
				}
				
				
			}

		}
		

	}


}
