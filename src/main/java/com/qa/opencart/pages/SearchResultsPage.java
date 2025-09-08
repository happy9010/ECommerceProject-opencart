package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class SearchResultsPage {
	
	private WebDriver driver ;
	private ElementUtil eleUtil;
	SearchResultsPage(WebDriver driver)
	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	// By locators 
	
	By searchResults = By.xpath("//div[@class='product-thumb']");
	By searchHeader = By.xpath("//h1[text()='Search - macbook']");
	
	
	public int getSearchResultsCount()
	{
	int resultCount =	eleUtil.waitForElementsPresence(searchResults, AppConstants.DEFAULT_MEDIUM_WAIT).size();
	
	System.out.println("results count---->" + resultCount);
	return resultCount;
	
	}
	
	public String getReslutsHeaderValue()
	{
	String header= 	eleUtil.doElementGetText(searchHeader);
	System.out.println("result----->"  +header);
	return header;
	}
	public ProductInfoPage selectProduct (String productName)
	{
		System.out.println("product name ----> " + productName);
		
	 
		eleUtil.doClick(By.xpath("//a[text()='"+productName+"']"));
		
		return new ProductInfoPage(driver);
		
	}
	
	
	
	
	
	
	
	

}
