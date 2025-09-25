package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EP-100: Design the Open Cart App Login Page")
@Feature("F-101: design open cart login feature")
@Story("US-50: develop login core features: title, url, user is able to login")
public class LoginPageTest extends BaseTest{
	
	@Description("login page title test....")
	@Link("")
	@Owner("Naveen Automation Labs")
	@Severity(SeverityLevel.MINOR)
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
	String actualTitle = 	loginpage.getLoginPageTitle();
	ChainTestListener.log("login page tite: "+ actualTitle);
	Assert.assertEquals(actualTitle, "Account Login");
		
	}
	@Description("login page url test....")
	@Owner("Naveen Automation Labs")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void LoginPageUrlTest()
	{
	String actualUrl = 	loginpage.getLoginPageURL();
	ChainTestListener.log("login page url: "+ actualUrl);
	Assert.assertTrue(actualUrl.contains("route=account/login"));
	}
	@Description("login page header test....")
	@Owner("Naveen Automation Labs")
	@Severity(SeverityLevel.MINOR)
	@Test(priority=3)
	public void LoginPageHeaderTest()
	{
	String header= 	loginpage.getLoginPageHeader();
	Assert.assertEquals(header, "New Customer");
	}
	@Description("user is able to login to app with the correct credentials....")
	@Owner("Naveen Automation Labs")
	@Severity(SeverityLevel.BLOCKER)
	@ Test(priority=4)
	public void LoginTest()
	{
		accountPage=	 loginpage.doLogin("march2024@open.com", "Selenium@12345");
		 Assert.assertTrue(accountPage.isLogoutLinkDisplayed());

	
	}
	@Test (priority = 0)
	public void verifyHeaderLinks()
	{
		loginpage.displayHeaderLinks();
	}
	@Test(priority = -1)
	public void verifySideLinks()
	{
		loginpage.displaySideLinks();
	}
	

}
