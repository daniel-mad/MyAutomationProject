package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LoginPage;
import utils.AllureAttachment;
import utils.Excel;

import io.qameta.allure.*;

@Epic("Login")
@Feature("Account Login")

public class LoginTest extends BaseTest {
	@Description("Verified Login")
	@Severity(SeverityLevel.NORMAL)
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

	@Description("Verified Login")
	@Severity(SeverityLevel.CRITICAL)
	@Test(dataProvider = "getData", description = "Login with valid email and wrong password - using DDT")
	public void tc02_login(String user, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.signIn(user, password);
		String expected = "Authentication failed.";
		String actual = lp.getErrorMsg();
		Assert.assertEquals(actual, expected);
		//Attach Log text
		AllureAttachment.attachText("This is a text message");
		// Attach JSON
		AllureAttachment.attachJson("{\n" + "    \"glossary\": {\n" + "        \"title\": \"example glossary\",\n"
				+ "\t\t\"GlossDiv\": {\n" + "            \"title\": \"S\",\n" + "\t\t\t\"GlossList\": {\n"
				+ "                \"GlossEntry\": {\n" + "                    \"ID\": \"SGML\",\n"
				+ "\t\t\t\t\t\"SortAs\": \"SGML\",\n"
				+ "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n"
				+ "\t\t\t\t\t\"Acronym\": \"SGML\",\n" + "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n"
				+ "\t\t\t\t\t\"GlossDef\": {\n"
				+ "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n"
				+ "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" + "                    },\n"
				+ "\t\t\t\t\t\"GlossSee\": \"markup\"\n" + "                }\n" + "            }\n" + "        }\n"
				+ "    }\n" + "}");
		// Attach XML
		AllureAttachment.attachXml("<note>\n" + "<to>Daniel Madhala</to>\n" + "<from>Admin</from>\n"
				+ "<heading>Reminder</heading>\n" + "<body>Don't forget me this weekend!</body>\n" + "</note>");
		// Attach CSV
		AllureAttachment.attachCSV(
				"John,Doe,120 jefferson st.,Riverside, NJ, 08075\n" + "Jack,McGinnis,220 hobo Av.,Phila, PA,09119\n"
						+ "\"John \"\"Da Man\"\"\",Repici,120 Jefferson St.,Riverside, NJ,08075\n"
						+ "Stephen,Tyler,\"7452 Terrace \"\"At the Plaza\"\" road\",SomeTown,SD, 91234\n"
						+ ",Blankman,,SomeTown, SD, 00298\n"
						+ "\"Joan \"\"the bone\"\", Anne\",Jet,\"9th, at Terrace plc\",Desert City,CO,00123");
		//Attach URL
		AllureAttachment.attachURL("https://github.com/daniel-mad/MyAutomationProject");

	}
	

	@Description("Verified Login")
	@Severity(SeverityLevel.CRITICAL)
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
		Object[][] myData = { { "daniel@daniel.com", "45e33" }, { "daniel@daniel.com", "65ttg43" },
				{ "daniel@daniel.com", "9hhh99" } };
		return myData;
	}

	@DataProvider
	public Object[][] getDataFromExcel() {
		String excelPath = System.getProperty("user.dir") + "/src/test/java/data/input.xlsx";
		Object[][] table = Excel.getTableArray(excelPath, "Login");
		return table;
	}

}
