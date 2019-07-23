package com.doosan.nao.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.doosan.nao.init.TestInitializer;

public class SelectOrgPage {

	
	
		
	
	@FindBy(how=How.XPATH, using=".//*[@id='search_option1']")
	public WebElement searchByFirstDropdown;
	public void searchByFirstDropdown(String brand)
	{
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			
		}
		Select firstSelect=new Select(searchByFirstDropdown);
		firstSelect.selectByVisibleText(brand);
	}
	public void selectOptionFirstdropdown(EventFiringWebDriver wd,String selectOpt) {
		Select sel=new Select(searchByFirstDropdown);//City,KAMLOOPS ELK GROVE VILLAGE
		sel.selectByVisibleText(selectOpt);
	}
	
	/**
	 * @param wd
	 * This method for verify the first Drop down  is display
	 */
	public void verifyFirstDropDownisDisplayed(EventFiringWebDriver wd) {
		TestInitializer.highlightMyElement(searchByFirstDropdown, 3, wd);
		
		boolean fristdrpdon=searchByFirstDropdown.isDisplayed();
		Assert.assertEquals(fristdrpdon, true);
		
	}
	String SelectedFirstDrpValue;
			
	/**
	 * @param wd
	 * Verify the selected drop down value
	 */
	public void getSelectedOptionFrmFirstDropDown(EventFiringWebDriver wd) {
		TestInitializer.highlightMyElement(searchByFirstDropdown, 3, wd);
		Select sel=new Select(searchByFirstDropdown);
		SelectedFirstDrpValue=sel.getFirstSelectedOption().getText();
		Assert.assertEquals(SelectedFirstDrpValue, "Organization Name");
	}
	
	/**
	 * @param wd
	 * Get all Drop down values and verify
	 */
	public void getAllOptionFrmFirstDropDown(EventFiringWebDriver wd) {
		TestInitializer.highlightMyElement(searchByFirstDropdown, 3, wd);
		Select sel=new Select(searchByFirstDropdown);
		String string_Options;
		List<String> firstDropOptions = new ArrayList<>();
		List<WebElement>firstDropOptionEle=sel.getOptions();
		for (WebElement webElement : firstDropOptionEle) {
			string_Options=webElement.getText();
			firstDropOptions.add(string_Options);
		}
		System.out.println("First drop dowm options "+firstDropOptions);
		List<String>firstDropOptionsList= Arrays.asList( "alex", "brian", "charles");
		Assert.assertEquals(firstDropOptions,  Arrays.asList( "Organization Name", "Brand", "City","Customer Number","State/Province"));
	}
	
	List<String>first_DropDownOption;
	/**
	 * This method for getting for dropdown options values from first dropdown
	 */
	public void getAllDropDownValues() {
		first_DropDownOption=new ArrayList<>();
		Select firstSelect=new Select(searchByFirstDropdown);
		for (WebElement webElement : FistPagenateButton) {
			first_DropDownOption.add(webElement.getText());
		}
		System.out.println(first_DropDownOption);
		
		
	}
	
	WebElement disabled2drop;boolean flagdrop1=false;
	/**
	 * @param wd
	 * Verify the option is disabled 
	 */
	public void verifyOptionisDisabled2Drp(EventFiringWebDriver wd) {
		disabled2drop=wd.findElement(By.xpath("//select[@id='search_option2']/option[text()='"+SelectedFirstDrpValue+"' and @disabled]"));
		if(disabled2drop.isDisplayed()) {
			flagdrop1=true;
		}
		else {
			flagdrop1=false;
		}
		try {
		Assert.assertEquals(flagdrop1, true);
		}catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	@FindBy(xpath="//select[@id='search_val1_brand']")
	WebElement selectBrand;
	/**
	 * Thid method for selecting option from First drop down
	 */
	public void selectFirstDropDownValue(EventFiringWebDriver wd,String SelectVal) {
		Select firstSelect=new Select(selectBrand);
		firstSelect.selectByVisibleText(SelectVal);
	}

	
	public void getAllSearchBradValus(EventFiringWebDriver wd,String brand) {
		List<WebElement> allBrandEle=wd.findElements(By.xpath("//table[@id='organization_list']/tbody/tr/td/img[@src]"));
		for(int i=1;i<=allBrandEle.size();i++) {
			boolean f=wd.findElement(By.xpath("//table[@id='organization_list']/tbody/tr["+i+"]/td/img[@src]")).getAttribute("src").contains(brand.toLowerCase());
			Assert.assertEquals(f, true);
		}
		
	}
	
	
	@FindBy(how=How.XPATH, using="//input[@name='searchVal1']")
	public WebElement searchByFirstContainsTextBox;
	
	
	/**
	 * @param wd
	 * This method for verify the first Contains text box  is display
	 */
	public void verifyFirstContainsTextBox_isplayed(EventFiringWebDriver wd) {
		TestInitializer.highlightMyElement(searchByFirstContainsTextBox, 3, wd);
		
		boolean fristcontains=searchByFirstContainsTextBox.isDisplayed();
		Assert.assertEquals(fristcontains, true);
		
	}
	
	/**
	 * @param text
	 * This method for Enter text to Contains text box.
	 */
	public void enterTextFirstContainsBox(String text) {
		searchByFirstContainsTextBox.clear();
		searchByFirstContainsTextBox.sendKeys(text);
	}
	/**
	 * @param text
	 * This method for Enter text to second Contains text box.
	 */
	public void enterTextSecondContainsBox(String text) {
		searchBySecondContainsTextBox.clear();
		searchBySecondContainsTextBox.sendKeys(text);
	}
	/**
	 * @param wd
	 * This method for getting all row data and verify the search results
	 */
	List<String>orgaNames;
	public void verifyOrganizationSearchReasults(EventFiringWebDriver wd,String textToSearch) {
		orgaNames=new ArrayList<>();
		boolean flagOrgName=false;
		List<WebElement>tableRows=OrganizationListTableBody.findElements(By.tagName("tr"));
		for (int i=0;i<tableRows.size();i++) {
			List<WebElement> cols=tableRows.get(i).findElements(By.tagName("td"));
			
			orgaNames.add(cols.get(1).getText());
			String orgNm =cols.get(1).getText();
			if(orgNm.contains(textToSearch)) {
				flagOrgName=true;
			}else {
				flagOrgName=false;
			}
			if(flagOrgName==false) {
				break;
			}
		}
		System.out.println(orgaNames);
		
		
	}
	/**
	 * @param wd
	 * This method for getting all row city column data and verify the search results
	 */
	List<String>CitNames;
	public void verifyCitySearchReasults(EventFiringWebDriver wd,String textToSearch) {
		CitNames=new ArrayList<>();
		boolean flagOrgName=false;
		List<WebElement>tableRows=OrganizationListTableBody.findElements(By.tagName("tr"));
		for (int i=0;i<tableRows.size();i++) {
			List<WebElement> cols=tableRows.get(i).findElements(By.tagName("td"));
			
			CitNames.add(cols.get(5).getText());
			String orgNm =cols.get(5).getText();
			if(orgNm.toLowerCase().contains(textToSearch.toLowerCase())) {
				flagOrgName=true;
			}else {
				flagOrgName=false;
			}
			if(flagOrgName==false) {
				break;
			}
		}
		System.out.println(CitNames);
		
		
	}
	/**
	 * @param wd
	 * This method for getting all row customer data and verify the search results
	 */
	List<String>orgaCustNames;
	public void verifyOrganizationCustomerSearchReasults(EventFiringWebDriver wd,String textToSearch) {
		orgaCustNames=new ArrayList<>();
		boolean flagOrgName=false;
		List<WebElement>tableRows=OrganizationListTableBody.findElements(By.tagName("tr"));
		for (int i=0;i<tableRows.size();i++) {
			List<WebElement> cols=tableRows.get(i).findElements(By.tagName("td"));
			
			orgaCustNames.add(cols.get(4).getText());
			String orgNm =cols.get(4).getText();
			if(orgNm.contains(textToSearch)) {
				flagOrgName=true;
			}else {
				flagOrgName=false;
			}
			if(flagOrgName==false) {
				break;
			}
		}
		System.out.println(orgaCustNames);
		
		
	}
	/**
	 * @param wd
	 * This method for getting all row customer data and verify the search results
	 */
	//List<String>orgaCustNames;
	public void verifyOrganizationSearchReasultsZero(EventFiringWebDriver wd,String textToSearch) {
		orgaCustNames=new ArrayList<>();
		boolean flagOrgName=false;
		
			String orgNm =wd.findElement(By.xpath("//table[@id='organization_list']/tbody/tr/td")).getText();
			System.out.println(orgNm);
			if(orgNm.contains("No data available")) {
				flagOrgName=true;
			}else {
				flagOrgName=false;
			}
			Assert.assertEquals(flagOrgName, true);
		
		
		
	}
	@FindBy(how=How.XPATH, using=".//*[@id='search_option2']")
	public WebElement searchBySecondDropdown;
	/**
	 * @param wd
	 * This method for verify the searchBySecondDropDown is display
	 */
	public void verifyBySecondDropDown(EventFiringWebDriver wd)
	{
		TestInitializer.highlightMyElement(searchBySecondDropdown, 3, wd);
		
		boolean secondDrpdon=searchBySecondDropdown.isDisplayed();
		Assert.assertEquals(secondDrpdon, true);
	}
	
	String Selected2DrpValue;
		/**
		 * @param wd
		 * Verify the selected drop down value
		 */
		public void getSelectedOptionFrmSecondDropDown(EventFiringWebDriver wd) {
			TestInitializer.highlightMyElement(searchBySecondDropdown, 3, wd);
			Select sel=new Select(searchBySecondDropdown);
			Selected2DrpValue =sel.getFirstSelectedOption().getText();
			Assert.assertEquals(Selected2DrpValue, "Customer Number");
	}
		
		
		@FindBy(xpath="//select[@name='organization_list_length']")
		WebElement ResultPperPageDropDown;
		@FindBy(xpath="//div[@class='dataTables_info']")
		WebElement ResultPperPageShowText;
		String totrows;
		public void selectOptionResultDropdown(EventFiringWebDriver wd,String selectOpt) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
			String []strShow_Text=ResultPperPageShowText.getText().split(" ");
			String totRowsGrid=strShow_Text[6];
			int totgrid;
			if(totRowsGrid.contains(",")) {
			totgrid=Integer.parseInt(totRowsGrid.replaceAll(",", ""));
			}else {
				totgrid=Integer.parseInt(totRowsGrid);
			}
			Select sel=new Select(ResultPperPageDropDown);
			List<WebElement>list=sel.getOptions();
			
			//for (WebElement webElement : list) {
				//String opt=webElement.getText();
				if(totgrid>20 && totgrid<=50) {
				sel.selectByVisibleText("20");
				try {
					Thread.sleep(20000L);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				//int optint=Integer.parseInt(opt);
				int totlRows=wd.findElements(By.xpath("//table[@id='organization_list']/tbody/tr")).size();
				Assert.assertEquals(totlRows, 20);
				}else if (totgrid>50 && totgrid<=100){
					sel.selectByVisibleText("50");
					try {
						Thread.sleep(20000L);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					//int optint=Integer.parseInt(opt);
					int totlRows=wd.findElements(By.xpath("//table[@id='organization_list']/tbody/tr")).size();
					Assert.assertEquals(totlRows, 50);
					System.out.println("Total");
				}else if(totgrid>100) {
					sel.selectByVisibleText("100");
					try {
						Thread.sleep(20000L);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					//int optint=Integer.parseInt(opt);
					int totlRows=wd.findElements(By.xpath("//table[@id='organization_list']/tbody/tr")).size();
					Assert.assertEquals(totlRows, 100);
				}else {
					int totlRows=wd.findElements(By.xpath("//table[@id='organization_list']/tbody/tr")).size();
					System.out.println("Total"+totlRows);
					Assert.assertEquals(totlRows<20, true);
				}
			}
		//}
		/**
		 * @param wd
		 * Verify the get all options are displayed 
		 */
		public void getAllOptionFrmSecondDropDown(EventFiringWebDriver wd) {
			TestInitializer.highlightMyElement(searchBySecondDropdown, 3, wd);
			Select sel=new Select(searchBySecondDropdown);
			String string_Options;
			List<String> secondDropOptions = new ArrayList<>();
			List<WebElement>secondDropOptionEle=sel.getOptions();
			for (WebElement webElement : secondDropOptionEle) {
				string_Options=webElement.getText().trim();
				secondDropOptions.add(string_Options);
			}
			System.out.println("Second drop dowm options "+secondDropOptions);
			//List<String>firstDropOptionsList= Arrays.asList( "alex", "brian", "charles");
			Assert.assertEquals(secondDropOptions,  Arrays.asList( "Customer Number", "Brand", "Organization Name","City","State/Province"));
		}
	
		
		WebElement disabled1drop;boolean flagdrop2=false;
		/**
		 * @param wd
		 * Verify the Option is disabled in 1 dropdown
		 */
		public void verifyOptionisDisabled1Drp(EventFiringWebDriver wd) {
			disabled1drop=wd.findElement(By.xpath("//select[@id='search_option1']/option[text()='"+Selected2DrpValue+"' and @disabled]"));
			if(disabled2drop.isDisplayed()) {
				flagdrop2=true;
			}
			else {
				flagdrop2=false;
			}
			try {
			Assert.assertEquals(flagdrop1, true);
			}catch (Exception e){
				System.out.println(e.toString());
			}
		}
		
		
		@FindBy(how=How.XPATH, using="//input[@name='searchVal2']")
	public WebElement searchBySecondContainsTextBox;
	/**
	 * @param wd
	 * This method for verify the Second Contains text box is display
	 */
	public void verifyBySecondcontainsTextBox(EventFiringWebDriver wd)
	{
		TestInitializer.highlightMyElement(searchBySecondContainsTextBox, 3, wd);
		
		boolean secondcontains=searchBySecondContainsTextBox.isDisplayed();
		Assert.assertEquals(secondcontains, true);
	}

	
	
	
	/**
	 * @param wd
	 * This method for verify the searchButtonOrgPage is display
	 */
	public void verifySearchButton(EventFiringWebDriver wd) {
		TestInitializer.highlightMyElement(searchButtonOrgPage, 3, wd);
		
		boolean searchButton=searchButtonOrgPage.isDisplayed();
		Assert.assertEquals(searchButton, true);
	}
	
	@FindBy(xpath="//select[@name='organization_list_length']")
	List<WebElement>ResultsperpageDropDown;
	/**
	 * @param wd
	 * This method for verify the Results per page DropDown is display
	 */
	public void verifyResultsperpageDropDown(EventFiringWebDriver wd) {
		
		for (WebElement webElement : ResultsperpageDropDown) {
			TestInitializer.highlightMyElement(webElement, 3, wd);
			boolean perpage=webElement.isDisplayed();
			Assert.assertEquals(perpage, true);
		}
		
	}
	@FindBy(xpath="//a[contains(@class,'first paginate_button paginate_button_disabled')]")
	List<WebElement>FistPagenateButton;
	/**
	 * @param wd
	 * This method for verify theFistPagenateButton is display
	 */
	public void verifyFistPagenateButtonIsDispaly(EventFiringWebDriver wd) {
		
		for (WebElement webElement : FistPagenateButton) {
			TestInitializer.highlightMyElement(webElement, 3, wd);
			boolean fistpageBtn=webElement.isDisplayed();
			Assert.assertEquals(fistpageBtn, true);
		}
	}
	
	@FindBy(xpath="//a[contains(@class,'previous paginate_button paginate_button_disabled')]")
	List<WebElement>previousPagenateButton;
	/**
	 * @param wd
	 * This method for verify thePreviousPagenate Button is display
	 */
	public void verifyPreviousPagenateButtonIsDispaly(EventFiringWebDriver wd) {
		
		for (WebElement webElement : previousPagenateButton) {
			TestInitializer.highlightMyElement(webElement, 3, wd);
			boolean previousBtn=webElement.isDisplayed();
			Assert.assertEquals(previousBtn, true);
		}
	}
	
	
	
	
	
	
	@FindBy(xpath="//a[contains(@class,'next paginate_button')]")
	List<WebElement>nextPagenateButton;
	/**
	 * @param wd
	 * This method for verify the Next Pagenate Button is display
	 */
	public void verifyNextPagenateButtonIsDispaly(EventFiringWebDriver wd) {
		
		for (WebElement webElement : nextPagenateButton) {
			TestInitializer.highlightMyElement(webElement, 3, wd);
			boolean nextBtn=webElement.isDisplayed();
			Assert.assertEquals(nextBtn, true);
		}
	}
	
	@FindBy(xpath="//a[contains(@class,'next paginate_button')]")
	List<WebElement>lastPagenateButton;
	/**
	 * @param wd
	 * This method for verify the last Pagenate Button is display
	 */
	public void verifyLastPagenateButtonIsDispaly(EventFiringWebDriver wd) {
		
		for (WebElement webElement : lastPagenateButton) {
			TestInitializer.highlightMyElement(webElement, 3, wd);
			boolean lastBtn=webElement.isDisplayed();
			Assert.assertEquals(lastBtn, true);
		}
	}
	
	@FindBy(xpath="//div[contains(@class,'dataTables_info')]")
	List<WebElement>showingResults ;
	/**
	 * @param wd
	 * This method for verify the Showing Results text is display
	 */
	public void verifyShowingResultsIsDispaly(EventFiringWebDriver wd) {
		Actions act=new Actions(wd);
		for (WebElement webElement : showingResults) {
			WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 300);
			waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(webElement));
			act.moveToElement(webElement).build().perform();
			
			TestInitializer.highlightMyElement(webElement, 3, wd);
			boolean showResult=webElement.isDisplayed();
			Assert.assertEquals(showResult, true);
		}
	}
	
	@FindBy(xpath="//table[@id='organization_list']")
	WebElement OrganizationListTable;
	
	@FindBy(xpath="//table[@id='organization_list']/thead")
	WebElement OrganizationListTableHeader;
	
	@FindBy(xpath="//table[@id='organization_list']/tbody")
	WebElement OrganizationListTableBody;
	
	@FindBy(xpath="//table[@id='organization_list']/tbody/tr/td[@class='dataTables_empty']")
	WebElement OrganizationListTableBodyRowDataEmpty;
	
	@FindBy(xpath="//table[@id='organization_list']/tbody/tr[@class='odd' or @class='even']")
	WebElement OrganizationListTableBodyRowDataAvailable;
	
	@FindBy(xpath="//table[@id='organization_list']/tbody/tr")
	WebElement OrganizationListTableBodyRows;
	/**
	 * @param wd
	 * This method for verify the Organization List Table is display
	 */
	public void verifyOrganizationListTableIsDisplay(EventFiringWebDriver wd) {
		TestInitializer.highlightMyElement(OrganizationListTable, 3, wd);
		
		boolean orgTable=OrganizationListTable.isDisplayed();
		Assert.assertEquals(orgTable, true);
	}
	
	/**
	 * @param wd
	 * This method for verify the Organization List Table Header is display
	 */
	public void verifyOrganizationListTableHeaderIsDisplay(EventFiringWebDriver wd) {
		TestInitializer.highlightMyElement(OrganizationListTableHeader, 3, wd);
		
		boolean orgTableHeader=OrganizationListTableHeader.isDisplayed();
		Assert.assertEquals(orgTableHeader, true);
	}
	
	
	@FindBy(xpath="//*[@id=\"organization_list\"]/thead/tr/th")
	List<WebElement>OrgTblHeaderEle;
	/**
	 * This for Getting the Table Header text for each column.
	 */
	public void getAllTableHeaderCoulumnsDisplay() {
		
		for (WebElement OrgTblHeaderVal : OrgTblHeaderEle) {
			
			System.out.println(" Orgnization Header Columns Names > "+OrgTblHeaderVal.getText());
		}
		
	}
	
	/**
	 * @param wd
	 * This method for verify the Organization List Table Body is display
	 */
	public void verifyOrganizationListTableBodyIsDisplay(EventFiringWebDriver wd) {
		TestInitializer.highlightMyElement(OrganizationListTableBody, 3, wd);
		
		boolean orgtableBody=OrganizationListTableBody.isDisplayed();
		Assert.assertEquals(orgtableBody, true);
	}
	
	
	
	/**
	 * @param wd
	 * This method for verify the Organization List Table Body data rows is display
	 */
	public void verifyOrganizationListTableBodyDataIsDisplay(EventFiringWebDriver wd) {
		TestInitializer.highlightMyElement(OrganizationListTableBodyRowDataAvailable, 3, wd);
		
		boolean orgtableBodyRow=OrganizationListTableBodyRowDataAvailable.isDisplayed();
		Assert.assertEquals(orgtableBodyRow, true);
	}
	
	
	
	/**
	 * @param wd
	 * This method for verify the Organization List Table Body rows data is empty 
	 */
	public void verifyOrganizationListTableBodyDataIsEmpty(EventFiringWebDriver wd) {
		TestInitializer.highlightMyElement(OrganizationListTableBodyRowDataEmpty, 3, wd);
		
		boolean orgtableBodyisEmpty=OrganizationListTableBodyRowDataEmpty.isDisplayed();
		Assert.assertEquals(orgtableBodyisEmpty, true);
	}
	
	
	
	
	@FindBy(xpath="//*[@id=\"organization_list_paginate\"]/a")
	List<WebElement> paginationButtonstElements;
	
	@FindBy(xpath="//*[@id=\"organization_list_paginate\"]/span/a")
	List<WebElement> paginationNumButtonstElements;
	
	public void getAllPaginationElementsFromTop() {
		
		for (WebElement webElement : paginationButtonstElements) {
			System.out.println(" Pagination  Buttons Text "+webElement.getText());
			
		}
		System.out.println();
		for (WebElement webElement : paginationNumButtonstElements) {
			System.out.println(" Pagination Numbers Buttons Text "+webElement.getText());
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[2]/td[3]/input")
	public WebElement enterCustomerNumber;
	public void searchByContainingOptionDropdown(String brand)
	{
		Select firstSelect=new Select(searchByBrand);
		firstSelect.selectByVisibleText(brand);
	}

	@FindBy(how=How.XPATH, using="html/body/div[2]/div[3]/div/div[3]/form/table/tbody/tr[1]/td[3]/select")
	public WebElement searchByBrand;
	public void enterCustomerNo(String customerNo)
	{
		this.enterCustomerNumber.clear();
		this.enterCustomerNumber.sendKeys(customerNo);
	}

	@FindBy(how=How.XPATH, using="//table[@id='organization_list']/tbody/tr[1]/td[2]/a")
	public WebElement firstOrgLinkInSearchResultpage;
	public void clickFirstOrgLink(WebDriver wd)
	{
		WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 300);
		waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(firstOrgLinkInSearchResultpage));
		this.firstOrgLinkInSearchResultpage.click();
		System.out.println(" Org linked ");
		
	}
	
	
	
	@FindBy(how=How.XPATH, using="html/body/div[2]/div[3]/div/div[3]/form/button")
	public WebElement searchButtonOrgPage;
	/**
	 * This method for verify the clicking searchButton
	 */
	public void clickSearchButton()
	{
		this.searchButtonOrgPage.click();
	}
	
	
	
	
	
	
	
	@FindBy(how=How.ID,using="userinfo")
	public WebElement welcomeTextw;
	public boolean verifyWelcomeText(EventFiringWebDriver wd,String welcomeText)
	{WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 300);
	waitForFirstOrgLink.until(ExpectedConditions.visibilityOf(welcomeTextw));
		System.out.println(welcomeText);
		System.out.println(welcomeText.substring(welcomeText.length()-5));
		
		return this.welcomeTextw.getText().contains(welcomeText.substring(welcomeText.length()-5));
	}
	
	
	
	
}
