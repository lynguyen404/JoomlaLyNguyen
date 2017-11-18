package com.bankguru99.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pages.BalanceEquiry;
import pages.CustomerRegMsg;
import pages.CustomerUpdateMsg;
import pages.DeleteAccount;
import pages.DeleteCustomer;
import pages.DepositPage;
import pages.EditCustomerPage;
import pages.Fundtransfer;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAccountPage;
import pages.NewCustomerPage;
import pages.PageFactory;
import pages.RegisterPage;
import pages.Withdrawal;

public class Customer_CreateCustomerSuccessfully extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) throws Exception {

		String loginPageURL;
		String username;
		String email, password;
		customername = "ly nguyen";
		dateofbirth = "01/01/1990";
		address = "909 Street";
		newaddress = "901 Street";
		city = "Washington";
		newcity = "West Chicago";
		state = "New York";
		newstate = "Alabama";
		pin = "123456";
		newpin = "654321";
		mobilenubmer = "987654321";
		newmobilenubmer = "987654322";
		email = "auto" + randomEmail() + "@gmail.com";
		emailtest = "auto" + randomEmail() + "@gmail.com";
		newemail = "newauto" + randomEmail() + "@gmail.com";
		passwordtest = "987654321";
		homepagevalue = "Customer Registered Successfully!!!";
		editsuccessfully = "Customer details updated Successfully!!!";
		accounttype = "Current";
		initialdeposit = "50000";
		generatedaccsuccessfully = "Account Generated Successfully!!!";
		currentamount = "50000";
		amount = "5000";
		description = "Deposit";
		currentbalance = "55000";
		transactionmessage = "Transaction details of Deposit for Account";
		withdrawalmessage = "Transaction details of Withdrawal for Account";
		balancedetailsmessage = "Balance Details for Account";
		deletemessage = "Account Deleted Sucessfully";
		deletecustomersuccessfully = "Customer deleted Successfully";
		driver = openBrowser(browser, url);
		//homePage = PageFactory.getHomePage(driver);
		loginPage=PageFactory.getLoginPage(driver);
		loginPageURL = loginPage.getCurrentHomePageURL();
		registerPage = loginPage.clickToVisitHereLink();
		registerPage.typeToEmail(email);
		registerPage.clickToSubmit();
		username = registerPage.getTextUsername();
		password = registerPage.getTextPassword();
		System.out.println(username);
		System.out.println(password);
		loginPage = registerPage.openLoginPage(driver, loginPageURL);
		loginPage.typeToUsername(username);
		loginPage.typeToPassword(password);
		homePage = loginPage.clickToLogin();
	}

	@Test
	public void TC_01_CreateCustomerSuccessfully() {
		// create acc1
		newCustomerPage = homePage.openNewCustomerPage(driver);
		newCustomerPage.typeToCustomerName(customername);
		newCustomerPage.isSelectRadioButton();
		newCustomerPage.typeToDateOfBirth(dateofbirth);
		newCustomerPage.typeToAddress(address);
		newCustomerPage.typeToCity(city);
		newCustomerPage.typeToState(state);
		newCustomerPage.typeToPin(pin);
		newCustomerPage.typeToMobileNumber(mobilenubmer);
		newCustomerPage.typeToEmail(emailtest);
		newCustomerPage.typeToPassword(passwordtest);
		customerRegMsg= newCustomerPage.clickToSubmit();
		customerRegMsg.getSuccessfullyText();
		verifyTrue(customerRegMsg.isDisplayHomePage(homepagevalue));
		customerId = customerRegMsg.getCustomerIDText();
		//System.out.println(customerId);
		newCustomerPage = customerRegMsg.openNewCustomerPage(driver);
		// create acc2
		newCustomerPage.typeToCustomerName(customername);
		newCustomerPage.isSelectRadioButton();
		newCustomerPage.typeToDateOfBirth(dateofbirth);
		newCustomerPage.typeToAddress(address);
		newCustomerPage.typeToCity(city);
		newCustomerPage.typeToState(state);
		newCustomerPage.typeToPin(pin);
		newCustomerPage.typeToMobileNumber(mobilenubmer);
		newCustomerPage.typeToEmail(newemail);
		newCustomerPage.typeToPassword(passwordtest);
		customerRegMsg = newCustomerPage.clickToSubmit();
		customerRegMsg.getSuccessfullyText();
		verifyTrue(customerRegMsg.isDisplayHomePage(homepagevalue));
		customerId1 = customerRegMsg.getCustomerIDText();
	}

	@Test
	public void TC_02_EditCustomerSuccessfully() {
		editCustomerPage = customerRegMsg.openEditCustomerPage(driver);
		editCustomerPage.typeToCustomerId(customerId);
		editCustomerPage.clickToSubmitButton();
		editCustomerPage.typeToAddress(newaddress);
		editCustomerPage.typeToCity(newcity);
		editCustomerPage.typeToState(newstate);
		editCustomerPage.typeToPin(newpin);
		editCustomerPage.typeToMobileNumber(newmobilenubmer);
		editCustomerPage.typeToEmail(newemail);
		customerUpdateMsg=editCustomerPage.clickToEditSubmitButton();
		verifyTrue(customerUpdateMsg.isDisplayEditSuccessfully(editsuccessfully));
	}

	@Test
	public void TC_03_AddNewAccountSuccessfully() {
		// create acc1
		newAccountPage = customerUpdateMsg.openNewAccountPage(driver);
		newAccountPage.typeCustomerId(customerId);
		newAccountPage.selecAccountTypedropdown(accounttype);
		newAccountPage.typeInitialDeposit(initialdeposit);
		newAccountPage.clickToSubmitButton();
		verifyTrue(newAccountPage.isDisplayGeneratedAccSuccessfully(generatedaccsuccessfully));
		accountId = newAccountPage.getAccountID();
		verifyEquals(newAccountPage.getCurrentAmount(), currentamount);
		// create acc2
		newAccountPage = homePage.openNewAccountPage(driver);
		newAccountPage.typeCustomerId(customerId1);
		newAccountPage.selecAccountTypedropdown(accounttype);
		newAccountPage.typeInitialDeposit(initialdeposit);
		newAccountPage.clickToSubmitButton();
		verifyTrue(newAccountPage.isDisplayGeneratedAccSuccessfully(generatedaccsuccessfully));
		accountId1 = newAccountPage.getAccountID();
	}

	@Test
	public void TC_04_TransferMoneyToCurrentAccount() {
		depositPage = newAccountPage.openDepositPage(driver);
		depositPage.typeToAccountNo(accountId);
		depositPage.typeToAmount(amount);
		depositPage.typeToDes(description);
		depositPage.clickToSubmit();
		verifyTrue(depositPage.isDisplaytranactionmessage(transactionmessage + accountId));	
		verifyEquals(depositPage.getCurrentBalance(), currentbalance);
	}

	@Test
	public void TC_05_WithdrawalMoney() {
		withdrawal = depositPage.openWithdrawalPage(driver);
		withdrawal.typeToAccountNo(accountId);
		withdrawal.typeToAmount("15000");
		withdrawal.typeToDes("Withdraw");
		withdrawal.clickToSubmit();
		verifyTrue(withdrawal.isDisplaytranactionmessage(withdrawalmessage + accountId));
		verifyEquals(withdrawal.getCurrentBalance(), "40000");
	}

	@Test
	public void TC_06_TranferMoney() {
		fundtransfer = withdrawal.openFundtransferPage(driver);
		fundtransfer.typeToPayersAccountNo(accountId);
		fundtransfer.typeToPayeesAccountNo(accountId1);
		fundtransfer.typeToAmount("10000");
		fundtransfer.typeToDes("Transfer");
		fundtransfer.clickToSubmit();
		verifyTrue(fundtransfer.isDisplayFromAccountNo(accountId));
		verifyEquals(fundtransfer.getCurrentBalance(), "10000");
	}

	@Test
	public void TC_07_BalanceDetais() {
		balanceequiry = fundtransfer.openBalanceEnquiryPage(driver);
		balanceequiry.typeToAccountNo(accountId);
		balanceequiry.clickToSubmit();
		verifyTrue(balanceequiry.isDisplaybalancedetailsmessage(balancedetailsmessage + accountId));
		verifyEquals(balanceequiry.getCurrentBalance(), "30000");
	}

	@Test
	public void TC_08_DeleteAccountSuccessfully() {
		deleteaccount = balanceequiry.openDeleteAccountPage(driver);
		deleteaccount.typeToAccountNo(accountId);
		deleteaccount.clickToSubmit();
		deleteaccount.closeAlert(driver);
		verifyEquals(deleteaccount.deleteAccountSuccessfully(), deletemessage);
		deleteaccount.closeAlert(driver);
	}

	@Test
	public void TC_09_DeleteCustomerSuccessfully() {
		deletecustomer = deleteaccount.openDeleteCustomerPage(driver);
		deletecustomer.typeToCustomerNo(customerId);
		deletecustomer.clickToSubmit();
		deletecustomer.closeAlert(driver);
		verifyEquals(deletecustomer.deleteCustomerSuccessfully(), deletecustomersuccessfully);
		deletecustomer.closeAlert(driver);
	}

	@AfterClass
	public void afterClass() {
		closeBrowser(driver);
	}

	private NewCustomerPage newCustomerPage;
	private LoginPage loginPage;
	private RegisterPage registerPage;
	private CustomerRegMsg customerRegMsg;
	private CustomerUpdateMsg customerUpdateMsg;
	private HomePage homePage;
	private EditCustomerPage editCustomerPage;
	private NewAccountPage newAccountPage;
	private DepositPage depositPage;
	private Withdrawal withdrawal;
	private Fundtransfer fundtransfer;
	private BalanceEquiry balanceequiry;
	private DeleteAccount deleteaccount;
	private DeleteCustomer deletecustomer;
	private String customerId, customername, dateofbirth, address, newaddress, city, newcity, state, newstate, pin,
			newpin, mobilenubmer, newmobilenubmer, emailtest, newemail, passwordtest, homepagevalue, editsuccessfully;
	private String		accounttype, initialdeposit, generatedaccsuccessfully, accountId, currentamount;
	private String amount, description, transactionmessage, currentbalance, withdrawalmessage, customerId1, accountId1;
	private String balancedetailsmessage, deletemessage, deletecustomersuccessfully;
}
