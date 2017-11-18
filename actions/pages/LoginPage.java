package pages;

import org.openqa.selenium.WebDriver;

import joomla.LoginPageUI;
    
public class LoginPage extends AbstractPage{
	WebDriver driver;
	public LoginPage (WebDriver driver){
		this.driver =driver;
	}
	public void typeToUsername(String username) {
		waitForControlVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		senkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, username);
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
