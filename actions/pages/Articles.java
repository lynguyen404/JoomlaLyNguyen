package pages;

import org.openqa.selenium.WebDriver;

import joomla.ArticlesUI;

public class Articles extends AbstractPage {
	WebDriver driver;

	public Articles(WebDriver driver) {
		this.driver = driver;
	}

	public Content clickToNewButton() {
		waitForControlVisible(driver, ArticlesUI.NEW_BUTTON);
		clickToElement(driver, ArticlesUI.NEW_BUTTON);
		return PageFactory.getContents(driver);
	}
}
