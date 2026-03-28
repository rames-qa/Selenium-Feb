package selenium.advanced;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTipSession {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions act = new Actions(driver);

        // ---------------- RIGHT CLICK ----------------
        driver.get("https://demoqa.com/buttons");

        Thread.sleep(4000);
        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        act.contextClick(rightClickBtn).perform();

        Thread.sleep(4000);
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);

        // ---------------- DRAG & DROP (Simple) ----------------
        driver.get("https://demoqa.com/droppable");

        Thread.sleep(4000);
        WebElement src = driver.findElement(By.id("draggable"));
        WebElement dst = driver.findElement(By.id("droppable"));
        act.dragAndDrop(src, dst).perform();


        // ---------------- TOOLTIP ----------------
        driver.get("https://demoqa.com/tool-tips");

        Thread.sleep(4000);
        WebElement button = driver.findElement(By.id("toolTipButton"));
        act.moveToElement(button).perform();

        Thread.sleep(4000);
        driver.quit();
    }
}