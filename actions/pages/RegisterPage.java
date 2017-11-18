package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import bankguru99.RegisterPageUI;

public class RegisterPage extends AbstractPage {
	WebDriver driver;
	String email;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextOfElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public void typeToEmail(String email) {
		waitForControlVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
		senkeyToElement(driver, RegisterPageUI.EMAIL_ID_TEXTBOX, email);
	}

	public void clickToSubmit() {
		waitForControlVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);

	}

	public String getTextUsername() {
		waitForControlVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getTextOfElement(driver, RegisterPageUI.USER_ID_TEXT);
	}

	public String getTextPassword() {
		waitForControlVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getTextOfElement(driver, RegisterPageUI.PASSWORD_TEXT);
	}

	public LoginPage openLoginPage(WebDriver driver, String url) {
		openURL(driver, url);
		return PageFactory.getLoginPage(driver);
	}
}
