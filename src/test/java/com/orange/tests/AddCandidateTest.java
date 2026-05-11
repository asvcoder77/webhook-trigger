package com.orange.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orange.base.BaseTest;
import com.orange.pages.AddCandidatePage;
import com.orange.pages.DashboardPage;
import com.orange.pages.LoginPage;
import com.orange.pages.RecruitmentPage;
import com.orange.utils.ExcelUtil;

public class AddCandidateTest extends BaseTest {
	private AddCandidatePage addCandidatePage ;
	
	@BeforeMethod
	public void setUpAddCandidatePage() {
		LoginPage loginPage = new LoginPage();
		DashboardPage dashboardPage = loginPage.login("Admin","admin123");
		//Verify dashboardpage is displayed
		Assert.assertTrue(dashboardPage.isAt(), "Dashboard page not loaded");
		RecruitmentPage recruitmentPage=dashboardPage.clickRecruitmentOption();
		Assert.assertTrue(recruitmentPage.isAt(),"Recruitment page isnt loaded");
		addCandidatePage=recruitmentPage.clickAddCandidate();
	}
	@Test
	public void verifyAddCandidatePage() {
		Assert.assertTrue(addCandidatePage.isAt(),"Add cndidate page not loaded");
	}
	
	@DataProvider(name="candidateData")
	public Object[][] getData() throws IOException{
		return ExcelUtil.getTestData("testdata/candidatesdetails.xlsx", 
		        "sheet1");
	}
	
	@Test(dataProvider="candidateData")
	public void verifyAddCandidate(String fname,String lname,String eml,String nmbr) throws InterruptedException {
		addCandidatePage.enterNameEmailNumberKeyword(fname,lname,eml,nmbr);
		addCandidatePage.selectVacancy();
		addCandidatePage.clickConsent();
		addCandidatePage.clickSave();
	}

}
