package pages;

import org.openqa.selenium.WebDriver;

import bankguru99.CustomerRegMsgUI;
import bankguru99.DepositPageUI;

public class DepositPage extends AbstractPage {
	WebDriver driver;

	public DepositPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void typeToAccountNo(String accountno) {
		waitForControlVisible(driver, DepositPageUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, DepositPageUI.ACCOUNT_NO_TEXTBOX, accountno);
	}

	public void typeToAmount(String amount) {
		waitForControlVisible(driver, DepositPageUI.AMOUNT_TEXTBOX);
		senkeyToElement(driver, DepositPageUI.AMOUNT_TEXTBOX, amount);
	}

	public void typeToDes(String description) {
		waitForControlVisible(driver, DepositPageUI.DES_TEXTBOX);
		senkeyToElement(driver, DepositPageUI.DES_TEXTBOX, description);
	}

	public void clickToSubmit() {
		waitForControlVisible(driver, DepositPageUI.SUBMIT_BUTTON);
		clickToElement(driver, DepositPageUI.SUBMIT_BUTTON);
	}

	public String getSuccessfullyText() {
		waitForControlVisible(driver, DepositPageUI.TRANSACTION_DETAILS);
		return getTextOfElement(driver, DepositPageUI.TRANSACTION_DETAILS);
	}

	public boolean isDisplaytranactionmessage(String transactionmessage) {
		return isDisplayedElement(driver, DepositPageUI.TRANSACTION_DETAILS, transactionmessage);
	}

	public String getCurrentBalance() {
		waitForControlVisible(driver, DepositPageUI.CURRENT_BALANCE);
		return getTextOfElement(driver, DepositPageUI.CURRENT_BALANCE);
	}
}
