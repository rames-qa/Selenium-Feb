package selenium.basics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://www.Linkedin.com");

            // Get actual title
            String actualTitle = driver.getTitle();
            System.out.println("Actual Title: " + actualTitle);

            // Correct Expected Title
            String expectedTitle = "Linkedin – log in or sign up";

            if (actualTitle.equals(expectedTitle)) {
                System.out.println("Title is correct ");
            } 
            else 
            {
                System.out.println("Title is incorrect Taking Screenshot...");

                TakesScreenshot ts = (TakesScreenshot) driver;
                File source = ts.getScreenshotAs(OutputType.FILE);

                File destination = new File("C:/Users/rames/Downloads/Screenshot.png");
                FileUtils.copyFile(source, destination);

                System.out.println("Screenshot saved successfully.");
            }

            Thread.sleep(5000);

        } 
        finally 
        {
            driver.quit();
        }
    }
}
