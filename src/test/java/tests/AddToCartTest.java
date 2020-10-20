package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageobjects.LoginPage;
import utils.AllureAttachment;

@Epic("Shopping Cart")
@Feature("Add To Cart")
public class AddToCartTest extends BaseTest{
	@Story("As a user, I'm adding and item to the shopping cart")
	@Description("Verified adding items to cart")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 3, description = "Add an item to the shopping cart")
	public void tc01_addToCart() {
		LoginPage lp = new LoginPage(driver);
		lp.addToCart("Dress");
		String actual = lp.getProductAddedMsg();
		String expected = "Product successfully added to your shopping cart";
		Assert.assertEquals(actual, expected);
		if(actual.contains(expected)) {
			AllureAttachment.attachText("Add an item to the shopping cart Completed!");
		}
		
		
	}
	@Description("Verified adding items to cart")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1, description = "Add an item to the shopping cart and press on continue shopping")
	public void tc02_addToCart() {
		LoginPage lp = new LoginPage(driver);
		lp.addToCart("Dress");
		lp.continueShopping();
	
		
	}
	@Description("Verified adding items to cart")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority =2, description = "Add an item to the shopping cart and proceed to checkout" )
	public void tc03_addToCart() {
		LoginPage lp = new LoginPage(driver);
		lp.addToCart("Dress");
		lp.proceedToCheckout();
		String expected = "Shopping-cart summary";
		String actual = lp.getCartTitle();
		if(!actual.contains(expected.toUpperCase()))
		Assert.assertEquals(actual, expected);
	}

}
