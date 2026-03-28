package selenium.basics;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	public class Linkedin {
	    public static void main(String[] args) throws InterruptedException  {
	        // Launch browser
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Open LinkedIn Login page
	        driver.get("https://www.linkedin.com/login");

	        Thread.sleep(2000);

	        // Enter Email
	        driver.findElement(By.id("username")).sendKeys("rameshkumarkkannan@gmail.com");

	        // Enter Password
	        driver.findElement(By.id("password")).sendKeys("Dhksha.S@695");

	        // Click Login button
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        driver.findElement(By.cssSelector("button[type='submit']")).click();
	        driver.findElement(By.cssSelector(".btn__primary--large")).click();
	        Thread.sleep(3000);
	        driver.quit();
	    }
	}


