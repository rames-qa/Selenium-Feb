package selenium.advanced;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Advassignmentindeximp {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.saucedemo.com/");

        // Get usernames
        String[] names = driver.findElement(By.id("login_credentials")).getText().split("\n");
        System.out.println("Total usernames: " + names.length);

        // Get password
        String[] pwd = driver.findElement(By.className("login_password")).getText().split("\n");

        // Login
        driver.findElement(By.id("user-name")).sendKeys(names[4]);
        driver.findElement(By.id("password")).sendKeys(pwd[1]);
        driver.findElement(By.id("login-button")).click();

        // Validation
        String homeScrnEle = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();

        if (homeScrnEle.equals("Sauce Labs Backpack")) {
            System.out.println("Test Pass ✅");
        } else {
            System.out.println("Test Fail ❌");
        }

        driver.quit();
    }
}