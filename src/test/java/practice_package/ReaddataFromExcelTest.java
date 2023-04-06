package practice_package;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReaddataFromExcelTest {
	public static void main(String args[]) throws Throwable
	{
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\exceldata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		//DataFormatter df=new DataFormatter();
		
		Sheet sheet = wb.getSheet("sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(0);
		String result = cell.getStringCellValue();
	System.out.println(result);
		
		
	}

}
