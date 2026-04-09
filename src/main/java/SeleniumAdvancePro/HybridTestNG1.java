package SeleniumAdvancePro;

import java.io.FileInputStream;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class HybridTestNG1 {
    WebDriver driver;
    // =========================
    // 🔹 Setup & Teardown
    // =========================
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    // =========================
    // 🔹 POM (Login Page)
    // =========================
    class LoginPage {
        WebDriver driver;
        By usernameField = By.id("user-name");
        By passwordField = By.id("password");
        By loginBtn = By.id("login-button");
        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }
        public void login(String user, String pass) {
            driver.findElement(usernameField).sendKeys(user);
            driver.findElement(passwordField).sendKeys(pass);
            driver.findElement(loginBtn).click();
        }
    }
    // =========================
    // 🔹 Excel Utility
    // =========================
    public Object[][] getData(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook wb = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = wb.getSheet(sheetName);
            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();
            Object[][] data = new Object[rows - 1][cols];
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
                }
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // =========================
    // 🔹 DataProvider
    // =========================
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return getData("src/test/resources/Data.xlsx", "Sheet1");
    }
    // =========================
    // 🔹 Test Case
    // =========================
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String email, String age) {
        LoginPage lp = new LoginPage(driver);
        lp.login(username, password);
        System.out.println("Login attempted with:");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);
        System.out.println("Age: " + age);
    }
}