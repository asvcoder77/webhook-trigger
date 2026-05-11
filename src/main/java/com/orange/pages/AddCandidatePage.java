package com.orange.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.orange.base.BasePage;

public class AddCandidatePage extends BasePage{
	
	@FindBy (css="h6.orangehrm-main-title")
	private WebElement addcandidatetitle;
	
	@FindBy (css="input[placeholder='First Name']")
	private WebElement firstname;
	
	@FindBy (css="input[placeholder='Last Name']")
	private WebElement lastname;
	
	@FindBy (xpath="(//input[@placeholder='Type here'])[1]")
	private WebElement email;
	
	@FindBy (xpath="(//input[@placeholder='Type here'])[2]")
	private WebElement number;
	
	@FindBy (css="input[placeholder='Enter comma seperated words...']")
	private WebElement keyword;
	
	@FindBy(css="span.oxd-checkbox-input")
	private WebElement consent;
	
	@FindBy(xpath="(//i)[6]")
	private WebElement vacancy;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement save;

	@Override
	public boolean isAt() {
		wait.until(ExpectedConditions.visibilityOf(addcandidatetitle));
		return addcandidatetitle.isDisplayed();
	}
	
	public void enterNameEmailNumberKeyword(String fname,String lname,String eml,String nmbr) {
		wait.until(ExpectedConditions.visibilityOf(firstname)).sendKeys(fname);
		wait.until(ExpectedConditions.visibilityOf(lastname)).sendKeys(lname);
		wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(eml);
		wait.until(ExpectedConditions.visibilityOf(number)).sendKeys(nmbr);
	}
	
	public void selectVacancy() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(vacancy));
		vacancy.click();
		List<WebElement>vacancies=wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("div[role='option']"),3));
		System.out.println(vacancies.size());
		vacancies.get(2).click();
		scrollToBottom();
		
	}
	public void clickConsent() {
		wait.until(ExpectedConditions.visibilityOf(consent)).click();
		
	}
	public void clickSave() {
		wait.until(ExpectedConditions.visibilityOf(save)).click();
		
	}

}
