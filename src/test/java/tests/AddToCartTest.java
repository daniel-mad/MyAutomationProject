package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPage;

public class AddToCartTest extends BaseTest{
	@Test(priority = 3, description = "Add item to shopping cart")
	public void tc01_addToCart() {
		LoginPage lp = new LoginPage(driver);
		lp.addToCart("Dress");
		String actual = lp.getProductAddedMsg();
		String expected = "Product successfully added to your shopping cart";
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(priority = 1, description = "Add item to shopping cart and press on continue shopping")
	public void tc02_addToCart() {
		LoginPage lp = new LoginPage(driver);
		lp.addToCart("Dress");
		lp.continueShopping();
	
		
	}
	@Test(priority =2, description = "Add item to shopping cart and proceed to checkout" )
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
