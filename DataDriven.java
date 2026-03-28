package selenium.advanced;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main(String[] args) throws IOException {

		try (FileInputStream fs = new FileInputStream("C:/Users/rames/OneDrive/Documents/DataDrivenTesting/Data.xlsx");
		     XSSFWorkbook book = new XSSFWorkbook(fs)) {
			XSSFSheet sheet = book.getSheetAt(1);
			int totalrows = sheet.getPhysicalNumberOfRows();
			int totalcolumns = sheet.getRow(1).getPhysicalNumberOfCells();
			DataFormatter format = new DataFormatter();

			for (int i = 0; i < totalrows; i++) {
			    XSSFRow row = sheet.getRow(i);
			    for (int j = 0; j < totalcolumns; j++) {
			        String data = format.formatCellValue(row.getCell(j));
			        System.out.print(data + " ");
			    }
			    System.out.println();
			}
				}

			}
	}
