package selenium.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/rames/Downloads/Frames.html");
        driver.manage().window().maximize();

        // Switch to parent frame
        WebElement parentFrame = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(parentFrame);

        // Switch to child frame inside parent frame
        driver.switchTo().frame(0);
        Thread.sleep(3000);

        // Click button inside child frame
        driver.findElement(By.xpath("//button[text()='Click Me (Nested Frame 1)']")).click();
        Thread.sleep(3000);

        // Accept alert from child frame
        driver.switchTo().alert().accept();

        // Switch back to parent frame
        driver.switchTo().parentFrame();

        // Click button inside parent frame
        driver.findElement(By.xpath("//button[text()='Click Me (Frame 1)']")).click();
        Thread.sleep(3000);

        // Accept alert from parent frame
        driver.switchTo().alert().accept();

        // Switch back to main page
        driver.switchTo().defaultContent();
        driver.quit();
    }
}