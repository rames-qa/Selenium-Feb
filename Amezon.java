package keydriven0;


	import java.time.Duration;
	import java.util.List;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Amezon {
	    public static void main(String[] args) {

	        // Setup ChromeDriver automatically
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();

	        try {
	            driver.manage().window().maximize();
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	            // Step 1: Open Amazon India
	            driver.get("https://www.amazon.in/");

	            // Step 2: Search for a phone (OnePlus in this example)
	            WebElement searchBox = wait.until(
	                    ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
	            searchBox.sendKeys("OnePlus phone");

	            driver.findElement(By.id("nav-search-submit-button")).click();

	            // Step 3: Wait for search results to load
	            wait.until(ExpectedConditions.presenceOfElementLocated(
	                    By.xpath("//div[@data-component-type='s-search-result']")));

	            // Step 4: Click the first product (stable XPath)
	            WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(
	                    By.xpath("(//div[@data-component-type='s-search-result']//h2/a)[1]")));

	            // Scroll + JS click to ensure reliability
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProduct);
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstProduct);

	            // Step 5: Switch to new tab if opened
	            String mainWindow = driver.getWindowHandle();
	            Set<String> windows = driver.getWindowHandles();
	            for (String window : windows) {
	                if (!window.equals(mainWindow)) {
	                    driver.switchTo().window(window);
	                    break;
	                }
	            }

	            // Step 6: Scrape product details safely

	            // Product Name
	            WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productTitle")));
	            System.out.println("Product Name: " + productTitle.getText());

	            // Price
	            String price = "";
	            try {
	                price = driver.findElement(By.id("priceblock_ourprice")).getText();
	            } catch (Exception e1) {
	                try {
	                    price = driver.findElement(By.id("priceblock_dealprice")).getText();
	                } catch (Exception e2) {
	                    price = "Price not found";
	                }
	            }
	            System.out.println("Price: " + price);

	            // Rating
	            String rating = "";
	            try {
	                rating = driver.findElement(By.xpath("//span[@id='acrPopover']//span[@class='a-icon-alt']")).getText();
	            } catch (Exception e) {
	                rating = "Rating not found";
	            }
	            System.out.println("Rating: " + rating);

	            // Total reviews
	            String totalReviews = "";
	            try {
	                totalReviews = driver.findElement(By.id("acrCustomerReviewText")).getText();
	            } catch (Exception e) {
	                totalReviews = "Reviews not found";
	            }
	            System.out.println("Total Reviews: " + totalReviews);

	            // Availability
	            String availability = "";
	            try {
	                availability = driver.findElement(By.id("availability")).getText();
	            } catch (Exception e) {
	                availability = "Availability not found";
	            }
	            System.out.println("Availability: " + availability);

	            // Key Features
	            System.out.println("\nKey Features:");
	            try {
	                List<WebElement> features = driver.findElements(By.xpath("//div[@id='feature-bullets']//li/span"));
	                for (WebElement feature : features) {
	                    System.out.println("- " + feature.getText());
	                }
	            } catch (Exception e) {
	                System.out.println("Features not found");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Optional: close browser
	            // driver.quit();
	        }
	    }
	}
