package selenium.basics;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Assignment2For {

	    public static void main(String[] args) throws InterruptedException {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://parabank.parasoft.com/");

	        driver.findElement(By.cssSelector("a[href='register.htm']")).click();

	        Thread.sleep(3000);

	        // Store all input field CSS selectors in array
	        String[] fields = {"input[id='customer.firstName']","input[id='customer.lastName']",
	                "input[id='customer.address.street']","input[id='customer.address.city']",
	                "input[id='customer.address.state']","input[id='customer.address.zipCode']",
	                "input[id='customer.phoneNumber']","input[id='customer.ssn']",
	                "input[id='customer.username']","input[id='customer.password']",
	                "input[id='repeatedPassword']"};

	        // Store corresponding values
	        String[] values = {"Ramesh Kumar","K","5th Main Road","Bangalore North","Karnataka",
	                "560001","9876543210","123456","ramesh123","Password123","Password123"};

	        // Use for loop to enter all values
	        for (int i = 0; i < fields.length; i++) {

	            // Locate element using CSS selector
	            driver.findElement(By.cssSelector(fields[i])).clear();

	            // Enter corresponding value
	            driver.findElement(By.cssSelector(fields[i])).sendKeys(values[i]);
	        }

	        Thread.sleep(3000);

	        // Click Register button
	        driver.findElement(By.cssSelector("input[value='Register']")).click();
	        Thread.sleep(3000);

	        // Close browser
	        driver.quit();
	    }
	}


