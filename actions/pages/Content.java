package pages;

import org.openqa.selenium.WebDriver;

import joomla.ArticlesUI;
import joomla.ContentUI;

public class Content extends AbstractPage {
	WebDriver driver;

	public Content(WebDriver driver) {
		this.driver = driver;
	}

	public void typeToTextArea(String valueoftextarea) {
		waitForControlVisible(driver, ContentUI.CONTENT_TEXTBOX);
		senkeyToElement(driver, ContentUI.CONTENT_TEXTBOX, valueoftextarea);
	}

	public void typeToTitle(String titlename) {
		waitForControlVisible(driver, ArticlesUI.NAME_TITLE);
		senkeyToElement(driver, ArticlesUI.NAME_TITLE, titlename);
	}

	public void isSelectCatagory(String valueofdropdown) {
		waitForControlVisible(driver, ArticlesUI.DROPDOWN_VALUE);
		isSelectedElement(driver, ArticlesUI.DROPDOWN_VALUE, valueofdropdown);
	}

	public Content moveToJform() {
		moveToIfame(driver, ArticlesUI.IFRAME_JFORM);
		return PageFactory.getContents(driver);
	}

	public void moveToArticles() {
		moveToDefault(driver);
	}

	public HomePage clickToSaveAndClose() {
		clickToElement(driver, ArticlesUI.SAVEANDCLOSE_BUTTON);
		return PageFactory.getHomePage(driver);
	}
}
