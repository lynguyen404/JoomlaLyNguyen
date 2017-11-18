package pages;

import org.openqa.selenium.WebDriver;

import bankguru99.LoginPageUI;

public class LoginPage extends AbstractPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getCurrentHomePageURL() {
		return getURL(driver);
	}

	String emai, url;

	public RegisterPage clickToVisitHereLink() {
		waitForControlVisible(driver, LoginPageUI.VISIT_HERE_LINK);
		clickToElement(driver, LoginPageUI.VISIT_HERE_LINK);
		return PageFactory.getRegisterPage(driver);
	}

	// public void openHomePageURL() {
	// openURL(url);
	// }
	// public void getHomePageURL(){
	// getURL(driver);

	public void typeToUsername(String username) {
		waitForControlVisible(driver, LoginPageUI.USERID_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.USERID_TEXTBOX, username);
	}

	public void typeToPassword(String password) {
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePage clickToLogin() {
		waitForControlVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return new HomePage(driver);
	}
}
