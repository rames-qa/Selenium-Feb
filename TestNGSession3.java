package selenium.advanced;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class TestNGSession3 {

    @DataProvider(name = "credentials")
    public Object[][] data() throws IOException {

        // ✅ Correct path
        String path = System.getProperty("user.dir") + "/src/test/resources/Data.xlsx";

        // ✅ Open file
        FileInputStream fs = new FileInputStream(path);

        // ✅ Create workbook
        XSSFWorkbook book = new XSSFWorkbook(fs);

        // ✅ Get sheet
        XSSFSheet sheet = book.getSheetAt(0);

        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] obj = new Object[totalRows - 1][totalColumns];

        for (int i = 1; i < totalRows; i++) {
            XSSFRow row = sheet.getRow(i);

            for (int j = 0; j < totalColumns; j++) {
                obj[i - 1][j] = row.getCell(j).toString();
            }
        }

        // ✅ Close resources
        book.close();
        fs.close();

        return obj;
    }
}