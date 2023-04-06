package practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writemultipledatafromexcelTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		String org[]= {"testyantra","wipro","infosys"};
				String loc[]={"bhopal","indore","banglore"};
		
FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\exceldata.xlsx");
Workbook wb = WorkbookFactory.create(fis);
Sheet sheet = wb.getSheet("Sheet1");
int c=1;
for(int i=0;i<org.length;i++) {
	sheet.createRow(c).createCell(0).setCellValue(org[i]);
	sheet.getRow(c).createCell(1).setCellValue(loc[i]);
	FileOutputStream fout= new FileOutputStream(".\\src\\test\\resources\\exceldata.xlsx");
	wb.write(fout);
	c++;
	}



	}

}
