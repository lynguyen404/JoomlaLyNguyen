package pages;

import org.openqa.selenium.WebDriver;

import bankguru99.CustomerRegMsgUI;

public class CustomerRegMsg extends AbstractPage {
	WebDriver driver;

	public CustomerRegMsg(WebDriver driver) {
		this.driver = driver;
	}

	public String getSuccessfullyText() {
		return getTextOfElement(driver, CustomerRegMsgUI.SUCCESSFULLY_LINK);
	}

	public String getCustomerIDText() {
		return getTextOfElement(driver, CustomerRegMsgUI.CUSTOMER_ID);

	}

	public void verifyTextSuccessfully(String expected) {
		verifyText(driver, CustomerRegMsgUI.SUCCESSFULLY_LINK, expected);

	}

	public String getCustomerId() {
		return getTextOfElement(driver, CustomerRegMsgUI.CUSTOMER_ID);
	}

	public boolean isDisplayHomePage(String homepagevalue) {
		return isDisplayedElement(driver, CustomerRegMsgUI.SUCCESSFULLY_LINK, homepagevalue);
	}
}
