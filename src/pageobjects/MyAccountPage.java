package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	@FindBy(css= "#center_column > p")
	private WebElement welcomeMsg;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public String getMsg() {
		return welcomeMsg.getText();
	}

}
