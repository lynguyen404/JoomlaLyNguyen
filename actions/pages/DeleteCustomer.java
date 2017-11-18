package pages;

import org.openqa.selenium.WebDriver;

import bankguru99.DeleteCustomerUI;

public class DeleteCustomer extends AbstractPage {
	WebDriver driver;

	public DeleteCustomer(WebDriver driver) {
		this.driver = driver;
	}

	public void typeToCustomerNo(String customerno) {
		waitForControlVisible(driver, DeleteCustomerUI.CUSTOMER_NO_TEXTBOX);
		senkeyToElement(driver, DeleteCustomerUI.CUSTOMER_NO_TEXTBOX, customerno);
	}

	public void clickToSubmit() {
		waitForControlVisible(driver, DeleteCustomerUI.SUBMIT_BUTTON);
		clickToElement(driver, DeleteCustomerUI.SUBMIT_BUTTON);
	}

	public void closeAlert(WebDriver driver) {
		waitForAlertPresence(driver);
		acceptAlert(driver);
	}

	public String deleteCustomerSuccessfully() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}
}
