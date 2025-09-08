package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {

private	WebDriver driver;
private ElementUtil eleUtil;


  ProductInfoPage (WebDriver driver)
  {
	this.driver=driver;
	eleUtil = new ElementUtil(driver);
}
  
  private final By header= By.tagName("h1");
  private final By images = By.xpath("//ul[@class='thumbnails']/li");
  
  
  public String getProductHeader() {
		String headerVal = eleUtil.waitForElementVisible(header, AppConstants.DEFAULT_SHORT_WAIT).getText();
		System.out.println("product header is --->" + headerVal);
		return headerVal;
	}
  
  public int getImageCount()
  {
	int imagesCount=  eleUtil.waitForElementsVisible(images, AppConstants.DEFAULT_MEDIUM_WAIT).size();
	System.out.println("total number of images: " +imagesCount);
	return imagesCount;
  }
  
  

	
}
