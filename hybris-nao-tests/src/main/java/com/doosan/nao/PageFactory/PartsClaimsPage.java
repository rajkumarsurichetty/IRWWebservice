package com.doosan.nao.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartsClaimsPage {

	
	@FindBy(id="surplusReturnButton")
	WebElement surplus;
	public void clickSurplusReturns(){
		surplus.click();
	}
}
