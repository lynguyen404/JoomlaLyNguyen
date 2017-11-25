package pages;

import org.openqa.selenium.WebDriver;

import joomla.ArticlesUI;
import joomla.HomePageUI;

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
	
	public void isCheckedCheckbox(){
		waitForControlVisible(driver, ArticlesUI.CHECKBOX);
		isCheckedCheckbox(driver,ArticlesUI.CHECKBOX);
	}
	
	public EditContent clickToEditButton(){
		waitForControlVisible(driver, ArticlesUI.EDIT_BUTTON);
		clickToElement(driver, ArticlesUI.EDIT_BUTTON);
		return PageFactory.getEditContents(driver);
	}
	
	public void isPublicArticles(){
		waitForControlVisible(driver, ArticlesUI.PUBLIC_BUTTON);
		isCheckedCheckbox(driver,ArticlesUI.PUBLIC_BUTTON);
	}
	
	
	public boolean isDisplayPubicArticles(String publicsuccessfully) {
		waitForControlVisible(driver, ArticlesUI.PUBLIC_MESSAGE);
		return isDisplayedElement(driver, ArticlesUI.PUBLIC_MESSAGE, publicsuccessfully);
	}

	public String getTextArticleSuccessfully() {
		return getTextOfElement(driver, ArticlesUI.PUBLIC_MESSAGE);
	}
}



