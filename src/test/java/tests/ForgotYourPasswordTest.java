package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.ForgotYourPasswordPage;
import pageobjects.LoginPage;
import io.qameta.allure.*;

@Epic("Account")
@Feature("Forgot Your Password")
public class ForgotYourPasswordTest extends BaseTest {
	@Description("Verified Forgot your password")
	@Severity(SeverityLevel.NORMAL)
	@Test(description = "Enter valid email address that exists in the system")
	public void tc01_forgotYourPassword() {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.forgotPassword();
		ForgotYourPasswordPage fyp = new ForgotYourPasswordPage(driver);
		String email = "daniel@daniel.com";
		fyp.forgotYourPassword(email);
		String expected  = "A confirmation email has been sent to your address: "+ email;
		String actual = fyp.getMsgSuccess();
		Assert.assertEquals(actual, expected);
		
	}
	@Description("Verified Forgot your password")
	@Severity(SeverityLevel.NORMAL)
	@Test(description = "Enter valid email address that not exists in the system")
	public void tc02_forgotYourPassword() {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.forgotPassword();
		ForgotYourPasswordPage fyp = new ForgotYourPasswordPage(driver);
		String email = "daniel2020@daniel.com";
		fyp.forgotYourPassword(email);
		String expected  = "There is no account registered for this email address.";
		String actual = fyp.getErrMsg();
		Assert.assertEquals(actual, expected);
		
	}
	@Description("Verified Forgot your password")
	@Severity(SeverityLevel.NORMAL)
	@Test(description = "Enter invalid email address ")
	public void tc03_forgotYourPassword() {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.forgotPassword();
		ForgotYourPasswordPage fyp = new ForgotYourPasswordPage(driver);
		String email = "daniel";
		fyp.forgotYourPassword(email);
		String expected  = "Invalid email address.";
		String actual = fyp.getErrMsg();
		Assert.assertEquals(actual, expected);
		
	}

}
