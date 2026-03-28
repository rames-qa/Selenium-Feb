package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Assignment5 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("file:///C:/Users/rames/Downloads/DropDown-1.html");

        WebElement dropdown = driver.findElement(By.id("SeleniumClass"));

        Select s = new Select(dropdown);

        Thread.sleep(4000);

        List<WebElement> options = s.getOptions();

        String value = options.get(2).getText();

        s.selectByVisibleText(value);

        System.out.println(value);

        driver.quit();
    }
}