package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {
	
	@BeforeClass
	public void searchSetup()
	{
		accountPage=	 loginpage.doLogin("march2024@open.com", "Selenium@12345");
	}
	
	@DataProvider
	public Object[][] getProducts()
	{
		return new Object[] [] {
			{ "macbook" ,"MacBook Pro"},
			{"samsung" , "Samsung SyncMaster 941BW"},
			{"imac" , "iMac"},
			{"canon" , "Canon EOS 5D"}
		};
	}
	
	@Test(dataProvider="getProducts")
	public void productHeaderTest(String searchKey , String productName)
	{
		searchResultsPage=	accountPage.search(searchKey);
		productInfoPage=	searchResultsPage.selectProduct(productName);
	String actHeader=	productInfoPage.getProductHeader();
	Assert.assertEquals(actHeader, productName);
	}
	@DataProvider
	public Object[][] getProductImages()
	{
		return new Object[] [] {
			{"macbook" ,"MacBook Pro", 4 },
			{"samsung" , "Samsung SyncMaster 941BW" ,1},
			{"imac" , "iMac" ,3},
			{"canon" , "Canon EOS 5D",3}
		};
	}
	
	@Test(dataProvider = "getProductImages")
	public void productImagesCountTest(String searchKey,String ProductName, int count)
	{
		searchResultsPage=	accountPage.search(searchKey);
		productInfoPage=	searchResultsPage.selectProduct(ProductName);
	int actImagesCount=	productInfoPage.getImageCount();
	Assert.assertEquals(actImagesCount, count);
		
	}
	
	
	
}
