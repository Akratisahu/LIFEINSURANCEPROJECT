package practice_package;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.ExcelUtitlity;

public class Datapro {

//	@Test(dataProvider = "data")
	//public void getdata(String src,String dest) {
		//System.out.println("from "+src+" "+"to "+dest);
	//}
	
/*@DataProvider	
public Object[][] data(){
	Object [][] obj= new Object[2][2];
			obj[0][0]="testyantra";
	obj[0][1]="banglore";
	obj[1][0]="capegamini";
	obj[1][1]="banglore";
	return obj;
}*/
/*	@DataProvider
public Object[][] data() throws Throwable{
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\exceldata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	int lastrow = sh.getLastRowNum()+1;
	 int lastcell = sh.getRow(0).getLastCellNum();
	 Object[][] obj=new Object[lastrow][lastcell];
	 for(int i=0;i<lastrow;i++) {
		 
		 for(int j=0;j<lastcell;j++) {
			 obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		 }
	 }
	return obj;
	
}*/
	@Test(dataProvider = "setdata")
	public void getdata(String loc,String add) {
		System.out.println("from  "+loc+"to  "+add);
	}
	
@DataProvider
	public Object[][] setdata() throws Throwable {
		ExcelUtitlity ex=new ExcelUtitlity();
		Object[][] value = ex.readMultipleSetOfData("Sheet1");
		return value;
	}
}
