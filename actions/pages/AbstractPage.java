package pages;

import java.io.IOException;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	WebDriver driver;

	public void openURL(WebDriver driver, String url) {
		driver.get(url);

	}

	public String getURL(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public void backURL(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardURL(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshURL(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void senkeyToElement(WebDriver driver, String locator, String expected) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(expected);
	}

	public String getTextOfElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getAttributeOfElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(locator);
	}

	public boolean isDisplayedElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isDisplayedElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isEnableElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public boolean isEnableElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public boolean isSelectedElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isSelectedElement(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String expected) {
		Select element = new Select(driver.findElement(By.xpath(locator)));
		element.selectByVisibleText(expected);

	}

	public void verifyDropdownSelected(WebDriver driver, String locator, String expected) {
		Select element = new Select(driver.findElement(By.xpath(locator)));
		element.selectByVisibleText(expected);
		String actualtext = driver.findElement(By.xpath(locator)).getText();
		Assert.assertTrue(expected.equals(actualtext));
	}

	public void verifyText(WebDriver driver, String locator, String expected) {
		WebElement element = driver.findElement(By.xpath(locator));
		String actualtext = element.getText();
		Assert.assertTrue(expected.equals(actualtext));
	}

	public void isCheckedCheckbox(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void isUnCheckedCheckbox(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendKeyToAlert(String expected) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(expected);
	}

	public void swithWinDownById(String parent) {
		Set<String> allwindowns = driver.getWindowHandles();
		for (String childwindown : allwindowns) {
			if (!childwindown.equals(parent)) {
				driver.switchTo().window(childwindown);
				break;
			}

		}
	}

	public void uploadFile(String fileexe, String firepath) throws IOException {
		Runtime.getRuntime().exec(new String[] { fileexe, firepath });
	}

	public Object excuteJavascripToBrowser(String Javascrip) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(Javascrip);
	}

	public Object excuteJavascripToElement(String Javasript, WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(Javasript, Element);
	}

	public Object excuteRemoveAttribute(WebDriver driver, String controlName, String attribute) {
		WebElement Element = driver.findElement(By.xpath(controlName));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", Element);
	}

	public void scrollToBottom() {
		excuteJavascripToBrowser("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void scrollToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void waitForControlPresence(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void waitForControlVisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitForControlVisible(WebDriver driver, String locator, String value) {
		locator = String.format(locator, value);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitForControlClickable(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForControlNotVisible(String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void doubleClick(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public void hoverMouse(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void rightClick(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public void dragAndDrop(String source, String target) {
		WebElement from = driver.findElement(By.xpath(source));
		WebElement to = driver.findElement(By.xpath(target));
		Actions action = new Actions(driver);
		action.clickAndHold(from).moveToElement(to).release(to).build().perform();
	}
}

	