package tests;

import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;


import pageobjects.ContactUsPage;
import pageobjects.LoginPage;

public class ContactUsTest extends BaseTest{
	

	
	@Test(description = "Send a customer service message with valid information")
	public void tc01_sendMessage() {
		LoginPage lp = new LoginPage(driver);
		lp.clickContactUsBtn();
		ContactUsPage cup = new ContactUsPage(driver);
		cup.sendCustomerServiceMessage("daniel@daniel.com", "00123", "Sending a Test Message");
		String actual = cup.getValidMsg();
		String expected = "Your message has been successfully sent to our team.";
		Assert.assertEquals(expected, actual);
		
	}
	@Test(description = "Send a webmaster message with valid information")
	public void tc02_sendMessage() {
		LoginPage lp = new LoginPage(driver);
		lp.clickContactUsBtn();
		ContactUsPage cup = new ContactUsPage(driver);
		cup.sendWebMasterMessage("daniel@daniel.com", "00123", "Sending a Test Message");
		String actual = cup.getValidMsg();
		String expected = "Your message has been successfully sent to our team.";
		Assert.assertEquals(expected, actual);
		
	}
	@Test(description = "Send a message with no subject")
	public void tc03_sendMessage() {
		LoginPage lp = new LoginPage(driver);
		lp.clickContactUsBtn();
		ContactUsPage cup = new ContactUsPage(driver);
		cup.sendMessage("daniel@daniel.com", "00123", "Sending a Test Message");
		String actual = cup.geterrorMsg();
		String expected = "Please select a subject from the list provided.";
		Assert.assertEquals(expected, actual);
		
	}
	@Test(description = "Send a message with no email")
	public void tc04_sendMessage() {
		LoginPage lp = new LoginPage(driver);
		lp.clickContactUsBtn();
		ContactUsPage cup = new ContactUsPage(driver);
		cup.sendMessage("", "00123", "Sending a Test Message");
		String actual = cup.geterrorMsg();
		String expected = "Invalid email address.";
		Assert.assertEquals(expected, actual);
		
	}
	@Test(description = "Send a message with no message")
	public void tc05_sendMessage() {
		LoginPage lp = new LoginPage(driver);
		lp.clickContactUsBtn();
		ContactUsPage cup = new ContactUsPage(driver);
		cup.sendMessage("daniel@daniel.com", "00123", "");
		String actual = cup.geterrorMsg();
		String expected = "The message cannot be blank.";
		Assert.assertEquals(expected, actual);
		
	}

}
