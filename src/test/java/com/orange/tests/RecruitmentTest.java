package com.orange.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orange.base.BaseTest;
import com.orange.pages.DashboardPage;
import com.orange.pages.LoginPage;
import com.orange.pages.RecruitmentPage;

public class RecruitmentTest extends BaseTest{
	
	private RecruitmentPage recruitementPage;
	
	@BeforeMethod
	public void setUpRecruitmentPage() {
		LoginPage loginPage = new LoginPage();
		DashboardPage dashboardPage = loginPage.login("Admin","admin123");
		//Verify dashboardpage is displayed
		Assert.assertTrue(dashboardPage.isAt(), "Dashboard page not loaded");
		recruitementPage = dashboardPage.clickRecruitmentOption();
	}
	@Test
	public void verifyRecruitementPageLoaded() {
		Assert.assertTrue(recruitementPage.isAt(), "Recruitment page is not loaded");
	}
	@Test(dependsOnMethods="verifyRecruitementPageLoaded")
	public void verifySearchCandidate() throws InterruptedException {
		recruitementPage.clickJobTitleDropdown();
		recruitementPage.selectJobTitle();
		recruitementPage.clickStatusDropdown();
		recruitementPage.selectStatus();
		recruitementPage.clickMethodOfAppDropdown();
		recruitementPage.selectMethodOfApp();
		recruitementPage.clickSearch();
	}

}
