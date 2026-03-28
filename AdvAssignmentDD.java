 package selenium.advanced;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AdvAssignmentDD {

	public static void main(String[] args) throws IOException {

		try (FileInputStream fs = new FileInputStream("C:\\Users\\rames\\OneDrive\\Documents\\DataDrivenTesting\\Data.xlsx");
		    XSSFWorkbook book = new XSSFWorkbook(fs)) {
			XSSFSheet sheet = book.getSheetAt(0);
			int totalrows = sheet.getPhysicalNumberOfRows();
			int totalcolumns = sheet.getRow(0).getPhysicalNumberOfCells();
			
			   System.out.println("---------------------------------------------------------------");
			   
			   DataFormatter format = new DataFormatter();
			   for (int i = 0; i < totalrows; i++) {
			       XSSFRow row = sheet.getRow(i);
			   for (int j = 0; j < totalcolumns; j++) {
			   String data = format.formatCellValue(row.getCell(j));
			   System.out.printf("| %-13s ", data);
			       }

			       System.out.println("|");
			       System.out.println("---------------------------------------------------------------");
			   }
			}
		}
	}
