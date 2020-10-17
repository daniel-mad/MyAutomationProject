package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactUsPage extends BasePage {
	@FindBy(css = "#id_contact")
	private WebElement subject;
	@FindBy(css = "#email")
	private WebElement email;
	@FindBy(css = "#id_order")
	private WebElement orderNumber;
	@FindBy(css = "#message")
	private WebElement message;
	@FindBy(css = "#submitMessage")
	private WebElement sendBtn;
	@FindBy(css = ".alert-success")
	private WebElement validMsg;
	@FindBy(css = ".alert-danger >ol > li")
	private WebElement errMsg;

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	public void sendCustomerServiceMessage(String email, String orderNum, String message) {
		selectByValue(subject, "2");
		fillText(this.email, email);
		fillText(orderNumber, orderNum);
		fillText(this.message, message);
		click(sendBtn);

	}

	public void sendWebMasterMessage(String email, String orderNum, String message) {
		selectByValue(subject, "1");
		fillText(this.email, email);
		fillText(orderNumber, orderNum);
		fillText(this.message, message);
		click(sendBtn);
		
	}
	public void sendMessage(String email, String orderNum, String message) {
		sleep(1000);
		fillText(this.email, email);
		fillText(orderNumber, orderNum);
		fillText(this.message, message);
		sleep(1000);
		click(sendBtn);
		
	}
	public String getValidMsg() {
		return validMsg.getText();
	}
	public String geterrorMsg() {
		return errMsg.getText();
	}

}
