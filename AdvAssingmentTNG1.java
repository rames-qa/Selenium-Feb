package selenium.advanced;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdvAssingmentTNG1 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
       
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    void login_user1() { login("standard_user"); }

    @Test
    void login_user2() { login("locked_out_user"); }

    @Test
    void login_user3() { login("problem_user"); }

    @Test
    void login_user4() { login("performance_glitch_user"); }

    @Test
    void login_user5() { login("error_user"); }

    @Test
    void login_user6() { login("visual_user"); }

    void login(String username) {

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(username);

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("secret_sauce");

    wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
    driver.navigate().back();
    }
    @AfterMethod
    void closeBrowser() {
    //driver.quit();
    }
}