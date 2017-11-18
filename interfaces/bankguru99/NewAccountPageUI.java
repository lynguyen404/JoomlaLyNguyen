package bankguru99;

public class NewAccountPageUI {
	public static String CUSTOMER_ID_TEXTBOX = "//input[@name='cusid']";
	public static String ACCOUNT_TYPE_DROPDOWN = "//select[@name='selaccount']";

	public static String INITIAL_DEPOSIT_TEXTBOX = "//input[@name='inideposit']";
	public static String SUBMIT_BUTTON = "//input[@value='submit']";

	public static String GENERATED_ACCOUNT_SUCCESSFULLY = "//p[contains(text(),'Account Generated Successfully!!!')]";
	public static String ACCOUNT_ID = "//td[contains(text(),'Account ID')]/following-sibling::td";
	public static String CURRENT_AMOUNT = "//td[contains(text(),'Current Amount')]/following-sibling::td";
}
