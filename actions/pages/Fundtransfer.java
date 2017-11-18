package pages;

import org.openqa.selenium.WebDriver;

import bankguru99.FundtransferUI;

public class Fundtransfer extends AbstractPage {
	WebDriver driver;

	public Fundtransfer(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void typeToPayersAccountNo(String payersaccountno) {
		waitForControlVisible(driver, FundtransferUI.PAYERS_ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, FundtransferUI.PAYERS_ACCOUNT_NO_TEXTBOX, payersaccountno);
	}

	public void typeToPayeesAccountNo(String payeesaccountno) {
		waitForControlVisible(driver, FundtransferUI.PAYEES_ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, FundtransferUI.PAYEES_ACCOUNT_NO_TEXTBOX, payeesaccountno);
	}

	public void typeToAmount(String amount) {
		waitForControlVisible(driver, FundtransferUI.AMOUNT_TEXTBOX);
		senkeyToElement(driver, FundtransferUI.AMOUNT_TEXTBOX, amount);
	}

	public void typeToDes(String description) {
		waitForControlVisible(driver, FundtransferUI.DES_TEXTBOX);
		senkeyToElement(driver, FundtransferUI.DES_TEXTBOX, description);
	}

	public void clickToSubmit() {
		waitForControlVisible(driver, FundtransferUI.SUBMIT_BUTTON);
		clickToElement(driver, FundtransferUI.SUBMIT_BUTTON);
	}

	public boolean isDisplayFromAccountNo(String fromaccountno) {
		return isDisplayedElement(driver, FundtransferUI.FROM_ACCOUNT_ID, fromaccountno);
	}

	public String getCurrentBalance() {
		waitForControlVisible(driver, FundtransferUI.TRANSFER_AMOUNT);
		return getTextOfElement(driver, FundtransferUI.TRANSFER_AMOUNT);
	}

}
