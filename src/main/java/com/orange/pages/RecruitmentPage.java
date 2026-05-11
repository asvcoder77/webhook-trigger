package com.orange.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.orange.base.BasePage;

public class RecruitmentPage extends BasePage {
	
	@FindBy(xpath="(//a[@class='oxd-topbar-body-nav-tab-item'])[1]")
	private WebElement candidates;
	
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[1]")
	private WebElement jobtitle;
	
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[4]")
	private WebElement status;
	
	@FindBy(xpath="(//div[@class='oxd-select-text-input'])[5]")
	private WebElement methodofapp;
	
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[1]")
	private WebElement jobtitledropdown;
	
	@FindBy(xpath="//button[text()=' Search ']")
	private WebElement search;
	
	@FindBy(xpath="//button[text()=' Add ']")
	private WebElement add;

	
	@Override
	public boolean isAt() {
		wait.until(ExpectedConditions.elementToBeClickable(candidates));
		return candidates.isDisplayed();
	}
	public void clickJobTitleDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(jobtitledropdown)).click();	
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
		        By.xpath("//div[@role='option']"), 5
		    ));
	}
	public void selectJobTitle() {
	    By option = By.xpath("(//div[@role='option'])[6]");

	    wait.until(ExpectedConditions.elementToBeClickable(option)).click();
	}
//	public void selectJobTitle() {
//		List<WebElement>jobs=wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@role='option']"), 5));
//		System.out.println(jobs.size());
//		jobs.get(5).click();    	
//	}
	public void clickStatusDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(status)).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));
	}
	public void selectStatus() {
		List<WebElement>statuses=wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@role='option']"), 7));
		System.out.println(statuses.size());
		statuses.get(5).click();
	}
	public void clickMethodOfAppDropdown() {
		wait.until(ExpectedConditions.elementToBeClickable(methodofapp)).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@role='option']")));
	}
	public void selectMethodOfApp() {
		List<WebElement>methods=wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@role='option']"), 2));
		System.out.println(methods.size());
		methods.get(1).click();
	}
	public void clickSearch() {
		wait.until(ExpectedConditions.elementToBeClickable(search)).click();
	}
    public AddCandidatePage clickAddCandidate() {
    	wait.until(ExpectedConditions.elementToBeClickable(add)).click();
    	return new AddCandidatePage();
    	
    	
    }
}


//