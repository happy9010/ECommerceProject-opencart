package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	By mainSideHeaders= By.xpath("//div[@id='content']//h2");
	By rightSideLinks = By.xpath("(//div[@class='list-group'])/a");
	
	By searchField= By.name("search");
	By searchButton= By.xpath("(//button[@type='button'])[4]");
	By logoutLink =By.linkText("Logout");
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
	
	public boolean isLogoutLinkDisplayed()
	{
	WebElement logout=	eleUtil.waitForElementVisible(logoutLink, 10);
	return	eleUtil.isElementDisplayed(logout);
	}
	
	public List<String> accountPageRightSideHeaders()
	{
		return eleUtil.getElementsTextList(mainSideHeaders);
	}
	public SearchResultsPage search(String searchKey)
	{
		System.out.println("Search key is ---->>" +searchKey );
	WebElement searchValue =	eleUtil.waitForElementVisible(searchField, AppConstants.DEFAULT_MEDIUM_WAIT);
	searchValue.clear();
	searchValue.sendKeys(searchKey);
//	searchValue.clear();
		eleUtil.doClick(searchButton);
		return new SearchResultsPage(driver);
	}
	
	
}
