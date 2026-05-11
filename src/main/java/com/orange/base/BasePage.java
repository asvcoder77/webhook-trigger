package com.orange.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	public BasePage() {
		this.driver=DriverManager.getDriver();
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		this.js=(JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	public abstract boolean isAt();
	
//Scroll to specific element
protected void scrollToElement(WebElement element)	{
	wait.until(ExpectedConditions.visibilityOf(element));
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
}
//Scroll to bottom
protected void scrollToBottom() throws InterruptedException {
	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	
}	
//Waits until all provided WebElements are visible on the page.
protected void waitForVisibilityOfElements(WebElement...elements) {
	for(WebElement element:elements) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
//Returns the WebElement from the list that matches the given visible text
protected WebElement selectElementByText(List<WebElement>elements,String text) {
	for(WebElement element: elements) {
		if(element.getText().trim().equalsIgnoreCase(text)){
			return element;	
		}
	}
	throw new RuntimeException("No element found with text: "+text);
	
}


}