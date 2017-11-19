package pages;

import org.openqa.selenium.WebDriver;

import joomla.HomePageUI;

public class HomePage extends AbstractPage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public Articles clickOnMenuArticles() {
		waitForControlVisible(driver, HomePageUI.ARTICLES_LINK);
		clickToElement(driver, HomePageUI.ARTICLES_LINK);
		return PageFactory.getArticles(driver);
	}

	public boolean isDisplayArticlesSaved(String messagesuccessfully) {
		waitForControlVisible(driver, HomePageUI.ARTICLES_MESSAGE);
		return isDisplayedElement(driver, HomePageUI.ARTICLES_MESSAGE, messagesuccessfully);
	}

	public String getTextArticleSuccessfully() {
		return getTextOfElement(driver, HomePageUI.ARTICLES_MESSAGE);
	}
}
