package com.joomla.login;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pages.HomePage;
import pages.LoginPage;
import pages.PageFactory;


public class LoginSuccessfully extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) throws Exception {

		String username;
		String password;
		username = "automationfc";
		password ="automationfc";
		driver = openBrowser(browser, url);
		loginPage=PageFactory.getLoginPage(driver);
		loginPage.typeToUsername(username);
		loginPage.typeToPassword(password);
		homePage=loginPage.clickToLogin();
		
	}
	@Test
	
	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}
	private LoginPage loginPage;
	private HomePage homePage;
}