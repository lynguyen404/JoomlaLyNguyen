package pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
	WebDriver driver;

	public static LoginPage getLoginPage(WebDriver driver) {
		return new LoginPage(driver);
	}

	public static HomePage getHomePage(WebDriver driver) {
		return new HomePage(driver);
	}

	public static Articles getArticles(WebDriver driver) {
		return new Articles(driver);

	}

	public static Content getContents(WebDriver driver) {
		return new Content(driver);
	}
}
