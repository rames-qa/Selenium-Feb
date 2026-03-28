package selenium.basics;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvAssignment {

    private static final String act = null;
	WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.linkedin.com/login");
    }

    @Test
    public void loginTest() throws InterruptedException {

        driver.findElement(By.id("username")).sendKeys("rameshkumarkkannan@gmail.com");

        driver.findElement(By.id("password")).sendKeys("Dhksha.S@695");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(5000);

        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("feed"));

        System.out.println("Login Successful");

        // Wait for LinkedIn home page to load
        Thread.sleep(6000);

        // Create JS Executor to Scroll to Bottom of Page
        JavascriptExecutor js = (JavascriptExecutor) driver;

        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

        while (true) {

            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(3000);

            long newHeight = (long) js.executeScript("return document.body.scrollHeight");

            if (newHeight == lastHeight) {
                break;
            }
            lastHeight = newHeight;
        }

        System.out.println("Fully Scrolled Down");


        // Scroll Back to Top
        js.executeScript("window.scrollTo(0, 0)");
        Thread.sleep(3000);

        System.out.println("Scrolled Back to Top");   
        }

    @After
    public void tearDown() {
        driver.quit();
    }

	public static String getAct() {
		return act;
	}
	
}