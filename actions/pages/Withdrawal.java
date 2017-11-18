package pages;

import org.openqa.selenium.WebDriver;

import bankguru99.WithdrawalUI;

public class Withdrawal extends AbstractPage {
	WebDriver driver;

	public Withdrawal(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void typeToAccountNo(String accountno) {
		waitForControlVisible(driver, WithdrawalUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, WithdrawalUI.ACCOUNT_NO_TEXTBOX, accountno);
	}

	public void typeToAmount(String amount) {
		waitForControlVisible(driver, WithdrawalUI.AMOUNT_TEXTBOX);
		senkeyToElement(driver, WithdrawalUI.AMOUNT_TEXTBOX, amount);
	}

	public void typeToDes(String description) {
		waitForControlVisible(driver, WithdrawalUI.DES_TEXTBOX);
		senkeyToElement(driver, WithdrawalUI.DES_TEXTBOX, description);
	}

	public void clickToSubmit() {
		waitForControlVisible(driver, WithdrawalUI.SUBMIT_BUTTON);
		clickToElement(driver, WithdrawalUI.SUBMIT_BUTTON);
	}

	public String getSuccessfullyText() {
		waitForControlVisible(driver, WithdrawalUI.TRANSACTION_DETAILS);
		return getTextOfElement(driver, WithdrawalUI.TRANSACTION_DETAILS);
	}

	public boolean isDisplaytranactionmessage(String transactionmessage) {
		return isDisplayedElement(driver, WithdrawalUI.TRANSACTION_DETAILS, transactionmessage);
	}

	public String getCurrentBalance() {
		waitForControlVisible(driver, WithdrawalUI.CURRENT_BALANCE);
		return getTextOfElement(driver, WithdrawalUI.CURRENT_BALANCE);
	}

}
