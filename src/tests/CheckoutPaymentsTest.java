package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import pageobjects.LoginPage;

public class CheckoutPaymentsTest extends BaseTest{
	@Test(description = "Proceed to checkout payment by Bank-wire")
	public void tc01_checkoutPay() {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.signIn("daniel@daniel.com", "12345");
		lp.addToCart("dress");
		lp.proceedToCheckout();
		
		lp.payment("Bank wire");
		String expected = "Your order on My Store is complete.";
		String actual = lp.getOrderConfirm();
		Assert.assertEquals(expected, actual);
		lp.logOut();
			
	}
	@Test(description = "Proceed to checkout payment by Check")
	public void tc02_checkoutPay() {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.signIn("daniel@daniel.com", "12345");
		lp.addToCart("dress");
		lp.proceedToCheckout();
		
		lp.payment("Check");
		String expected = "Your check must include:";
		String actual = driver.findElement(By.cssSelector(".page-subheading")).getText();
		Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase());
		lp.logOut();
			
	}
	@Test(description = "Proceed to checkout without agree to terms of service")
	public void tc03_checkoutPay() {
		LoginPage lp = new LoginPage(driver);
		lp.clickSignIn();
		lp.signIn("daniel@daniel.com", "12345");
		lp.addToCart("dress");
		lp.proceedToCheckout();
		lp.payWithOutAgree();
		String expected = "You must agree to the terms of service before continuing.";
		String actual = driver.findElement(By.cssSelector(".fancybox-error")).getText();
		Assert.assertEquals(expected.toLowerCase(), actual.toLowerCase());
			
	}

}
