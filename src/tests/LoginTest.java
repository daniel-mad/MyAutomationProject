package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import utils.Excel;

public class LoginTest extends BaseTest {
	@Test(description = "Login with valid user name and password")
	public void tc01_login() {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.signIn("daniel@daniel.com", "12345");
		String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
		String actual = lp.getSucceedLoginText();
		Assert.assertEquals(actual, expected);
		lp.logOut();
	}

	@Test(dataProvider = "getData", description = "Login with valid email and wrong password - using DDT")
	public void tc02_login(String user, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.signIn(user, password);
		String expected = "Authentication failed.";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);

	}
	
	@Test(dataProvider = "getDataFromExcel", description = "Login with wrong email and wrong password - using excel")
	public void tc03_login(String user, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.signIn(user, password);
		String expected = "Invalid email address.";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);

	}
	
	@Test(description = "Login with no email and no password")
	public void tc04_login() {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.signIn("", "");
		String expected = "An email address required.";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { { "111@222.com", "45e33" }, { "111@222.com", "65ttg43" }, { "111@222.com", "9hhh99" } };
		return myData;
	}
	@DataProvider
	public Object[][] getDataFromExcel(){
		String excelPath = System.getProperty("user.dir") + "/src/data/input.xlsx";
		Object[][] table = Excel.getTableArray(excelPath, "Login");
		return table;
	}

}
