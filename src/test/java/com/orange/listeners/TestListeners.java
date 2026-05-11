package com.orange.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

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
		String screenshot = driver.getScreenshotAs(OutputType.BASE64);
		
		String testName = result.getMethod().getMethodName();
		Reporter.log("<b>Test Failed:</b> " + testName);
		Reporter.log("<b>Reason:</b> " + result.getThrowable());
		
		String htmlImage = String.format(
                "<br><img width='700px' src='data:image/png;base64,%s'/><br>",
                screenshot);
        Reporter.log(htmlImage);     
        
	}

}
