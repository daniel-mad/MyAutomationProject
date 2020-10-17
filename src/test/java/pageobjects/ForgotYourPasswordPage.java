package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotYourPasswordPage extends BasePage {
	@FindBy(css = "#email")
	private WebElement emailField;
	@FindBy(css = ".submit [type='submit']")
	private WebElement submitBtn;
	@FindBy(css = ".alert-success")
	private WebElement alertSuccess;
	@FindBy(css = ".alert-danger > ol > li")
	private WebElement errMsg;
	

	public ForgotYourPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	public void forgotYourPassword(String email) {
		fillText(emailField, email);
		click(submitBtn);
	}
	
	public String getMsgSuccess() {
		return alertSuccess.getText();
	}
	public String getErrMsg() {
		return errMsg.getText();
	}

}
