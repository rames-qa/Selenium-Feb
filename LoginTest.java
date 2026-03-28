package testPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
public class LoginTest {
	WebDriver driver;
	LoginPage loginpg;
	@BeforeMethod
	void setup() {
		driver = new ChromeDriver();
		loginpg = new LoginPage(driver);
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
	}
	@Test
	void validLogin() {
		loginpg.enterUserName("standard_user");
		loginpg.enterPwd("secret_sauce");
		loginpg.clickLoginBtn();
	}
	@AfterMethod
	void tearDown() {
		if (driver!=null) {
			driver.quit();
		}
	}
}
