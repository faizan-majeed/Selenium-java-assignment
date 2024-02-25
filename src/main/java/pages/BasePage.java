package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ESTTimeZone;
import utils.ExtentTestManager;
import utils.Utility;
import utils.WebSetup;
import java.time.Duration;
import java.util.List;

public class BasePage {
	public WebDriver getWebDriver() {
		return WebSetup.getInstance().initDriver();
	}
	
	public void loadPage(String base_url) {
		ExtentTestManager.getTest().info("Opening URL: " + base_url );
		getWebDriver().get(base_url);
		Utility.attachWebScreenShotToReport(ExtentTestManager.name+"_"+ ESTTimeZone.getCurrentDate("dd_MM_yyyy_HH_mm_ss_ms"));
	}
	
	public void refreshPage() {
		getWebDriver().navigate().refresh();
	}
	
	public WebElement waitForElementToBePresent(By webElement, int timeOutInSeconds) {
		//ExtentTestManager.getTest().info("Waiting for elements to be present " + webElement.toString());
		WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		return (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(webElement));
	}
	
	public List<WebElement> waitForElementsToBePresent(By webElement, int timeOutInSeconds) {
		//ExtentTestManager.getTest().info("Waiting for elements to be present " + webElement.toString());
		WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		return (List<WebElement>) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(webElement));
	}
	
	public WebElement waitForElementToBeClickable(By webElement, int timeOutInSeconds) {
		//ExtentTestManager.getTest().info("Waiting for element to be clickable " + webElement.toString());
		WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	public WebElement waitForElementToBeVisible(By webElement, int timeOutInSeconds) {
		//ExtentTestManager.getTest().info("Waiting for elements to be present " + webElement.toString());
		WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
	}
	
	public void waitForElementToBeInvisible(By webElement, int timeOutInSeconds) {
		//ExtentTestManager.getTest().info("Waiting for elements to be present " + webElement.toString());
		WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(webElement));
	}
	
	public void clickElement(WebElement element, String elementLabel) {
		ExtentTestManager.getTest().info("Clicking " + elementLabel);
		element.click();
	}
	
	public WebElement findElement(By locator) {
		return (WebElement) getWebDriver().findElement(locator);
		
	}
	
	public WebElement findElements(By locator) {
		return (WebElement) getWebDriver().findElements(locator);
		
	}

	public void sendKeysToElement(WebElement element, String keys,String elementLabel) {
		ExtentTestManager.getTest().info("Entering "+ elementLabel + ": " + keys);
		element.clear();
		element.sendKeys(keys);
	}
	
	public String getElementText(WebElement element, String elementLabel) {
		ExtentTestManager.getTest().info("Getting "+elementLabel+ " text: "+  element.getText());
		return element.getText();
	}
	
	public String getElementValueAttribute(WebElement element, String elementLabel) {
		ExtentTestManager.getTest().info("Getting "+elementLabel+ " value" );
		return element.getAttribute("value");
	}
	
	public void scrollTillEnd() {
		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scrollToElement(WebElement element, String elementLabel) {
		ExtentTestManager.getTest().info("Scroll to  "+elementLabel);
		((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void mouseOverElement(WebElement element, String elementLabel) {
		ExtentTestManager.getTest().info("Mouse over "+ elementLabel);
		Actions action = new Actions(getWebDriver());
		action.moveToElement(element).perform();
	}

}
