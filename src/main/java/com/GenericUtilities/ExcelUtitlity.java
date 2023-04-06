package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtitlity {

	//private static final String SheetName = null;
	public String readDataFromExcel(String SheetName,int Rowno,int coloumno) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(SheetName);
		String value = sheet.getRow(Rowno).getCell(coloumno).getStringCellValue();
		return value;
	}
	public int getLastRowNum(String sheetName) throws Throwable {
	FileInputStream fis=new FileInputStream(IpathConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet(sheetName);
	int count = sheet.getLastRowNum();
	return count;
}
public void writeDataIntoExcel(String sheetName,int row,int coloum,String value) throws Throwable {
	FileInputStream fis=new FileInputStream(IpathConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet=wb.getSheet(sheetName);
	sheet.getRow(row).createCell(coloum).setCellValue(value);
	FileOutputStream fout=new FileOutputStream(IpathConstants.Excelpath);
	wb.write(fout);
	}
public HashMap<String,String> readMultipledata(String sheetName) throws Throwable {
	FileInputStream fis=new FileInputStream(IpathConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet(sheetName);
	int count = sheet.getLastRowNum();
	HashMap<String,String> map=new HashMap<String, String>();
	for(int i=1;i<=count;i++) {
		String key=sheet.getRow(i).getCell(0).getStringCellValue();
		String value=sheet.getRow(i).getCell(1).getStringCellValue();
		map.put(key,value);
	}
	return map;
}
public Object[][] readMultipleSetOfData(String sheetName) throws Throwable {
	FileInputStream fis =new FileInputStream(IpathConstants.Excelpath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	int lastrow=sh.getLastRowNum()+1;
	int lastcol=sh.getRow(0).getLastCellNum();
	Object[][] obj=new Object[lastrow][lastcol];
	for(int i=0;i<lastrow;i++) {
		for(int j=0;j<lastcol;j++) {
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
	
	
}
}