package pages;

import org.openqa.selenium.WebDriver;

import bankguru99.DeleteAccountUI;

public class DeleteAccount extends AbstractPage {
	WebDriver driver;

	public DeleteAccount(WebDriver driver) {
		this.driver = driver;
	}

	public void typeToAccountNo(String accountno) {
		waitForControlVisible(driver, DeleteAccountUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, DeleteAccountUI.ACCOUNT_NO_TEXTBOX, accountno);
	}

	public void clickToSubmit() {
		waitForControlVisible(driver, DeleteAccountUI.SUBMIT_BUTTON);
		clickToElement(driver, DeleteAccountUI.SUBMIT_BUTTON);
	}

	public void closeAlert(WebDriver driver) {
		waitForAlertPresence(driver);
		acceptAlert(driver);
	}

	public String deleteAccountSuccessfully() {
		waitForAlertPresence(driver);
		return getTextAlert(driver);
	}

}
