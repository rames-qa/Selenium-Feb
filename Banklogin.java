package selenium.basics;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Banklogin {

	    public static void main(String[] args) throws InterruptedException {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("https://parabank.parasoft.com/");
              Thread.sleep(3000);
	        // Enter Username
	        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("ramesh1234");
            Thread.sleep(3000);
	        // Enter Password
	        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Password1234");

	        // Click to the Login
	        driver.findElement(By.cssSelector("input[value='LogIn']")).click();
	        // Print the Current URL
	        System.out.println("Login Url:"+driver.getCurrentUrl());
            Thread.sleep(3000);
	        driver.quit();
	    }
	}

