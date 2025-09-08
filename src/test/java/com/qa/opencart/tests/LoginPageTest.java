package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest{
	
	
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
	String actualTitle = 	loginpage.getLoginPageTitle();
	Assert.assertEquals(actualTitle, "Account Login");
		
	}
	
	@Test(priority=2)
	public void LoginPageUrlTest()
	{
	String actualUrl = 	loginpage.getLoginPageURL();
	Assert.assertTrue(actualUrl.contains("route=account/login"));
	}
	@Test(priority=3)
	public void LoginPageHeaderTest()
	{
	String header= 	loginpage.getLoginPageHeader();
	Assert.assertEquals(header, "New Customer");
	}
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
