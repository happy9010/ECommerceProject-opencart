package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
 class AccountsPageTest extends BaseTest {
	
	
	@BeforeClass
	public void accPageSetUp()
	{
		accountPage =	loginpage.doLogin("march2024@open.com", "Selenium@12345");
	
	}
	
	@Test
	public void verifyLogoutLinkDisplayed()
	{
		accountPage.isLogoutLinkDisplayed();
	}
	
	
	@Test
	public void verifyMainSideHeaders()
	{
	List <String> actualHeaderList = 	accountPage.accountPageRightSideHeaders();
	Assert.assertEquals(actualHeaderList.size(), AppConstants.ACC_PAGE_HEADERS_COUNT);
	Assert.assertEquals(actualHeaderList, AppConstants.expectedAccPageHeadersList);
	}
	
	

}
