package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest {
	protected WebDriver driver;
	protected Properties prop;
	DriverFactory df;
	protected LoginPage loginpage;
	protected AccountsPage accountPage;
	protected SearchResultsPage searchResultsPage;
	protected ProductInfoPage productInfoPage;
    protected RegisterPage registerPage;
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
	prop=	df.initProp();
		driver = df.initDriver(prop);
		loginpage = new LoginPage(driver);

	}

//	@AfterTest
//	public void tearDown() {
//	driver.quit();
//	}

}
