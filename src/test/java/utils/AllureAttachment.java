package utils;

import java.nio.charset.StandardCharsets;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.underscore.lodash.U;

import io.qameta.allure.Attachment;

public class AllureAttachment {

	// Text attachment for allure
	@Attachment(value = "{0}", type = "text/plain", fileExtension = ".txt")
	public static String attachText(String message) {
		return message;
	}

	// Image attachment for allure
	@Attachment(value = "Page Screenshot", type = "image/png", fileExtension = ".png")
	public static byte[] attachScreenshot(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	// HTML page source attachment for Allure
	@Attachment(value = "Html source", type = "text/html", fileExtension = ".html")
	public static byte[] getPageSource(WebDriver driver) {
		return driver.getPageSource().getBytes(StandardCharsets.UTF_8);
	}

	// Element ScreenShot attachment for Allure
	@Attachment(value = "Element Screenshot", type = "image/png", fileExtension = ".png")
	public static byte[] attachElementScreenshot(WebElement element) {
		return element.getScreenshotAs(OutputType.BYTES);
	}

	// JSON attachment for Allure
	@Attachment(value = "JSON attachment", type = "application/json", fileExtension = ".json")
	public static String attachJson(String json) {
		return U.formatJson(json);
	}

	// XML attachment for Allure
	@Attachment(value = "XML attachment", type = "application/xml", fileExtension = ".xml")
	public static String attachXml(String xml) {
		return U.formatXml(xml);
	}

	// CSV attachment for Allure
	@Attachment(value = "CSV attachment", type = "text/csv", fileExtension = ".csv")
	public static String attachCSV(String csv) {
		return csv;
	}

	// URL attachment for Allure
	@Attachment(value = "URL attachment", type = "text/uri-list", fileExtension = ".uri")
	public static String attachURL(String url) {
		return url;
	}

}
