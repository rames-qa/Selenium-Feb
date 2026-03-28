package keydriven0;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
/* ---------------------------------------------------------
   1. BASE TEST CLASS (Handles Browser Lifecycle)
-----------------------------------------------------------*/
class BaseTest {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Added an implicit wait to help with "NoSuchElementException"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
    }
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
/* ---------------------------------------------------------
   2. PAGE OBJECT CLASSES (Logic for specific pages)
-----------------------------------------------------------*/
class LoginPage {
    WebDriver driver;
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    LoginPage(WebDriver driver) { this.driver = driver; }
    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}
class HomePage {
    WebDriver driver;
    By title = By.className("title");

    HomePage(WebDriver driver) { this.driver = driver; }

    public String getTitle() {
        return driver.findElement(title).getText();
    }
}
class ProductPage {
    WebDriver driver;
    By addToCart = By.id("add-to-cart-sauce-labs-backpack");

    ProductPage(WebDriver driver) { this.driver = driver; }

    public void addProduct() {
        driver.findElement(addToCart).click();
    }
}
/* ---------------------------------------------------------
   3. MAIN TEST CLASS (Assignment01)
-----------------------------------------------------------*/
public class Assignment01 extends BaseTest {
    LoginPage lp;
    HomePage hp;
    ProductPage pp;

    @BeforeMethod
    public void init() {
        lp = new LoginPage(driver);
        hp = new HomePage(driver);
        pp = new ProductPage(driver);
    }
    // Helper method to bypass login for non-login tests
    private void performValidLogin() {
        lp.login("standard_user", "secret_sauce");
    }
    /* LOGIN TESTS (Tests 1-5) */
    @Test public void test1() { lp.login("standard_user", "secret_sauce"); }
    @Test public void test2() { lp.login("locked_out_user", "secret_sauce"); }
    @Test public void test3() { lp.login("problem_user", "secret_sauce"); }
    @Test public void test4() { lp.login("performance_glitch_user", "secret_sauce"); }
    @Test public void test5() { lp.login("standard_user", "wrongpass"); }
    /* HOME PAGE TESTS (Tests 6-10) */
    @Test public void test6() { performValidLogin(); System.out.println(hp.getTitle()); }
    @Test public void test7() { performValidLogin(); System.out.println(hp.getTitle()); }
    @Test public void test8() { performValidLogin(); System.out.println(hp.getTitle()); }
    @Test public void test9() { performValidLogin(); System.out.println(hp.getTitle()); }
    @Test public void test10() { performValidLogin(); System.out.println(hp.getTitle()); }
    /* PRODUCT PAGE TESTS (Tests 11-20) */
    @Test public void test11() { performValidLogin(); pp.addProduct(); }
    @Test public void test12() { performValidLogin(); pp.addProduct(); }
    @Test public void test13() { performValidLogin(); pp.addProduct(); }
    @Test public void test14() { performValidLogin(); pp.addProduct(); }
    @Test public void test15() { performValidLogin(); pp.addProduct(); }
    @Test public void test16() { performValidLogin(); pp.addProduct(); }
    @Test public void test17() { performValidLogin(); pp.addProduct(); }
    @Test public void test18() { performValidLogin(); pp.addProduct(); }
    @Test public void test19() { performValidLogin(); pp.addProduct(); }
    @Test public void test20() { performValidLogin(); pp.addProduct(); }
}