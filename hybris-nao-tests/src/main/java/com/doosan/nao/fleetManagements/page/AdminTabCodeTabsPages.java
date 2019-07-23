package com.doosan.nao.fleetManagements.page;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author rajkumars
 *
 */

public class AdminTabCodeTabsPages {
	
	/**
	 * @param wd
	 * @param ele
	 * @param time
	 * This method for wait element 
	 */
	public void waitMethod(EventFiringWebDriver wd ,WebElement ele,int time){
		WebDriverWait wait=new WebDriverWait(wd, time);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	@FindBy(xpath="//span[text()='Add a New Comment']")
	WebElement addCommentLink;
	
	/**
	 * @param wd
	 * Thid method for verifyAddComnetLink
	 */
	public void verifyAddComnetLink(EventFiringWebDriver wd){
		boolean flag;
		//WebDriverWait wait=new WebDriverWait(wd, 120);
		//wait.until(ExpectedConditions.elementToBeClickable(addCommentLink));
		waitMethod(wd, addCommentLink, 200);
		flag=addCommentLink.isDisplayed();
		Assert.assertEquals(flag, true);
	}
	/**
	 * @param wd
	 * This method for clicking Add a new comment
	 */
	public void clickAddCommentLink(EventFiringWebDriver wd){
		WebDriverWait waitForFirstOrgLink=new WebDriverWait(wd, 200);
		waitForFirstOrgLink.until(ExpectedConditions.elementToBeClickable(addCommentLink));
		try {
			Thread.sleep(10000);
			highlightMyElement(addCommentLink, 3, wd);
			JavascriptExecutor jse = (JavascriptExecutor) wd;
			 
			   // WebElement element = wd.findElement(By.linkText("Google.com.ph"));
			    jse.executeScript("arguments[0].scrollIntoView();", addCommentLink);
			addCommentLink.click();
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@FindBy(xpath="//h3/span")
	WebElement headerOfNewComment;
	/**
	 * @param wd
	 * This method for verifying Header of new comment pop up 
	 */
	public void headerNewComments(EventFiringWebDriver wd){
		waitMethod(wd, headerOfNewComment, 120);
		headerOfNewComment.isDisplayed();
		String headerNewComment=headerOfNewComment.getText();
		System.out.println(headerNewComment);
		
	}
	/**
	 * This method for enter new comments 
	 */
 @FindBy(xpath="//textarea[@ng-model='$ctrl.comment']")
	WebElement enterTextInTextArea;
	String newEnterComment;
	
	public void enterNewcomments(){ 
	    DateFormat sdf;
		sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		// System.out.println(sdf.format(date));
		String da = sdf.format(date);
		newEnterComment="AutoTestComment:"+da.replaceAll("[/,:]", "").replace(" ", "");
		enterTextInTextArea.sendKeys(newEnterComment);
	}
	
	@FindBy(xpath="//a[@ng-click='$ctrl.showHistory($ctrl.comments)']")
	WebElement totalFullcommentsHistory;
	/**
	 * @param wd
	 * @return
	 * This method for verifying total comments in grid
	 */
	public String verifyTotalComments(EventFiringWebDriver wd){
		String totalFullcommHistory;String totComHistory = null;
		
		try {
			boolean f=totalFullcommentsHistory.isDisplayed();
			if(f==true){
			 totalFullcommHistory=totalFullcommentsHistory.getText();
			 totComHistory=totalFullcommHistory.replaceAll("[a-zA-Z,(),\\W]", "");
			}else{
				System.out.println("Total comments rows less than 5");
				int totalrowComments=getTableRows(wd);
				totComHistory=String.valueOf(totalrowComments);
			}
		} catch (Exception e) {
			System.out.println("Total comments rows less than 5");
			int totalrowComments=getTableRows(wd);
			totComHistory=String.valueOf(totalrowComments);
		}
		return totComHistory;
	}
	/**
	 * This method for clicking comment history link
	 */
	public void clickFullCommentHistoryLink(){
		totalFullcommentsHistory.click();
	}
	@FindBy(xpath="//button[@ng-click='$ctrl.onSave($ctrl.comment)']")
	WebElement saveNewcomments;
	
	/**
	 * This method for clicking save button on new comment  pop up
	 */
	public void clickSaveNewComment(EventFiringWebDriver wd){
		
		try {
			wd.switchTo().defaultContent();
			JavascriptExecutor jse = (JavascriptExecutor) wd;
			jse.executeScript("scroll(0,-250);", "");
			jse.executeScript("scroll(0,450);", "");
			wd.switchTo().frame(frameId);
			saveNewcomments.click();
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			
		}
	}
	@FindBy(xpath="//button[@ng-click='$ctrl.close()']/span")
	WebElement clickCacelNewComm;
	
	/**
	 * This method for clicking cancel button on new comment popup 
	 */
	@FindBy(how=How.ID,using="fleetmanagementApp")
	public WebElement frameId;
	public void clickCancelNewcommentPopup(EventFiringWebDriver wd){
		try {
		//highlightMyElement(clickCacelNewComm, 3, wd);
		JavascriptExecutor jse = (JavascriptExecutor) wd;
		wd.switchTo().defaultContent();
		jse.executeScript("scroll(0,-250);", "");
		jse.executeScript("scroll(0,450);", "");
		   // WebElement element = wd.findElement(By.linkText("Google.com.ph"));
		wd.switchTo().frame(frameId);
		   // jse.executeScript("arguments[0].scrollIntoView();", clickCacelNewComm);
		clickCacelNewComm.click();
		
			Thread.sleep(3000);
		} catch (Exception e) {
			
		}
	}
	@FindBy (xpath="//h3[text()='Comments History']")
	WebElement commentHistoryPopup;
	/**
	 * This method for verifying the header of full comment history popup
	 */
	public void verifyHeaderfullCommentHistoryPopup(){
		boolean flag=commentHistoryPopup.isDisplayed();
	}
	/**
	 * @param wd
	 * This method for getting total rows in full history pop up
	 */
	public void totalRowsinFullCommentsHistory(EventFiringWebDriver wd){
		int totalrowComments=getTableRows(wd);
		System.out.println(totalrowComments);
		
	}
	@FindBy(xpath="//button[@ng-click='$ctrl.close()']")
	WebElement closeCommentPopup;
	/**
	 * @param wd
	 * This method for clicking close button on full history pop up
	 */
	public void clickCloseButtonCommentPopup(EventFiringWebDriver wd){
		try {
			highlightMyElement(closeCommentPopup, 3, wd);
			closeCommentPopup.click();
		} catch (Exception e) {
			
		}
	}
	int before;
	/**
	 * @param wd
	 * This method for getting total row before delete row comment
	 */
	public void beforeDeletCommentTotal(EventFiringWebDriver wd){
		String bef=verifyTotalComments(wd);
		System.out.println();
		before=Integer.parseInt(bef.trim());
	}
	int after;
	/**
	 * @param wd
	 * This method for getting total row after delete row comment
	 */
	public void afterDeletCommentTotal(EventFiringWebDriver wd){
		String aft=verifyTotalComments(wd);
		System.out.println();
		after=Integer.parseInt(aft.trim());
	}
	
	@FindBy(xpath="//table[@st-safe-src='$ctrl.comments']/tbody/tr/td[2]/input")
	WebElement deleteIcon;
	/**
	 * @param wd
	 * This method for clicking delete icon for deleting comment row
	 */
	public void clickdeleteCommentButtonIcon(EventFiringWebDriver wd){
		try {
			highlightMyElement(deleteIcon, 3, wd);
			deleteIcon.click();
			Thread.sleep(8000);
		} catch (Exception e) {
			
		}
	}
	/**
	 * @param wd
	 * This method for verifying before and after deleting comment
	 */
	public void verifyBeforeAndAfterDeleteComments(EventFiringWebDriver wd){
		boolean f = false;
		afterDeletCommentTotal(wd);
		if(before>after){
		f=true;
		}
		try {
			Assert.assertEquals(f, true);
		} catch (AssertionError e) {
			System.out.println("Delet not done");
		}
		
	}
	
	@FindBy(xpath="//table[@st-safe-src='$ctrl.comments']/tbody/tr[contains(@ng-if,'$ctrl.comments.length')]/td/span")
	WebElement noComments;
	public boolean noCommnetFlag= false;
	/**
	 * @return
	 * Thid method for Verifying  No comment on grid
	 */
	public boolean verifyNoCommnets(){
		try {
			noCommnetFlag=noComments.isDisplayed();
			System.out.println(" Commnets grid : "+noComments.getText());
			
		} catch (Exception e) {
			System.out.println("Commmnets available");
			falgCommentrowcheck=false;
		}
		return noCommnetFlag;
	}
	@FindBy(xpath="//table[@st-safe-src='$ctrl.comments']/tbody/tr/td[2]/input")
	WebElement rowCommentsAvail;
	boolean falgCommentrowcheck=false;
	public void checktableRowsComments(){
		try {
			falgCommentrowcheck=rowCommentsAvail.isDisplayed();
			falgCommentrowcheck=true;
		} catch (Exception e) {
			
			falgCommentrowcheck=false;
		}
	}
	String Cooments;
	List<String>commentList;
	/**
	 * @param wd
	 * This method for verifying the comment added on grid or not
	 */
	public void verifyNewCommentAddedOrNot(EventFiringWebDriver wd){
		commentList=new  ArrayList<String>();
		
		checktableRowsComments();
		waitMethod(wd, addCommentLink, 200);
		if((falgCommentrowcheck==true)){
			int totalrows=getTableRows(wd);
			List<WebElement> commRow=tableComments.findElements(By.tagName("tr"));
			for (int i = 0; i <commRow.size() ; i++) {
				List<WebElement> commCol=tableComments.findElements(By.tagName("td"));
				WebElement col2=wd.findElement(By.xpath("//table[@st-safe-src='$ctrl.comments']/tbody/tr["+(i+1)+"]/td[2]"));
				Cooments=col2.getText();
				commentList.add(Cooments);
			}
			System.out.println(commentList);
		}
	}
	/**
	 * This method for comment available or not
	 */
	boolean flagCommentAvail;
	public void verifycommentAvailableInList(){
		flagCommentAvail=false;
		flagCommentAvail=commentList.contains(newEnterComment);
		Assert.assertEquals(flagCommentAvail, true);
	}
	
	boolean flagCommentAvailforAnoterDealer;
	public void verifycommentAvailableInListforAnoterDealer(){
		flagCommentAvailforAnoterDealer=false;
		flagCommentAvailforAnoterDealer=commentList.contains(newEnterComment);
		Assert.assertEquals(flagCommentAvailforAnoterDealer, false);
	}
	@FindBy(xpath="//table[@st-safe-src='$ctrl.comments']/tbody")
	WebElement tableComments;
	int totalRowsInCommentTable;
	/**
	 * @param wd
	 * @return
	 * This method for getting table  total rows comments 
	 */
	public int getTableRows(EventFiringWebDriver wd){
		List<WebElement> commRow=tableComments.findElements(By.tagName("tr"));
		totalRowsInCommentTable=commRow.size();
		System.out.println("Total Comment in grid : "+totalRowsInCommentTable);
		for (int i = 0; i <commRow.size() ; i++) {
			List<WebElement> commCol=tableComments.findElements(By.tagName("td"));
		}
		return totalRowsInCommentTable;
	}
	
	public  void highlightMyElement(WebElement element, int waitSeconds, EventFiringWebDriver webdriver)
			throws IOException {
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

}
