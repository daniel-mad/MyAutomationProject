package pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage extends BasePage {
	@FindBy(css = ".login")
	private WebElement signInBarBtn;
	@FindBy(css = "#email_create")
	private WebElement createEmailAddessField;
	@FindBy(css = "#SubmitCreate")
	private WebElement submitCreateBtn;
	@FindBy(css = "#email")
	private WebElement emailField;
	@FindBy(css = "#passwd")
	private WebElement passwordField;
	@FindBy(css = "#SubmitLogin")
	private WebElement signInBtn;
	@FindBy(css = ".lost_password a")
	private WebElement forgotPassBtn;
	@FindBy(css = ".info-account")
	private WebElement loginTxt;
	@FindBy(css = ".alert-danger > ol > li")
	private WebElement errorMsg;
	@FindBy(css=".logout")
	private WebElement logOut;
	@FindBy(css= "#create_account_error > ol > li")
	private WebElement errorCreateAccount;
	@FindBy(css= "#search_query_top")
	private WebElement searchField;
	@FindBy(css= "#searchbox [type='submit']")
	private WebElement searchBtn;
	@FindBy(css= "a[title='Women']")
	private WebElement womenBtn;
	@FindBy(css= "#block_top_menu > ul >li:nth-child(2) > [title='Dresses']")
	private WebElement dressesBtn;
	@FindBy(css= ".menu-content > li:nth-child(3) > [title='T-shirts']")
	private WebElement tShirtsBtn;
	@FindBy(css = ".category-name")
	private WebElement categoryMsg;
	@FindBy(css = ".heading-counter")
	private WebElement searchMsg;
	@FindBy(css = ".alert-warning")
	private WebElement searchErrMsg;
	@FindBy(css = ".layer_cart_product h2")
	private WebElement productAddedMsg;
	@FindBy(css = "[type='submit'].exclusive")
	private WebElement addToCartBtn;
	@FindBy(css = "[title='Continue shopping']")
	private WebElement continueShoppingtBtn;
	@FindBy(css = "[title='Proceed to checkout']")
	private WebElement checkoutBtn;
	@FindBy(css = "#cart_title")
	private WebElement cartTitle;
	@FindBy(css = "[title = 'View my shopping cart']")
	private WebElement cartBtn;
	@FindBy(css = ".cart_quantity_delete")
	private List<WebElement> cartQuantityList;
	@FindBy(css = ".ajax_cart_block_remove_link")
	private List<WebElement> cartRemoveList;
	@FindBy(css = ".cart_navigation >.button-medium")
	private WebElement checkoutBtn2;
	@FindBy(css = "#uniform-cgv")
	private WebElement termAgree;
	@FindBy(css = ".cheque")
	private WebElement check;
	@FindBy(css = ".bankwire")
	private WebElement bankWire;
	@FindBy(css = "#contact-link")
	private WebElement contactUsBtn;
	@FindBy(css = ".logout")
	private WebElement signOutBtn;
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void clickSignIn() {
		waitForClickableElement(signInBarBtn);
		click(signInBarBtn);
	}
	public void clickContactUsBtn() {
		click(contactUsBtn);
	}
	public void logOut() {
		click(logOut);
	}

	public void createAnAccount(String email) {
		fillText(createEmailAddessField, email);
		click(submitCreateBtn);
	}
	
	public void signIn(String email, String password) {
		fillText(emailField, email);
		fillText(passwordField, password);
		click(signInBtn);
	}
	public void searchItem(String item) {
		waitForVisibleElement(searchField);
		fillText(searchField, item);
		waitForClickableElement(searchBtn);
		click(searchBtn);
	}
	public void searchByCategory(String category) {
		switch(category) {
		case "women":
			click(womenBtn);
			break;
		case "dresses":
			click(dressesBtn);
			break;
		case "t-shirts":
			click(tShirtsBtn);
			break;
		}
	}
	public void addToCart(String item) {
		searchItem(item);
		List<WebElement> list =driver.findElements(By.cssSelector(".ajax_block_product")) ;
		for(WebElement el : list) {
			doubleClick(el);
			click(driver.findElement(By.cssSelector(".ajax_add_to_cart_button")));
			
			break;
		}
		

	}
	
	public void continueShopping() {
		click(continueShoppingtBtn);
	}
	public void proceedToCheckout() {
		click(checkoutBtn);
	}
	public void payment(String payment) {
		waitForClickableElement(checkoutBtn2);
		click(checkoutBtn2);
		waitForClickableElement(checkoutBtn2);
		click(checkoutBtn2);
		waitForClickableElement(termAgree);
		click(termAgree);
		waitForClickableElement(checkoutBtn2);
		click(checkoutBtn2);
		
		if (payment.equalsIgnoreCase("Check")) {
			waitForClickableElement(check);
			click(check);
		}
		else {
			waitForClickableElement(bankWire);
			click(bankWire);
		}
		click(checkoutBtn2);
	}
	public void payWithOutAgree() {
		click(checkoutBtn2);
		click(checkoutBtn2);
		click(checkoutBtn2);
		
	}
	public void signOut() {
		click(signOutBtn);
	}
	
	public void forgotPassword() {
		click(forgotPassBtn);
	}
	public String getSucceedLoginText() {
		return loginTxt.getText();
	}
	public String getErrorMsg() {
		return errorMsg.getText();
	}
	public String getErrorCreateAcct() {
		return errorCreateAccount.getText();
	}
	public String getCategoryMsg() {
		return categoryMsg.getText();
	}
	public String getSearchMsg() {
		return searchMsg.getText();
	}
	public String getSearchErrMsg() {
		return searchErrMsg.getText();
	}
	public String getProductAddedMsg() {
		waitForVisibleElement(productAddedMsg);
		return productAddedMsg.getText();
	}
	public String getCartTitle() {
		return cartTitle.getText();
	}
	public String getOrderConfirm() {
		return driver.findElement(By.cssSelector(".cheque-indent")).getText();
	}
	public void viewShoppingCart() {
		click(cartBtn);
	}
	public void delFirstProduct() {
		for(WebElement el : cartQuantityList ) {
			click(el);
			break;
		}
	}
	public void delFirstProductFromManu() {
		for(WebElement el : cartRemoveList ) {
			click(el);
			break;
		}
	}
	public void moveToShoppigCart() {
		moveTo(cartBtn);
	}
	

}
