package pages;

import org.openqa.selenium.WebDriver;

import bankguru99.EditCustomerPageUI;

public class EditCustomerPage extends AbstractPage {
	WebDriver driver;

	public EditCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void typeToCustomerId(String customerId) {
		senkeyToElement(driver, EditCustomerPageUI.CUSTOMERID_TEXTBOX, customerId);
	}

	public void clickToSubmitButton() {
		clickToElement(driver, EditCustomerPageUI.SUBMIT_BUTTON);
	}

	public CustomerUpdateMsg clickToEditSubmitButton() {
		clickToElement(driver, EditCustomerPageUI.EDIT_SUBMIT_BUTTON);
		return new CustomerUpdateMsg(driver);
	}

	public void typeToAddress(String newaddress) {
		waitForControlVisible(driver, EditCustomerPageUI.ADDRESS_TEXTBOX);
		senkeyToElement(driver, EditCustomerPageUI.ADDRESS_TEXTBOX, newaddress);
	}

	public void typeToCity(String newcity) {
		waitForControlVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		senkeyToElement(driver, EditCustomerPageUI.CITY_TEXTBOX, newcity);
	}

	public void typeToState(String newstate) {
		waitForControlVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		senkeyToElement(driver, EditCustomerPageUI.STATE_TEXTBOX, newstate);
	}

	public void typeToPin(String newpin) {
		waitForControlVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		senkeyToElement(driver, EditCustomerPageUI.PIN_TEXTBOX, newpin);
	}

	public void typeToMobileNumber(String newmobilenubmer) {
		waitForControlVisible(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX);
		senkeyToElement(driver, EditCustomerPageUI.MOBILE_NUMBER_TEXTBOX, newmobilenubmer);
	}

	public void typeToEmail(String newemail) {
		waitForControlVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX, newemail);
	}
}
