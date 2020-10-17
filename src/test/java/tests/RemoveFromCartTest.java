package tests;

import org.testng.annotations.Test;

import pageobjects.LoginPage;

public class RemoveFromCartTest extends BaseTest {
	@Test(description = "Remove from Shopping-Cart Summery")
	public void tc01_removeFromCart() {
		LoginPage lp = new LoginPage(driver);
		lp.addToCart("dress");
		lp.addToCart("dress");
		lp.continueShopping();
		lp.viewShoppingCart();
		lp.delFirstProduct();
	}

	@Test(description = "Remove from Cart menu window")
	public void tc02_removeFromCart() {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.addToCart("dress");
		lp.continueShopping();
		lp.moveToShoppigCart();
		lp.delFirstProductFromManu();
	}

}
