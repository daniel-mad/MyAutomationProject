package tests;

import org.testng.annotations.Test;

import pageobjects.LoginPage;
import io.qameta.allure.*;

@Epic("Shopping Cart")
@Feature("Remove From Cart")

public class RemoveFromCartTest extends BaseTest {
	@Description("Verified Removing an item from the shopping cart")
	@Severity(SeverityLevel.CRITICAL)
	@Test(description = "Remove from the Shopping-Cart Summery")
	public void tc01_removeFromCart() {
		LoginPage lp = new LoginPage(driver);
		lp.addToCart("dress");
		lp.addToCart("dress");
		lp.continueShopping();
		lp.viewShoppingCart();
		lp.delFirstProduct();
	}
	@Description("Verified Removing an item from the shopping cart")
	@Severity(SeverityLevel.CRITICAL)
	@Test(description = "Remove from the Cart menu window")
	public void tc02_removeFromCart() {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.addToCart("dress");
		lp.continueShopping();
		lp.moveToShoppigCart();
		lp.delFirstProductFromManu();
	}

}
