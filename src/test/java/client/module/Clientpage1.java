package client.module;

import java.util.HashMap;
import java.util.Map.Entry;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtitlity;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Clientpage1 {
public static void main(String[]args) throws Throwable {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	WebdriverUtility web=new WebdriverUtility();
	web.maximizeWindow(driver);
	FileUtility file=new FileUtility();
	//driver.manage().window().maximize();
	String url=file.readDataFromPropertyFile("url");
	String username = file.readDataFromPropertyFile("username");
	String password = file.readDataFromPropertyFile("password");
	driver.get(url);
	web.waitForPageLoad(driver);
	driver.findElement(By.name("username")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.xpath("//button[.='login']")).click();
	driver.findElement(By.xpath("//i[@class='fa fa-users ']/ancestor::li")).click();
	driver.findElement(By.xpath("//a[.='Add Client']")).click();
	//JavaUtility jb=new JavaUtility();
	//jb.random();
	ExcelUtitlity ex=new ExcelUtitlity();
	HashMap<String, String> map = ex.readMultipledata("Sheet1");
	for(Entry<String,String> set:map.entrySet()) {
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
	}
	//Random r=new Random();
	//int num = r.nextInt(100);
	/*driver.findElement(By.name("client_password")).sendKeys("Madhu123");
	driver.findElement(By.name("name")).sendKeys("Madhu"+num);
	File fi=new File(".\\src\\test\\resources\\dataimg\\logo.png");
	String abpath=fi.getAbsolutePath();
	driver.findElement(By.name("fileToUpload")).sendKeys(".\\src\\test\\resources\\dataimg\\logo.png");
	driver.findElement(By.name("sex")).sendKeys("Female");
	driver.findElement(By.name("birth_date")).sendKeys("12/09/90");
	driver.findElement(By.name("maritial_status")).sendKeys("unmarried");
	driver.findElement(By.name("nid")).sendKeys("123456");
	driver.findElement(By.name("phone")).sendKeys("123456789");
	driver.findElement(By.name("address")).sendKeys("b old ward house no.312 bangalore");
	driver.findElement(By.name("policy_id")).sendKeys("123");
	driver.findElement(By.name("nominee_name")).sendKeys("Maya sahu");
	driver.findElement(By.name("nominee_sex")).sendKeys("Female");
	driver.findElement(By.name("nominee_birth_date")).sendKeys("18/08/78");
	driver.findElement(By.name("nominee_nid")).sendKeys("123456");
	driver.findElement(By.name("nominee_relationship")).sendKeys("Mother");
	driver.findElement(By.name("priority")).sendKeys("1");
	driver.findElement(By.name("nominee_phone")).sendKeys("7689797990");*/
	
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	String expected = "INSERT CLIENT";
	String actual = driver.findElement(By.xpath("//h1[@class='page-head-line']")).getText();
System.out.println(actual);
if(actual.contains(expected)) {
	System.out.println("client is  inserted");
	}
	else {
	System.out.println("client is not inserted ");
	}
}
}
