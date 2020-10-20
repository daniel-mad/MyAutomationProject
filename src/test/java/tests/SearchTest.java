package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import io.qameta.allure.*;

@Epic("Search")
@Feature("Searching Angine")

public class SearchTest extends BaseTest {
	@Description("Verified Searching")
	@Severity(SeverityLevel.NORMAL)
	@Test(description = "Search an item that existed")
	public void tc01_searchTest(){
		LoginPage lp = new LoginPage(driver);
		lp.searchItem("Dress");
		String actual = lp.getSearchMsg();
		String expected = "results have been found.";
		if(!actual.contains(expected)) {
			Assert.assertEquals(actual, expected);
		}
		
	}
	@Description("Verified Searching")
	@Severity(SeverityLevel.NORMAL)
	@Test(description = "Search an item that not exists")
	public void tc02_searchTest(){
		LoginPage lp = new LoginPage(driver);
		String item = "falafel";
		lp.searchItem(item);
		String actual = lp.getSearchErrMsg();
		String expected = "No results were found for your search " + "\"" + item + "\"";
		if(!actual.contains(expected)) {
			Assert.assertEquals(actual, expected);
		}
		
	}
	@Description("Verified Searching")
	@Severity(SeverityLevel.NORMAL)
	@Test(description = "Search an item by clicking Women category")
	public void tc03_searchTest() {
		LoginPage lp = new LoginPage(driver);
		lp.searchByCategory("women");
		String actual = lp.getCategoryMsg();
		String expected = "Women";
		Assert.assertEquals(actual, expected);
	}
	@Description("Verified Searching")
	@Severity(SeverityLevel.NORMAL)
	@Test(description = "Search an item by clicking Dresses category")
	public void tc04_searchTest() {
		LoginPage lp = new LoginPage(driver);
		lp.searchByCategory("dresses");
		String actual = lp.getCategoryMsg();
		String expected = "Dresses";
		Assert.assertEquals(actual, expected);
	}
	@Description("Verified Searching")
	@Severity(SeverityLevel.NORMAL)
	@Test(description = "Search an item by clicking T-shirts category")
	public void tc05_searchTest() {
		LoginPage lp = new LoginPage(driver);
		lp.searchByCategory("t-shirts");
		String actual = lp.getCategoryMsg();
		String expected = "T-shirts";
		Assert.assertEquals(actual, expected);
	}

}
