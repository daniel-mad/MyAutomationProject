package pageobjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {
	@FindBy(css = "#id_gender1")
	private WebElement maleGenderField;
	@FindBy(css = "#id_gender2")
	private WebElement femaleGenderField;
	@FindBy(css = "#customer_firstname")
	private WebElement custFirstNameField;
	@FindBy(css = "#customer_lastname")
	private WebElement custLastNameField;
	@FindBy(css = "#firstname")
	private WebElement firstNameField;
	@FindBy(css = "#lastname")
	private WebElement lastNameField;
	@FindBy(css = "#email")
	private WebElement emailField;
	@FindBy(css = "#passwd")
	private WebElement passwordField;
	@FindBy(css = "#days")
	private WebElement daysField;
	@FindBy(css = "#months")
	private WebElement monthsField;
	@FindBy(css = "#years")
	private WebElement yearsField;
	@FindBy(css = "#company")
	private WebElement companyField;
	@FindBy(css = "#address1")
	private WebElement addressField;
	@FindBy(css = "#city")
	private WebElement cityField;
	@FindBy(css = "#id_state")
	private WebElement stateField;
	@FindBy(css = "#postcode")
	private WebElement zipCodeField;
	@FindBy(css = "#phone_mobile")
	private WebElement mobilePhoneField;
	@FindBy(css = "#alias")
	private WebElement aliasField;
	@FindBy(css = "#submitAccount")
	private WebElement submitBtn;
	@FindBy(css = ".alert-danger > p")
	private WebElement errMsg;

	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}

	public void createMaleAcct(String firstName, String lastName, String email, String password, String birthDay,
			String company, String address, String city, String state, String zipCode, String mobilePhone,
			String aliasAddress) {
		click(maleGenderField);
		fillText(custFirstNameField, firstName);
		fillText(custLastNameField, lastName);
		fillText(emailField, email);
		fillText(passwordField, password);
		selectByValue(daysField, String.valueOf(returnDayOfBirth(birthDay)));
		sleep(1000);
		selectByValue(monthsField, String.valueOf(returnMonthOfBirth(birthDay)));
		sleep(1000);
		selectByValue(yearsField, String.valueOf(returnYearOfBirth(birthDay)));
		sleep(1000);
		fillText(firstNameField, firstName);
		fillText(lastNameField, lastName);
		fillText(companyField, company);
		fillText(addressField, address);
		fillText(cityField, city);
		selectByVisibleText(stateField, state);
		sleep(1000);
		fillText(zipCodeField, zipCode);
		fillText(mobilePhoneField, mobilePhone);
		fillText(aliasField, aliasAddress);
		click(submitBtn);
	}

	public int returnDayOfBirth(String birthDay) {
		int day;
		birthDay = birthDay.replace("/", "");
		int temp = Integer.parseInt(birthDay);
		day = temp / 1000000;
		return day;
	}

	public int returnMonthOfBirth(String birthDay) {
		int month;
		birthDay = birthDay.replace("/", "");
		int temp = Integer.parseInt(birthDay);
		month = temp / 10000 % 100;
		return month;
	}

	public int returnYearOfBirth(String birthDay) {
		int year;
		birthDay = birthDay.replace("/", "");
		int temp = Integer.parseInt(birthDay);
		year = temp % 10000;
		return year;
	}
	public String getErrorMsg() {
		return errMsg.getText();
	}
	public void clickSubmit() {
		click(submitBtn);
	}

}
