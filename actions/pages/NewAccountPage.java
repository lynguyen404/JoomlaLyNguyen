package pages;

import org.openqa.selenium.WebDriver;

import bankguru99.CustomerUpdateMsgUI;
import bankguru99.NewAccountPageUI;

public class NewAccountPage extends AbstractPage {
	WebDriver driver;

	public NewAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	public void typeCustomerId(String customerId){
		waitForControlVisible(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		senkeyToElement(driver, NewAccountPageUI.CUSTOMER_ID_TEXTBOX, customerId);
	}
	public void selecAccountTypedropdown(String accounttype){
		waitForControlVisible(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
		selectItemInDropdown(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN, accounttype);
	}
	public void typeInitialDeposit(String initialdeposit){
		waitForControlVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
		senkeyToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX, initialdeposit);
	}
	public void clickToSubmitButton() {
		clickToElement(driver, NewAccountPageUI.SUBMIT_BUTTON);
	}
	public boolean isDisplayGeneratedAccSuccessfully(String generatedaccsuccessfully){
		return isDisplayedElement(driver, NewAccountPageUI.GENERATED_ACCOUNT_SUCCESSFULLY, generatedaccsuccessfully);
	}
	public String getAccountID(){
		return getTextOfElement(driver, NewAccountPageUI.ACCOUNT_ID);
	}
	public String getCurrentAmount(){
		return getTextOfElement(driver, NewAccountPageUI.CURRENT_AMOUNT);
	}
}
