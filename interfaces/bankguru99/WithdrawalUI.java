package bankguru99;

public class WithdrawalUI {
	public static String ACCOUNT_NO_TEXTBOX = "//input[@name='accountno']";
	public static String AMOUNT_TEXTBOX = "//input[@name='ammount']";
	public static String DES_TEXTBOX = "//input[@name='desc']";
	public static String SUBMIT_BUTTON = "//input[@name='AccSubmit']";
	public static String TRANSACTION_DETAILS = "//p[contains(text(),'Transaction details of Withdrawal for Account')]";
	public static String CURRENT_BALANCE = "//td[contains(text(),'Current Balance')]//following-sibling::td";
}
