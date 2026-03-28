package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

  public class Selenium3 {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.saucedemo.com");
    Thread.sleep(3000);
    driver.findElement(By.cssSelector(".input_error")).sendKeys("standard_user");
    driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();
    Thread.sleep(5000);
}
}
