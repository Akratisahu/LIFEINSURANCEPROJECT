package practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDatafromexcelTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\exceldata.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sheet = wb.getSheet("Sheet1");
Row row = sheet.getRow(3);
//Cell cell = row.getCell(1);
Cell cell = row.createCell(1);
//String result = cell.getStringCellValue();
cell.setCellValue("indore");


FileOutputStream fout=new FileOutputStream(".\\src\\\\test\\\\resources\\\\exceldata.xlsx");
wb.write(fout);
wb.close();
	}

}
