package selenium.advanced;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class AdvAssignment2 {

    public static void main(String[] args) throws InterruptedException {

        //  SETUP
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.pavanonlinetrainings.com/p/udemy-courses.html");
        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get("https://www.udemy.com/course/learn-cucumber-bdd-framework/");
        WebDriverWait wait = new WebDriverWait(driver1, Duration.ofSeconds(15));

        // CLICK LOGIN BUTTON (if visible)
        try {
            WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Log in')]")));
            loginBtn.click();
        } catch(Exception e) {
            System.out.println("Login button not visible, maybe already on login page.");
        }

        // ENTER EMAIL
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("your-email@example.com");  // <-- replace with your email

        // ENTER PASSWORD
        WebElement password = driver1.findElement(By.id("password"));
        password.sendKeys("YourPassword"); // <-- replace with your password

        // CLICK LOGIN
        WebElement submitBtn = driver1.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.click();
        System.out.println("Login attempted for Cucumber course");
        Thread.sleep(5000); 

        driver1.quit();
    }
}