package selenium.advanced;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class Advassignment4 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Step 1: Open ATS site
        driver.get("https://enhancv.com");

        try {

            // Step 2: Upload Resume
            WebElement uploadInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[@type='file']")
            ));

            uploadInput.sendKeys("C:\\Users\\rames\\Downloads\\Ramesh Kumar.K (New).pdf");

            // Step 3: Click Scan / Review Button
            WebElement scanBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Scan')]")
            ));
            scanBtn.click();

            // Step 4: Wait for ATS Score
            WebElement score = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'%')]")
            ));

            // Step 5: Print Score
            System.out.println("ATS Score is: " + score.getText());

        } catch(Exception e) {
            System.out.println("Error checking ATS score: " + e.getMessage());
        }

        driver.quit();
    }
}