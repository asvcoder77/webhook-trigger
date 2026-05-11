package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.orange.base.BasePage;

public class DashboardPage extends BasePage{
	
	@FindBy(css="button[size='large']")
	private WebElement upgradebutton;
	
	@FindBy(css="a[href='http://www.orangehrm.com']")
	private WebElement bottemlink;
	
	@FindBy(css="button.oxd-icon-button--solid-main")
	private WebElement time;
	
	@FindBy(css="a[href='/web/index.php/recruitment/viewRecruitmentModule']")
	private WebElement recruitment;
	

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.elementToBeClickable(upgradebutton));
		return this.upgradebutton.isDisplayed();
	}
	
	public void scrollToDown() throws InterruptedException {
		scrollToBottom();
	}
	
	public boolean isBottemLinkVisible() {
		return wait.until(ExpectedConditions.visibilityOf(bottemlink)).isDisplayed();
		
	}
	public TimePage clickTimeButton() {
		wait.until(ExpectedConditions.elementToBeClickable(time)).click();
		return new TimePage();
		
	}
	public RecruitmentPage clickRecruitmentOption() {
		wait.until(ExpectedConditions.elementToBeClickable(recruitment)).click();
		return new RecruitmentPage();
		
	}

		
		
	}


