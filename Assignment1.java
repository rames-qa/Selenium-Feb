package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String[] users = {
                "standard_user",
                "locked_out_user",
                "problem_user",
                "performance_glitch_user"
        };

        for (String user : users) {

            driver.get("https://www.saucedemo.com");

            // Enter username
            driver.findElement(By.id("user-name")).clear();
            Thread.sleep(3000);
            driver.findElement(By.id("user-name")).sendKeys(user);

            // Enter password
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            Thread.sleep(3000);
            // Click login
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(3000);

            String currentUrl = driver.getCurrentUrl();
            System.out.println("User: " + user + " | URL: " + currentUrl);

            // Logout ONLY if login is successful
            if (currentUrl.contains("inventory")) {
                driver.findElement(By.id("react-burger-menu-btn")).click();
                driver.findElement(By.id("logout_sidebar_link")).click();
            }
        }

        driver.quit();
    }
}
