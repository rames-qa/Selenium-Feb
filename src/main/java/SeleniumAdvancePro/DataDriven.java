package SeleniumAdvancePro;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class DataDriven {

    public static void main(String[] args) throws IOException {

        String path = "C:/Users/rames/OneDrive/Documents/DataDrivenTesting/Data.xlsx";

        try (FileInputStream fs = new FileInputStream(path);
             XSSFWorkbook book = new XSSFWorkbook(fs)) {

            XSSFSheet sheet = book.getSheetAt(0); // safer

            int totalRows = sheet.getPhysicalNumberOfRows();
            int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

            DataFormatter format = new DataFormatter();

            for (int i = 0; i < totalRows; i++) {

                XSSFRow row = sheet.getRow(i);

                if (row == null) {
                    continue; // skip empty row
                }

                for (int j = 0; j < totalColumns; j++) {

                    String data = format.formatCellValue(row.getCell(j));
                    System.out.print(data + " | ");
                }

                System.out.println();
            }
        }
    }
}