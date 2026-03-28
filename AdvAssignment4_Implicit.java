package selenium.advanced;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvAssignment4_Implicit {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.get("file:///C:/Users/rames/Downloads/waits.html");

        // Element Added After 3 Seconds
        List<WebElement> addBtn = driver.findElements(By.xpath("//button[text()='Add Element']"));

        if (!addBtn.isEmpty()) {
            addBtn.get(0).click();
        }
        // Multiple Elements After 5 Seconds
        List<WebElement> multiBtn = driver.findElements(By.xpath("//button[text()='Add Multiple Elements']"));
        for (WebElement btn : multiBtn) {
            btn.click();
        
        // Auto Loaded After 4 Seconds
        List<WebElement> autoBtn = driver.findElements(By.xpath("//button[text()='Loaded After 4 Seconds']"));
        if (!autoBtn.isEmpty()) {
            autoBtn.get(0).click();
        }

        List<WebElement> autoText = driver.findElements(By.id("autoInput"));
        if (!autoText.isEmpty()) {
            autoText.get(0).sendKeys("Hi Ramesh");
        }
        // driver.quit();
    }
}
}