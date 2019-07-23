package com.doosan.nao.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ItemUploadPage {
	@FindBy(linkText = "Enter Parts Manually")
	public WebElement enterpartsManually;

	public void clickManuallyEnterPartsButton() {
		enterpartsManually.click();
	}

	@FindBy(name = "entries[0].itemNumber")
	public WebElement enterItem;

	public void enterItemNumer(String itemNo) {
		this.enterItem.clear();
		this.enterItem.sendKeys(itemNo);
	}

	@FindBy(name = "entries[0].quantity")
	public WebElement quantity;

	public void enterQuantity(String qty) {
		this.quantity.clear();
		this.quantity.sendKeys(qty);
	}

	@FindBy(id="returnFormSubmit")
	public WebElement addToClaimButton;

	public void clickreturnFormSubmit() {

		this.addToClaimButton.click();
	}

	@FindBy(xpath = ".//*[@id='returnForm']/div/div[2]/p[1]")
	public WebElement error0;

	public boolean validateErrorQuantity() {
		boolean flag = false;
		String text = error0.getText();
		if (text.equals("")) {
			Assert.assertEquals(
					text,
					"Line 10: Invalid Quantity. Please enter a whole number greater than 0.",
					"Quantity enter is invalid and  Error message not match");
			flag = true;
		}
		return flag;
	}

}
