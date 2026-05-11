package com.orange.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.orange.base.BasePage;

public class TimePage extends BasePage {
	
	@FindBy(xpath="(//span[@class=\"oxd-topbar-body-nav-tab-item\"])[2]")
	private WebElement attendance;
	
	@FindBy(xpath="(//span[@class=\"oxd-topbar-body-nav-tab-item\"])[1]")
	private WebElement timesheets;
	
	@FindBy(xpath="(//span[@class=\"oxd-topbar-body-nav-tab-item\"])[3]")
	private WebElement reports;
	
	@FindBy(xpath="(//span[@class=\"oxd-topbar-body-nav-tab-item\"])[4]")
	private WebElement projectinfo;
	
	@FindBy(css="i.bi-calendar")
	private WebElement dateentrybtn;
	
	@FindBy(css="input[placeholder='yyyy-dd-mm']")
	private WebElement dateinput;
	
	@FindBy(css="ul.oxd-dropdown-menu a")
	private List<WebElement> attendancedropdownvalues;
	
	@FindBy(css="button[type='submit']")
	private WebElement view;

	@Override
	public boolean isAt() {
		wait.until(ExpectedConditions.elementToBeClickable(attendance));
		return this.attendance.isDisplayed();	
		
	}
	
	public void verifyDashboardElements() {
	    waitForVisibilityOfElements(timesheets,reports,projectinfo);
	}
	public void enterDate() {
		wait.until(ExpectedConditions.elementToBeClickable(dateentrybtn)).click();
		
	}
	public void selectMyRecords() {
		wait.until(ExpectedConditions.elementToBeClickable(attendance));
		attendance.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(attendancedropdownvalues));
		selectElementByText(attendancedropdownvalues,"My Records").click();	
	}
	
	public boolean verifyViewButtonPresent(){
		wait.until(ExpectedConditions.elementToBeClickable(view));
		return view.isDisplayed();
	}
}
