package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.CreateAccountPage;
import pageobjects.LoginPage;
import pageobjects.MyAccountPage;

public class CreateAccountTest extends BaseTest {
	@Test(description = "Create an account with valid information")
	public void tc01_createAccount() {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.createAnAccount("daniel@daniel5558.com");
		CreateAccountPage cap = new CreateAccountPage(driver);
		cap.createMaleAcct("Daniel", "Madhala", "daniel@daniel5558.com", "12345", "03/06/1987", "My Company", "Address",
				"New City", "Alabama", "00000", "050987654", "My Home");
		MyAccountPage map = new MyAccountPage(driver);
		String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
		String actual = map.getMsg();
		Assert.assertEquals(expected, actual);

	}
	
	@Test(description = "Create an acount with wrong information")
	public void tc02_createAccount() {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.createAnAccount("daniel1113@daniel.co.il");
		CreateAccountPage cap = new CreateAccountPage(driver);
		cap.clickSubmit();
		String expected = "There are";
		String actual = cap.getErrorMsg();
		if(actual.contains(expected))
			expected = actual;
		Assert.assertEquals(expected, actual);

	}
	
	

	@Test(description = "Create an account using existing email")
	public void tc03_createAccount() {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.createAnAccount("daniel@daniel.com");
		String expected = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
		String actual = lp.getErrorCreateAcct();
		Assert.assertEquals(expected, actual);

	}

}
