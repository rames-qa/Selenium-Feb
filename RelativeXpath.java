package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeXpath {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com");
        Thread.sleep(3000);

        //Index
        driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")) .sendKeys("standard_user");
        driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).sendKeys("secret_sauce");
        //Contains
       driver.findElement(By.xpath("//input[contains(@id,'pass')]")).sendKeys("secret_sauce");

        //Dynamics
      //driver.findElement(By.xpath("//input[starts-with(@data-test,'login')]")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
