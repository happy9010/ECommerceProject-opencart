package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class SearchResultsTest extends BaseTest {
	
	@BeforeClass
	public void searchSetup()
	{
		accountPage=	 loginpage.doLogin("march2024@open.com", "Selenium@12345");
	}
	
	@Test
	public void searchTest()
	{
		searchResultsPage=	accountPage.search("macbook");
		productInfoPage=	searchResultsPage.selectProduct("MacBook Pro");
	String actHeader=	productInfoPage.getProductHeader();
	Assert.assertEquals(actHeader, "MacBook Pro");
	}
	
	
	

}
