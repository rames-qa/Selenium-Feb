package selenium.basics;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Assignment2Ifelse {

	    public static void main(String[] args) throws InterruptedException {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("https://parabank.parasoft.com/");
	        driver.findElement(By.cssSelector("a[href='register.htm']")).click();

	        Thread.sleep(2000);

	        // Enter data
	        driver.findElement(By.cssSelector("#customer\\.firstName")).sendKeys("Ramesh Kumar");
	        driver.findElement(By.cssSelector("#customer\\.lastName")).sendKeys("K");
	        driver.findElement(By.cssSelector("#customer\\.address\\.street")).sendKeys("5th Main Road");
	        driver.findElement(By.cssSelector("#customer\\.address\\.city")).sendKeys(" Bengaluru North");
	        driver.findElement(By.cssSelector("#customer\\.address\\.state")).sendKeys("Karnataka");
	        driver.findElement(By.cssSelector("#customer\\.address\\.zipCode")).sendKeys("560001");
	        driver.findElement(By.cssSelector("#customer\\.phoneNumber")).sendKeys("9876543210");
	        driver.findElement(By.cssSelector("#customer\\.ssn")).sendKeys("123456");

	        driver.findElement(By.cssSelector("#customer\\.username")).sendKeys("ramesh0123");
	        driver.findElement(By.cssSelector("#customer\\.password")).sendKeys("Password1234");
	        driver.findElement(By.cssSelector("#repeatedPassword")).sendKeys("Password1234");

	        driver.findElement(By.cssSelector("input[value='Register']")).click();

	        Thread.sleep(3000);

	        // CONDITION → Check if registration success
	        String pageSource = driver.getPageSource();

	        if (pageSource.contains("Welcome")) {
	            System.out.println("Registration Successful");
	        } else {
	            System.out.println("Registration Failed");
	        }

	        driver.quit();
	    }
	}
