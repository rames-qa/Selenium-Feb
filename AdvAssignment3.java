package selenium.advanced;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class AdvAssignment3 {

    public static void main(String[] args) throws InterruptedException {

        // SETUP
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // OPEN COURSE PAGE
        driver.get("https://www.udemy.com/course/learn-cucumber-bdd-framework/");

        // JAVASCRIPT EXECUTOR FOR SCROLLING
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // SLOW SCROLL DOWN
        for(int i = 0; i <= 10; i++) { 
            js.executeScript("window.scrollBy(0,200)");
            Thread.sleep(300);  
        }

        // EXPLICIT WAIT
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

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
        email.sendKeys("your-email@example.com");  
        // ENTER PASSWORD
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("YourPassword"); 
        // CLICK LOGIN
        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.click();
        System.out.println("Login attempted for Cucumber course");
        Thread.sleep(5000); 
        driver.quit();
    }
}