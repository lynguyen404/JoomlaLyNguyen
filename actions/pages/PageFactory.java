package pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
	WebDriver driver;

	public static LoginPage getLoginPage(WebDriver driver) {
		return new LoginPage(driver);

	}

	public static RegisterPage getRegisterPage(WebDriver driver) {
		return new RegisterPage(driver);

	}

	public static HomePage getHomePage(WebDriver driver) {
		return new HomePage(driver);

	}

	public static NewCustomerPage getNewCustomerPage(WebDriver driver) {
		return new NewCustomerPage(driver);

	}

	public static EditCustomerPage getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPage(driver);

	}

	public static CustomerRegMsg getCustomerRegMsgPage(WebDriver driver) {
		return new CustomerRegMsg(driver);

	}

	public static CustomerUpdateMsg getCCustomerUpdateMsgPage(WebDriver driver) {
		return new CustomerUpdateMsg(driver);

	}

	public static NewAccountPage getNewAccountPage(WebDriver driver) {
		return new NewAccountPage(driver);

	}

	public static DepositPage getDepositPage(WebDriver driver) {
		return new DepositPage(driver);
	}

	public static Withdrawal getWithdrawalPage(WebDriver driver) {
		return new Withdrawal(driver);
	}

	public static Fundtransfer getFundtransferPage(WebDriver driver) {
		return new Fundtransfer(driver);
	}

	public static BalanceEquiry getBalanceEquiryPage(WebDriver driver) {
		return new BalanceEquiry(driver);
	}

	public static DeleteAccount getDeleteAccountPage(WebDriver driver) {
		return new DeleteAccount(driver);
	}

	public static DeleteCustomer getDeleteCustomerPage(WebDriver driver) {
		return new DeleteCustomer(driver);
	}
}
