package pages;

import org.openqa.selenium.WebDriver;

import bankguru99.BalanceEquiryUI;
import bankguru99.WithdrawalUI;

public class BalanceEquiry extends AbstractPage {
	WebDriver driver;

	public BalanceEquiry(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void typeToAccountNo(String accountno) {
		waitForControlVisible(driver, BalanceEquiryUI.ACCOUNT_NO_TEXTBOX);
		senkeyToElement(driver, BalanceEquiryUI.ACCOUNT_NO_TEXTBOX, accountno);
	}

	public void clickToSubmit() {
		waitForControlVisible(driver, BalanceEquiryUI.SUBMIT_BUTTON);
		clickToElement(driver, BalanceEquiryUI.SUBMIT_BUTTON);
	}

	public String getSuccessfullyText() {
		waitForControlVisible(driver, BalanceEquiryUI.BALANCE_DETAILS);
		return getTextOfElement(driver, BalanceEquiryUI.BALANCE_DETAILS);
	}

	public boolean isDisplaybalancedetailsmessage(String balancedetailsmessage) {
		return isDisplayedElement(driver, BalanceEquiryUI.BALANCE_DETAILS, balancedetailsmessage);
	}

	public String getCurrentBalance() {
		waitForControlVisible(driver, BalanceEquiryUI.BALANCE_AMOUNTS);
		return getTextOfElement(driver, BalanceEquiryUI.BALANCE_AMOUNTS);
	}
}
