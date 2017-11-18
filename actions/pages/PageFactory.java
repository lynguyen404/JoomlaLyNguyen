package pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
WebDriver driver;
public static LoginPage getLoginPage (WebDriver driver){
	return new LoginPage(driver);
}

public static HomePage getHomePage (WebDriver driver){
	return new HomePage(driver);
}
}
