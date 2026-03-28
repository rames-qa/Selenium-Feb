package keydriven0;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeyDriven1 {

    WebDriver driver;

    void getData() throws IOException {

        FileInputStream fs = new FileInputStream("C:\\Users\\rames\\Downloads\\KeywordDrivenTest.xlsx");
        XSSFWorkbook book = new XSSFWorkbook(fs);
        XSSFSheet sheet = book.getSheetAt(0);
        int totalRows = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < totalRows; i++) {
            String keyword = sheet.getRow(i).getCell(0).getStringCellValue();
            String param1 = sheet.getRow(i).getCell(1).getStringCellValue();
            String param2 = sheet.getRow(i).getCell(2).getStringCellValue();
            actions(keyword, param1, param2);
        }

        book.close();
    }
    void actions(String keyword, String param1, String param2) {
        switch (keyword) {
        case "OpenBrowser":
            if (param1.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
            break;

        case "NavigateToUrl":
            driver.get(param1);
            break;
        case "CloseBrowser":
            driver.quit();
            break;
        default:
            System.out.println("Invalid keyword");
        }
    }
}