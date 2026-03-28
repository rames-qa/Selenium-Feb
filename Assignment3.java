package selenium.basics;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open YouTube
        driver.get("https://www.youtube.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on Shorts
        WebElement shorts = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Shorts']")));
        shorts.click();

        // Scroll to load more Shorts
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 5; i++) {
            js.executeScript("window.scrollBy(0,1000)");
            Thread.sleep(2000);
        }

        // Close browser
        driver.quit();
    }
}
