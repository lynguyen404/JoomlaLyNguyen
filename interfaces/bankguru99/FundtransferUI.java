package bankguru99;

public class FundtransferUI {
	public static String PAYERS_ACCOUNT_NO_TEXTBOX = "//input[@name='payersaccount']";
	public static String PAYEES_ACCOUNT_NO_TEXTBOX = "//input[@name='payeeaccount']";
	public static String AMOUNT_TEXTBOX = "//input[@name='ammount']";
	public static String DES_TEXTBOX = "//input[@name='desc']";
	public static String SUBMIT_BUTTON = "//input[@name='AccSubmit']";
	public static String FROM_ACCOUNT_ID = "//td[contains(text(),'From Account Number')]//following-sibling::td";
	public static String TRANSFER_AMOUNT = "//td[contains(text(),'Amount')]//following-sibling::td";
}
