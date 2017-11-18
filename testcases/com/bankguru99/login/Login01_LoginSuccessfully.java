package com.bankguru99.login;

import org.testng.annotations.Test;

import commons.AbstractTest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login01_LoginSuccessfully extends AbstractTest {
	WebDriver driver;
	private String username, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) throws Exception {
		driver = openBrowser(browser, url);

	}

	@Test
	public void TC_01_GetUsernameAndPassword() {
		WebElement registerclick = driver.findElement(By.xpath("//a[contains(text(),'here')]"));
		// registerclick.click();
		excutejsWebElement("arguments[0].click();", registerclick);
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@name='emailid']"));
		Assert.assertTrue(emailTextbox.isDisplayed());
		emailTextbox.sendKeys("autotesting" + randomEmail() + "@gmail.com");

		WebElement loginbutton = driver.findElement(By.xpath("//input[@name='btnLogin']"));
		loginbutton.click();
		username = driver.findElement(By.xpath("//td[contains(text(),'User ID :')]//following-sibling::td")).getText();
		password = driver.findElement(By.xpath("//td[contains(text(),'Password :')]//following-sibling::td")).getText();

	}

	@Test
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
