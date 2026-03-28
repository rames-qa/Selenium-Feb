package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumPOP {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        driver.manage().window().maximize();

        // Simple Alert
        driver.findElement(By.xpath("(//a[@data-toggle='tab'])[1]")).click();
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        // Confirmation Pop Up
        driver.findElement(By.xpath("(//a[@data-toggle='tab'])[2]")).click();
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        // Pop Up with Textbox
        driver.findElement(By.xpath("(//a[@data-toggle='tab'])[3]")).click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Ramesh");
        driver.switchTo().alert().accept();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll Down
        for(int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,300)");
            Thread.sleep(300);
        }

        // Scroll Up
        for(int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,-300)");
            Thread.sleep(300);
        }

        // Scroll Right
        for(int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(300,0)");
            Thread.sleep(300);
        }

        // Scroll Left
        for(int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(-300,0)");
            Thread.sleep(300);
        }

        driver.quit();
    }
}