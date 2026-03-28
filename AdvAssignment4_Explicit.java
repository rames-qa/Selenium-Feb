package selenium.advanced;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdvAssignment4_Explicit {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
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
        }

        //WAIT for button which loads after 4 seconds
        WebElement loadBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Loaded After 4 Seconds']")));
        loadBtn.click();

        // WAIT for dynamically created textbox
        WebElement autoText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autoInput")));
        autoText.sendKeys("Welcome to Bangalore");
        // driver.quit();
    }
}