package com.orange.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orange.base.BaseTest;
import com.orange.pages.DashboardPage;
import com.orange.pages.LoginPage;

public class LoginTest extends BaseTest {
	@Test(description="Verify loginpage is displayed when URL is loaded")
	public void verifyLoginPage() {
		LoginPage loginPage=new LoginPage();
		//verify login page
		Assert.assertTrue(loginPage.isAt(),"Not on loginpage");
		
	}
	@Test(description="Verify login works successfully and goes to dashboardpage")
	public void verifyLoginSuccess() {
		LoginPage loginPage=new LoginPage();
		//perform login
		DashboardPage dashboardPage=loginPage.login("Admin", "admin123");
		//verify dashboardpage
		Assert.assertTrue(dashboardPage.isAt(),"Not on dashboardpage");
		
	}

}
