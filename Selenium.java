package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

    public static void main(String[] args) throws InterruptedException {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        Thread.sleep(3000);

        // Open SauceDemo website
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        Thread.sleep(3000);

        // Locate username textbox and enter value
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.click();
        userName.sendKeys("standard_user");

        Thread.sleep(3000);

        // Locate password textbox and enter value
        WebElement password = driver.findElement(By.id("password"));
        password.click();
        password.sendKeys("secret_sauce");

        Thread.sleep(3000);

        // Locate login button and click
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();

        Thread.sleep(3000);

        // Print current URL
        System.out.println(driver.getCurrentUrl());

        // Close browser
        driver.quit();
    }
}
