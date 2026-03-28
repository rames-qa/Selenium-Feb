package selenium.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class SeleniumEndtoEnd {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");   
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        String[] users = {
                "standard_user",
                "locked_out_user",
                "problem_user",
                "performance_glitch_user",
                "error_user",
                "visual_user"
        };

        String password = "secret_sauce";

        for (String user : users) {

            driver.get("https://www.saucedemo.com");

            driver.findElement(By.id("user-name")).clear();
            driver.findElement(By.id("user-name")).sendKeys(user);

            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(password);

            driver.findElement(By.id("login-button")).click();

            Thread.sleep(2000);

            System.out.println("Login tried for user: " + user);

            driver.navigate().back();
        }

        //driver.quit();
    }
}