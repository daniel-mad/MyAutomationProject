package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	Actions actions;
	JavascriptExecutor js; 
	WebDriverWait wait; 


	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		actions =  new Actions(driver);
		PageFactory.initElements(driver, this);
		js= (JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, 15);
	}
	public void click(WebElement el) {
		waitForClickableElement(el);
		highlightElement(el, "yellow");
		el.click();
	}
	public void fillText(WebElement el, String text) {
		waitForVisibleElement(el);
		highlightElement(el, "yellow");
		el.clear();
		el.sendKeys(text);
	}
	public void selectByValue(WebElement el, String value) {
		waitForVisibleElement(el);
		Select s =  new Select(el);
		s.selectByValue(value);
	}
	public void selectByVisibleText(WebElement el, String text) {
		waitForVisibleElement(el);
		Select s = new Select(el);
		s.selectByVisibleText(text);;
	}
	public String getText(WebElement el) {
		waitForVisibleElement(el);
		return el.getText();
	}

	public void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void waitForClickableElement(WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}
	
	public void waitForVisibleElement(WebElement el) {
		wait.until(ExpectedConditions.visibilityOf(el));
	}
	
	//Mouse option
	public void moveTo(WebElement el) {
		waitForClickableElement(el);
		actions.moveToElement(el).build().perform();
	}
	//Double Click
	public void doubleClick(WebElement el) {
		waitForClickableElement(el);
		actions.doubleClick(el).perform();
	}
	
//	highlight elements
	protected void highlightElement(WebElement element, String color) {
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "border: 1px solid black; background-color:" + color + ";" + originalStyle;
		
		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		// Change the style back after few miliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}
}
