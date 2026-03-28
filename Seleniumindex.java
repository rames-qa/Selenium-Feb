package selenium.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Seleniumindex {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // Get usernames
        String[] names = driver.findElement(By.id("login_credentials")).getText().split("\n");

        System.out.println("Total usernames: " + names.length);

        String passwordText = driver.findElement(By.xpath("//div[@class='login_password']")).getText();

        String[] pwd = passwordText.split("\n");

        driver.findElement(By.id("user-name")).sendKeys(names[6]);
        driver.findElement(By.id("password")).sendKeys(pwd[1]);

        Thread.sleep(3000);
        driver.findElement(By.id("login-button")).click();
        String homeScrnEle = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
        if (homeScrnEle.equals("Sauce Labs Backpack")) {
            System.out.println("Test pass");
        } else {
            System.out.println("Test failed");
        }

        //driver.quit();
    }
}