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
		waitForControlVisible(driver, ContentUI.NAME_TITLE);
		senkeyToElement(driver, ContentUI.NAME_TITLE, titlename);
	}

	public void isSelectCatagory(String valueofdropdown) {
		waitForControlVisible(driver, ContentUI.DROPDOWN_VALUE);
		isSelectedElement(driver, ContentUI.DROPDOWN_VALUE, valueofdropdown);
	}
	public void isSelectStatus(String valueofstatusdropdown) {
		waitForControlVisible(driver, ContentUI.STATUS_DROPDOWN);
		isSelectedElement(driver, ContentUI.STATUS_DROPDOWN, valueofstatusdropdown);
	}

	public Content moveToJform() {
		moveToIfame(driver, ContentUI.IFRAME_JFORM);
		return PageFactory.getContents(driver);
	}

	public void moveToArticles() {
		moveToDefault(driver);
	}

	public HomePage clickToSaveAndClose() {
		clickToElement(driver, ContentUI.SAVEANDCLOSE_BUTTON);
		return PageFactory.getHomePage(driver);
	}
}
