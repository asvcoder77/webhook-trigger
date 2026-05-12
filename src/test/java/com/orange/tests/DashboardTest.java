package com.orange.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orange.base.BaseTest;
import com.orange.pages.DashboardPage;
import com.orange.pages.LoginPage;
import com.orange.pages.TimePage;

public class DashboardTest extends BaseTest {
	
	private DashboardPage dashboardPage;
	@BeforeMethod
	public void setUpDashboard() {
		
		LoginPage loginPage = new LoginPage();
		this.dashboardPage = loginPage.login("Admin", "admin123");
		//Verify dashboardpage is displayed
		Assert.assertTrue(dashboardPage.isAt(), "Dashboard page not loaded");
		
	}
	
	@Test(description="Verify user is able to scroll to bottem in dashboard page")
	public void verifyDashboardScrollable() throws InterruptedException {
		//Scroll till down
		dashboardPage.scrollToDown();
		//verify scrolled till bottem
		System.out.println(dashboardPage.isBottemLinkVisible()
		? "Reached bottem,scroll success" : "Scroll failed");
		
	}
	@Test(description="Verify time button is clicking navigating to Timepage")
	public void verifyTimeClickable() {
		TimePage timePage=dashboardPage.clickTimeButton();
		Assert.assertTrue(timePage.isAt());
		
	}
}
//qa