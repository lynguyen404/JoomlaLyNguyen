package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// public NewCustomerPage clickNewCustomerLink() {
	// waitForControlVisible(driver, HomePageUI.NEW_CUSTOMER_HOMEPAGE_LINK);
	// clickToElement(driver, HomePageUI.NEW_CUSTOMER_HOMEPAGE_LINK);
	// return PageFactory.getNewCustomerPage(driver);
	// }
}
