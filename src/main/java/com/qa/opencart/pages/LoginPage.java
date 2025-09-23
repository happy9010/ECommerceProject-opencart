package com.qa.opencart.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleutil;
	// private By locators : page Objects

	private final By emailID = By.id("input-email");
	private final By password = By.id("input-password");
	private final By loginButton = By.xpath("//input[@value = 'Login']");

	private final By forgotPasswordLink = By.linkText("Forgotten Password");
	private final By header = By.tagName("h2");
	private final By headerList = By.xpath("//ul[@class='nav navbar-nav']/li");
	private final By sideLinks = By.xpath("//div[@class='list-group']/a");
    private final By registerLink = By.linkText("Register");
	// public constructor
    private static final Logger log = LogManager.getLogger(LoginPage.class);
	public LoginPage(WebDriver driver)

	{
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}

@Step("getting login page title.....")
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("Login page title is:" + title);
		return title;
	}
@Step("getting login page URL.....")
	public String getLoginPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("Login Page URL is :" + url);
		return url;
	}
@Step("getting login page Header.....")
	public String getLoginPageHeader() {
		String text = driver.findElement(header).getText();
		System.out.println("Login page header is: " + text);
		return text;

	}
@Step("login with username:{0} and password {1}.....")
	public AccountsPage doLogin(String appUserName, String appPassword) {
		driver.findElement(emailID).sendKeys(appUserName);
		driver.findElement(password).sendKeys(appPassword);
		driver.findElement(loginButton).click();
		// return driver.getTitle();
		return new AccountsPage(driver);
	}
@Step("login page header links")
	public void displayHeaderLinks() {
		List<WebElement> list = driver.findElements(headerList);
		System.out.println("=========================");
		System.out.println("Total header links are:" + list.size());
		System.out.println("=========================");
		for (WebElement e : list) {
			String headerLinks = e.getText();
			System.out.println(headerLinks);
		}

	}
@Step("login page display side links")
	public void displaySideLinks() {
		List<WebElement> list = driver.findElements(sideLinks);
		System.out.println("=========================");

		System.out.println("Total side links are:" + list.size());
		System.out.println("=========================");
		for (WebElement e : list) {
			String sideLinks = e.getText();
			System.out.println(sideLinks);
		}
	}
@Step("navigate to register page ")
		
		public RegisterPage navigateToRegisterPage()
		{
			
		eleutil.waitForElementVisible(registerLink, AppConstants.DEFAULT_SHORT_WAIT).click();
		return new RegisterPage(driver);
		
	}

}
