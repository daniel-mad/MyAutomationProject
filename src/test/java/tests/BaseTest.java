package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import com.google.common.collect.ImmutableMap;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;
	String browserVersion;
	String browserName;

	@Parameters({ "browser", "baseUrl" })
	@BeforeClass
	public void setup(ITestContext testContext, String browser, String baseUrl) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		browserVersion = ((RemoteWebDriver) driver).getCapabilities().getVersion();
		browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
		testContext.setAttribute("WebDriver", this.driver);
		allureEnvironmentWriter(ImmutableMap.<String, String>builder().put("Browser", browserName)
				.put("Browser.Version", browserVersion).put("URL", baseUrl).build());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
