package practice_package;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calenderpopupassignmentspicejet {
	public static void main(String args[]) {
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver(options);
	//url of App
	driver.get("https://www.spicejet.com/");
	//maximize the browser
	driver.manage().window().maximize();
	//implicit wait 
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button']")).click();
driver.findElement(By.xpath("//div[.='From']/descendant::input")).sendKeys("BHO");
driver.findElement(By.xpath("//div[.='To']/descendant::input")).sendKeys("Bengaluru");


Date cdate=new Date();
System.out.println(cdate);
String[] d=cdate.toString().split(" ");
String day=d[0];
String month=d[1];
String date=d[2];
String year=d[5];
String travelDate=day+","+date+" "+month+" "+year;
System.out.println(travelDate);
//driver.findElement(By.id("//div[.='March 2023']/../../descendant::div[.='22']")).click();
driver.findElement(By.xpath("//div[contains(.,'"+month+"') and text()='"+year+"']/../../descendant::div[.='"+date+"']")).click();
//driver.findElement(By.xpath("//div[@data-testid='"+travelDate+"']")).click();
 //driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
 //div[@data-testId='undefined-month-March-2023']/..//div[.='24']
//for(int i=1;i<=5;i++){
//driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
//}
//driver.close();
	}
}
