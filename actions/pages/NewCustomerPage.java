package pages;

import org.openqa.selenium.WebDriver;

import bankguru99.NewCustomerUI;

public class NewCustomerPage extends AbstractPage {
	WebDriver driver;
	String customername, dateofbirth, address, city, state, pin, mobilenumber, email, password;

	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	// public EditCustomerPage openEditCustomerPage() {
	// clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, "'Edit Customer'");
	// return PageFactory.getEditCustomerPage(driver);
	// }

	public void typeToCustomerName(String customername) {
		waitForControlVisible(driver, NewCustomerUI.CUSTOMER_NAME_TEXTBOX);
		senkeyToElement(driver, NewCustomerUI.CUSTOMER_NAME_TEXTBOX, customername);
	}

	public void typeToDateOfBirth(String dateofbirth) {
		if (driver.toString().toLowerCase().contains("chrome")) {
			excuteRemoveAttribute(driver, NewCustomerUI.DATE_OF_BIRTH_TEXTBOX_, "type");
			senkeyToElement(driver, NewCustomerUI.DATE_OF_BIRTH_TEXTBOX_, dateofbirth);
		} else {
			waitForControlVisible(driver, NewCustomerUI.DATE_OF_BIRTH_TEXTBOX_);
			senkeyToElement(driver, NewCustomerUI.DATE_OF_BIRTH_TEXTBOX_, dateofbirth);
		}
	}

	public void typeToAddress(String address) {
		waitForControlVisible(driver, NewCustomerUI.ADDRESS_TEXTBOX);
		senkeyToElement(driver, NewCustomerUI.ADDRESS_TEXTBOX, address);
	}

	public void typeToCity(String city) {
		waitForControlVisible(driver, NewCustomerUI.CITY_TEXTBOX);
		senkeyToElement(driver, NewCustomerUI.CITY_TEXTBOX, city);
	}

	public void typeToState(String state) {
		waitForControlVisible(driver, NewCustomerUI.STATE_TEXTBOX);
		senkeyToElement(driver, NewCustomerUI.STATE_TEXTBOX, state);
	}

	public void typeToPin(String pin) {
		waitForControlVisible(driver, NewCustomerUI.PIN_TEXTBOX);
		senkeyToElement(driver, NewCustomerUI.PIN_TEXTBOX, pin);
	}

	public void typeToMobileNumber(String mobilenubmer) {
		waitForControlVisible(driver, NewCustomerUI.MOBILE_NUMBER_TEXTBOX);
		senkeyToElement(driver, NewCustomerUI.MOBILE_NUMBER_TEXTBOX, mobilenubmer);
	}

	public void typeToEmail(String email) {
		waitForControlVisible(driver, NewCustomerUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, NewCustomerUI.EMAIL_TEXTBOX, email);
	}

	public void typeToPassword(String password) {
		waitForControlVisible(driver, NewCustomerUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, NewCustomerUI.PASSWORD_TEXTBOX, password);
	}

	public void isSelectRadioButton() {
		waitForControlVisible(driver, NewCustomerUI.GENDER_CHECKBOX);
		isSelectedElement(driver, NewCustomerUI.GENDER_CHECKBOX);
	}

	public CustomerRegMsg clickToSubmit() {
		waitForControlVisible(driver, NewCustomerUI.SUBMIT_BUTTON);
		 clickToElement(driver, NewCustomerUI.SUBMIT_BUTTON);
		return new CustomerRegMsg(driver);
	}

	public String getSuccessfullyText() {
		return getTextOfElement(driver, NewCustomerUI.SUCCESSFULL_TEXT);
	}

}
