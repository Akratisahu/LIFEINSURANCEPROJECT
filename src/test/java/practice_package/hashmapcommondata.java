package practice_package;

import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.DatabaseUtility;
import com.GenericUtilities.ExcelUtitlity;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebdriverUtility;
import com.mysql.cj.jdbc.DatabaseMetaData;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hashmapcommondata {
	public static void main(String[] args) throws Throwable {
		DatabaseUtility db=new DatabaseUtility();
		ExcelUtitlity ex=new ExcelUtitlity();
		FileUtility file=new FileUtility();
		JavaUtility ja=new JavaUtility();
		WebdriverUtility web=new WebdriverUtility();
		String url=file.readDataFromPropertyFile("url");
	String username = file.readDataFromPropertyFile("username");
	String password = file.readDataFromPropertyFile("password");
	//FileInputStream f=new FileInputStream(".\\src\\test\\resources\\commondatainsurance");
	//Properties p=new Properties();
	//p.load(f);
	//String url = p.getProperty("url");
	//String username = p.getProperty("username");
	//String password = p.getProperty("password");
		
	//FileInputStream fo=new FileInputStream(".\\src\\test\\resources\\clienttextfield.xlsx");
	//Workbook wb = WorkbookFactory.create(fo);
      //Sheet sheet = wb.getSheet("Sheet1");
	
	WebDriverManager.chromedriver().create();
	Thread.sleep(2000);
	WebDriver driver=new ChromeDriver();
	//driver.manage().window().maximize();
      web.maximizeWindow(driver);
    // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      web.waitForPageLoad(driver);
 	driver.get(url);
	driver.findElement(By.name("username")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.xpath("//button[.='login']")).click();
	driver.findElement(By.xpath("//i[@class='fa fa-users ']/ancestor::li")).click();
	driver.findElement(By.xpath("//a[.='Add Client']")).click();
	
	//HashMap<String,String> map=new HashMap<String, String>();
	//for(int i=1;i<=sheet.getLastRowNum();i++) {
		//String key=sheet.getRow(i).getCell(0).getStringCellValue();
		//String value=sheet.getRow(i).getCell(1).getStringCellValue();
		//map.put(key, value);
	//}
	HashMap<String, String> map = ex.readMultipledata("Sheet1");
	for(Entry<String,String> set:map.entrySet()) {
		//if(set.getKey().contains("Locator")) {
			
		//}else {
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
	}
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	String expected = "INSERT CLIENT";
	String actual = driver.findElement(By.xpath("//h1[@class='page-head-line']")).getText();
if(actual.contains(expected)) {
	System.out.println("client is  inserted");
	}
	else {
	System.out.println("client is not inserted ");
	}
}
}
