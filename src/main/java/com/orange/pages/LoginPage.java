package com.orange.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.orange.base.BasePage;

public class LoginPage extends BasePage{
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(css="button[type='submit']")
	private WebElement submit;

	@Override
	public boolean isAt() {
		wait.until(ExpectedConditions.visibilityOf(this.submit));
		return this.submit.isDisplayed();
	}
	
	public DashboardPage login(String usr,String pass) {
		wait.until(ExpectedConditions.visibilityOf(this.username));
		username.sendKeys(usr);
		wait.until(ExpectedConditions.visibilityOf(this.password));
		password.sendKeys(pass);
		wait.until(ExpectedConditions.visibilityOf(this.submit));
		submit.click();
		return new DashboardPage();
		
	}

}
