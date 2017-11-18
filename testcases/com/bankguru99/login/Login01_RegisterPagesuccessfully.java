package com.bankguru99.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pages.HomePage;
import pages.LoginPage;
import pages.PageFactory;
import pages.RegisterPage;

public class Login01_RegisterPagesuccessfully extends AbstractTest {
	WebDriver driver;
	private String loginPageURL, username, password, email;
	private LoginPage loginPage;
	private RegisterPage registerPage;
	private HomePage homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) throws Exception {
		driver = openBrowser(browser, url);
		// loginPage = new LoginPage(driver);
		// registerPage = new RegisterPage(driver);
		loginPage = PageFactory.getLoginPage(driver);
		registerPage = PageFactory.getRegisterPage(driver);
		homePage = PageFactory.getHomePage(driver);
		email = "auto" + randomEmail() + "@gmail.com";

	}

	@Test
	public void TC_01_GetUsernameAndPassword() {

		loginPageURL = loginPage.getCurrentHomePageURL();
		registerPage = loginPage.clickToVisitHereLink();
		registerPage.typeToEmail(email);
		registerPage.clickToSubmit();
		username = registerPage.getTextUsername();
		password = registerPage.getTextPassword();
		loginPage = registerPage.openLoginPage(driver, loginPageURL);
		loginPage.typeToUsername(username);
		loginPage.typeToPassword(password);
		homePage = loginPage.clickToLogin();

	}

	public void TC_02_LoginToSystem() {
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement usernameTextbox = driver.findElement(By.xpath("//input[@name='uid']"));
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@name='password']"));
		Assert.assertTrue(usernameTextbox.isDisplayed());
		usernameTextbox.sendKeys(username);
		passwordTextbox.sendKeys(password);

		WebElement buttonlogin = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		buttonlogin.click();
		WebElement welcomemessage = driver.findElement(By.xpath("//marquee[@class='heading3']"));
		Assert.assertTrue(welcomemessage.isDisplayed());
		Assert.assertEquals("Welcome To Manager's Page of Guru99 Bank", welcomemessage.getText());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public String randomEmail() {
		Random rand = new Random();
		int number = rand.nextInt(900) + 1;
		String numberString = Integer.toString(number);
		return numberString;
	}

	public Object BrowserElement(String Javascrip) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(Javascrip);
	}

	public Object excutejsWebElement(String Javasript, WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(Javasript, Element);
	}

}
