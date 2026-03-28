package selenium.advanced;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumSynchro2 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("file:///C:/Users/rames/Downloads/waits.html");

        driver.findElement(By.id("autoInput")).sendKeys("Hi Ramesh");

    }
}