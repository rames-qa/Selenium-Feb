package selenium.advanced;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Framehandlesmultiple {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///C:/Users/rames/Downloads/BesantTutorials.html");

        // Store Parent Window ID
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window ID: " + parentWindow);
        System.out.println("Parent Title: " + driver.getTitle());

        // Click link which opens new window
        driver.findElement(By.tagName("a")).click();

        // Get all window IDs
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        String parent = it.next();
        String child = "";

        // Identify Child Window
        while (it.hasNext()) {
            child = it.next();
        }

        // Switch to Child Window
        driver.switchTo().window(child);
        System.out.println("Child Window Title: " + driver.getTitle());

        // Switch back to Parent Window
        driver.switchTo().window(parent);
        System.out.println("Back to Parent Title: " + driver.getTitle());

        driver.quit();
    }
}