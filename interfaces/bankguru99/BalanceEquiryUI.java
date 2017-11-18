package bankguru99;

public class BalanceEquiryUI {
	public static String ACCOUNT_NO_TEXTBOX = "//input[@name='accountno']";
	public static String SUBMIT_BUTTON = "//input[@name='AccSubmit']";
	public static String BALANCE_DETAILS = "//p[contains(text(),'Balance Details for Account')]";
	public static String BALANCE_AMOUNTS = "//td[contains(text(),'Balance')]//following-sibling::td";
}
