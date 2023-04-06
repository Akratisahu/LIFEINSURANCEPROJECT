package practice_package;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class multipledatafromexceltest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\exceldata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
                      int count = sheet.getLastRowNum();
                      for(int i=1;i<count;i++) {
                    	 Cell org = sheet.getRow(i).getCell(0);
                    	  Cell loc = sheet.getRow(i).getCell(1);
                    	  System.out.println(org+" "+loc+" ");
                      }
	}

}
