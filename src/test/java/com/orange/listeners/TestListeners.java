package com.orange.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import io.qameta.allure.Allure;

import com.orange.utils.Constants;

public class TestListeners implements ITestListener{
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Listener triggered");
		Object driverObj=result.getTestContext().getAttribute(Constants.DRIVER);
		if(driverObj == null) {
			Reporter.log("Driver is null,Screenshot isnt captured");
			return;
		}
		TakesScreenshot driver = (TakesScreenshot)driverObj;
		byte[] screenshot = driver.getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Failure screenshot", "image/png", new java.io.ByteArrayInputStream(screenshot), ".png");
		
		String testName = result.getMethod().getMethodName();
		Reporter.log("<b>Test Failed:</b> " + testName);
		Reporter.log("<b>Reason:</b> " + result.getThrowable());
	}

}
