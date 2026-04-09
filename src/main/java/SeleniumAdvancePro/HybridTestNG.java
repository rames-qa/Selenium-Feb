package SeleniumAdvancePro;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HybridTestNG {

    WebDriver driver;
    LoginPage loginpg;

    // ================= Page Object (Embedded) =================
    public class LoginPage {
        WebDriver driver;

        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        public void enterUserName(String uname) {
            driver.findElement(By.id("user-name")).sendKeys(uname);
        }

        public void enterPwd(String pwd) {
            driver.findElement(By.id("password")).sendKeys(pwd);
        }

        public void clickLoginBtn() {
            driver.findElement(By.id("login-button")).click();
        }
    }

    // ================= Utility to validate login =================
    String validateLogin() {
        try {
            boolean isInventoryVisible = driver.findElements(By.id("inventory_container")).size() > 0;
            return isInventoryVisible ? "Success" : "Failed";
        } catch (Exception e) {
            return "Failed";
        }
    }

    // ================= DataProvider for Excel =================
    @DataProvider(name = "credentials")
    public Object[][] getExcelData() throws IOException {
        String path = "C:\\Users\\rames\\Favorites\\eclipse-workspace\\Selenium-java\\src\\test\\resources\\Data.xlsx";
        FileInputStream fs = new FileInputStream(path);
        XSSFWorkbook book = new XSSFWorkbook(fs);
        XSSFSheet sheet = book.getSheetAt(1); // Sheet index 1
        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[totalRows - 1][totalCols];

        for (int i = 1; i < totalRows; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < totalCols; j++) {
                if (row.getCell(j) != null) {
                    data[i - 1][j] = row.getCell(j).toString();
                } else {
                    data[i - 1][j] = "";
                }
            }
        }

        book.close();
        fs.close();
        return data;
    }

    // ================= Setup =================
    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");  
        driver = new ChromeDriver(options); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        loginpg = new LoginPage(driver);
    }

    // ================= Test =================
    @Test(dataProvider = "credentials")
    public void executeLoginTest(String user, String pass) {
        loginpg.enterUserName(user);
        loginpg.enterPwd(pass);
        loginpg.clickLoginBtn();

        String actualResult = validateLogin();

        if (user.equals("locked_out_user")) {
            Assert.assertEquals(actualResult, "Failed", "Locked out user was able to log in!");
        } else {
            Assert.assertEquals(actualResult, "Success", "Login failed for: " + user);
        }
    }

    // ================= Teardown =================
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}