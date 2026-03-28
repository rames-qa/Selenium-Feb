package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;

public class Assignment6 {

    public static void main(String[] args) throws InterruptedException, AWTException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        Thread.sleep(2000);
        driver.findElement(By.id("user-name")).sendKeys("RameshKumar");
        driver.findElement(By.id("password")).sendKeys("Besant@1234");

        Thread.sleep(2000);

        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("Failed to Login");
    }
}