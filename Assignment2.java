package selenium.basics;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Assignment2 {
	    public static void main(String[] args) throws InterruptedException {

	        // Launch Chrome Browser
	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        // Open Parabank Website
	        driver.get("https://parabank.parasoft.com");
	        Thread.sleep(3000);

	        // Click on Register link using CSS Selector
	        driver.findElement(By.cssSelector("a[href='register.htm']")).click();

	        Thread.sleep(3000);

	        // Fill Registration Form using CSS Selectors
	        driver.findElement(By.cssSelector(".input[id='customer.firstName']")).sendKeys("Ramesh Kumar");
	        driver.findElement(By.cssSelector(".input[id='customer.lastName']")).sendKeys("K");
	        driver.findElement(By.cssSelector(".input[id='customer.address.street']")).sendKeys("5th Main road");
	        driver.findElement(By.cssSelector(".input[id='customer.address.city']")).sendKeys("Bangalore");
	        driver.findElement(By.cssSelector(".input[id='customer.address.state']")).sendKeys("Karnataka");
	        driver.findElement(By.cssSelector(".input[id='customer.address.zipCode']")).sendKeys("560001");
	        driver.findElement(By.cssSelector(".input[id='customer.phoneNumber']")).sendKeys("9876543210");
	        driver.findElement(By.cssSelector(".input[id='customer.ssn']")).sendKeys("123456");

	        // Username & Password
	        driver.findElement(By.cssSelector(".input[id='customer.username']")).sendKeys("ramesh1234");
	        driver.findElement(By.cssSelector(".input[id='customer.password']")).sendKeys("Password123");
	        driver.findElement(By.cssSelector(".input[id='repeatedPassword']")).sendKeys("Password123");

	        Thread.sleep(3000);

	        // Click Register button using CSS Selector
	        driver.findElement(By.cssSelector(".input[value='Register']")).click();
	        Thread.sleep(3000);

	        // Close browser
	        driver.quit();
	    }
	}



