package selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium6 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = null;

		try {

			driver = new ChromeDriver();
			driver.manage().window().maximize();
//            driver.get("file:///C:/Users/rames/Downloads/advancedNavigation.html");
			driver.get("file:///C:/Users/rames/Downloads/sibling.html");
//            WebElement title = driver.findElement(By.xpath("(//input[@type='text'])[1]/../../h2"));
//            WebElement title = driver.findElement(By.xpath("//h2[.='Menu']//preceding::label[4]"));
			  WebElement instuteName = driver.findElement(By.xpath("//p[.='Trainer - Manoj']/preceding-sibling::h2"));
			  WebElement anouncement = driver.findElement(By.xpath("//p[.='Trainer - Manoj']/following-sibling::p"));
			  System.out.println(instuteName.getText());
			  System.out.println(anouncement.getText());
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			if (driver != null) {
				driver.quit();
				Thread.sleep(3000);
			}
		}
	}
}
