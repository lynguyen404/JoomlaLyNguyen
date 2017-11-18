package pages;

import org.openqa.selenium.WebDriver;

import bankguru99.CustomerUpdateMsgUI;

public class CustomerUpdateMsg extends AbstractPage {
	WebDriver driver;

	public CustomerUpdateMsg(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyTextSuccessfully(String expected) {
		verifyText(driver, CustomerUpdateMsgUI.EDIT_SUCCESSFULLY_LINK, expected);

	}

	public boolean isDisplayEditSuccessfully(String editsuccessfully) {
		return isDisplayedElement(driver, CustomerUpdateMsgUI.EDIT_SUCCESSFULLY_LINK, editsuccessfully);
	}
}
