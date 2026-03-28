package keydriven0;
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
import pages.LoginPage; 
public class HybridTestNG {
    WebDriver driver;
    LoginPage loginpg;
    /**
     * Logic Analysis:
     * Your previous code failed on 'locked_out_user' because the validation 
     * only looked for success. This improved version checks the URL or 
     * specific elements to provide a clear result.
     */
    String validateLogin() {
        try {
            // Check if we reached the inventory page
            boolean isInventoryVisible = driver.findElements(By.id("inventory_container")).size() > 0;
            return isInventoryVisible ? "Success" : "Failed";
        } catch (Exception e) {
            return "Failed";
        }
    }
    @DataProvider(name = "credentials")
    public Object[][] getExcelData() throws IOException {
        String path = "C:/Users/rames/OneDrive/Documents/DataDrivenTesting/Data.xlsx";
        FileInputStream fs = new FileInputStream(path);
        XSSFWorkbook book = new XSSFWorkbook(fs); 
        // Using Sheet index 1 as per your requirement
        XSSFSheet sheet = book.getSheetAt(1);
        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data = new Object[totalRows - 1][totalCols];
        for (int i = 1; i < totalRows; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < totalCols; j++) {
                // Safely convert cell data to string
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
    @BeforeMethod
    public void setup() {
        // Fix for Chrome 145 Warnings: Explicitly allow remote origins if needed
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");  
        driver = new ChromeDriver(options); 
        // Timing Fix: Ensures elements are found even on slow networks
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");   
        loginpg = new LoginPage(driver);
    }
    @Test(dataProvider = "credentials")
    public void executeLoginTest(String user, String pass) {
        // 1. Perform Actions
        loginpg.enterUserName(user);
        loginpg.enterPwd(pass);
        loginpg.clickLoginBtn();
        // 2. Validate Result
        String actualResult = validateLogin();
        /** * LOGIC FIX: 
         * If the user is 'locked_out_user', we EXPECT it to fail. 
         * This assertion will now pass if the result matches our expectation.
         */
        if (user.equals("locked_out_user")) {
            Assert.assertEquals(actualResult, "Failed", "Locked out user was able to log in!");
        } else {
            Assert.assertEquals(actualResult, "Success", "Login failed for: " + user);
        }
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}