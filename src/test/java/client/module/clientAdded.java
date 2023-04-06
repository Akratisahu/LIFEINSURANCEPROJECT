package client.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.GenericUtilities.ExcelUtitlity;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class clientAdded {
public static void main(String args[]) throws Throwable {
	WebDriverManager.chromedriver().setup();
	 WebDriver  driver=new ChromeDriver();
	//driver.manage().window().maximize();
	//driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/index.php");
	//driver.findElement(By.name("username")).sendKeys("555");
	//driver.findElement(By.name("password")).sendKeys("666");
	WebdriverUtility web=new WebdriverUtility();
	web.maximizeWindow(driver);
	web.waitForPageLoad(driver);
	FileUtility file=new FileUtility();
	//driver.manage().window().maximize();
	String url=file.readDataFromPropertyFile("url");
	String username = file.readDataFromPropertyFile("username");
	String password = file.readDataFromPropertyFile("password");
	driver.manage().deleteAllCookies();
	driver.get(url);
	web.waitForPageLoad(driver);
	driver.findElement(By.name("username")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.xpath("//button[.='login']")).click();
	driver.findElement(By.xpath("//i[@class='fa fa-users ']/ancestor::li")).click();
	driver.findElement(By.xpath("//a[.='Add Client']")).click();
	//Random r=new Random();
	//int num = r.nextInt(100);
	/*driver.findElement(By.name("client_password")).sendKeys("Madhu123");
	driver.findElement(By.name("name")).sendKeys("Madhu"+num);
	File f=new File(".\\src\\test\\resources\\dataimg\\logo.png");
	String abpath=f.getAbsolutePath();*/
	String actual = driver.findElement(By.xpath("//input[@name='client_id']")).getAttribute("value");
	System.out.println(actual);
	/*
	driver.findElement(By.xpath("//input[@class='img']")).sendKeys(abpath);
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
	ExcelUtitlity ex=new ExcelUtitlity();
	HashMap<String, String> map = ex.readMultipledata("Sheet1");
	for(Entry<String,String> set:map.entrySet()) {
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
	}
	Thread.sleep(8000);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	Thread.sleep(8000);
	driver.findElement(By.xpath("//i[@class='fa fa-users ']/ancestor::li")).click();
	
	
	boolean flag=false;
	List<WebElement> expected = driver.findElements(By.xpath("//td[1]"));

	for(WebElement result:expected)
	{
		String res = result.getText();
		if(res.equals(actual))
		{
			System.out.println("client added succesfully");
			flag=true;
			break;
		}
	}
		if(!flag)
		{
			System.out.println("not added");
		}
		}
}