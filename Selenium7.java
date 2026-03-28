package selenium.basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium7 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        try {
            driver.get("file:///C:/Users/rames/Downloads/DropDown-1.html");

            // Explicit wait for dropdown to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement dropdown = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("SeleniumClass")));

            Select s = new Select(dropdown);

            // Check whether dropdown is multi-select
            if (s.isMultiple()) {
                s.selectByIndex(2);
                s.selectByVisibleText("Thaikelavi");
                s.selectByValue("Vishwas");

                Thread.sleep(5000); // small pause to see selection

                // Deselect all options
                s.deselectAll();
            }
          
            // Get all dropdown options
            List<WebElement> options = s.getOptions();
            // Print all options
            for (WebElement option : options) {
                System.out.println(option.getText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	Thread.sleep(5000);
            driver.quit();
        }
    }
}
