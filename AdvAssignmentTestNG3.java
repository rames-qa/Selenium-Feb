package selenium.advanced;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AdvAssignmentTestNG3 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com");
    }

    // True Condition
    @Test(priority = 0)
    public void validateTextTrue() {

        String expectedText = "standard_user";

        WebElement username = driver.findElement(By.id("user-name"));
        username.clear();
        username.sendKeys(expectedText);

        String actualText = username.getAttribute("value");

        boolean flag = actualText.equals(expectedText);

        System.out.println("Boolean value True test: " + flag);

        Assert.assertTrue(flag, "Text validation failed!");
    }

    // False Condition
    @Test(priority = 1)
    public void validateTextFalse() {

        String expectedText = "wrong_user";

        WebElement username = driver.findElement(By.id("user-name"));
        username.clear();
        username.sendKeys("standard_user");

        String actualText = username.getAttribute("value");

        boolean flag = actualText.equals(expectedText);

        System.out.println("Boolean value False test: " + flag);

        Assert.assertFalse(flag, "Text should not match!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}