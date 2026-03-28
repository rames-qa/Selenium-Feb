package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

       // WebElement quote = driver.findElement(By.xpath("//h2[contains(text(),'Facebook helps you connect')]"));

        //System.out.println(quote.getText());

        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Vibha");

        driver.findElement(By.xpath("//input[starts-with(@placeholder,'Email')]")).sendKeys("Vibha");
        Thread.sleep(3000);
        driver.quit(); // better than close()
    }
}

