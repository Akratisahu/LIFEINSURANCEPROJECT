package practice_package;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calenderpopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//notification popup
ChromeOptions options=new ChromeOptions();
options.addArguments("--disabled-notifications");
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver(options);
//url of App
driver.get("https://www.makemytrip.com/");
//maximize the browser
driver.manage().window().maximize();
//implicit wait 
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//close popup
driver.findElement(By.xpath("//span[@class='ic_circularclose_grey']")).click();
//li[@data-cy='roundTrip'and @class='selected']or//li[@data-cy='roundTrip'][@class='selected']or//li[@data-cy='roundTrip']
driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
 WebElement from = driver.findElement(By.xpath("//input[@id='fromCity']"));
 from.sendKeys("banglore");
 ////div[@class='calc60']/child::p[.='Bengaluru, India']or//p[.='Bengaluru, India']
 driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
 WebElement to = driver.findElement(By.xpath("//input[@id='toCity']"));
 to.sendKeys("bhopal");
 driver.findElement(By.xpath("//p[.='Bhopal, India']")).click();
 //fetching system date and pass to test script as a current travel date
 Date cdate=new Date();
 //System.out.println(cdate);
 String[] d=cdate.toString().split(" ");
 String day=d[0];
 String month=d[1];
 String date=d[2];
 String year=d[5];
 String travelDate=day+" "+month+" "+date+" "+year;
 //System.out.println(travelDate);
 //driver.findElement(By.xpath(travelDate))
 //driver.findElement(By.xpath("//div[.='March 2023']/parent::div[@class='DayPicker-Month']//p[.='22']")).click();
//driver.close();
driver.findElement(By.xpath("//div[@aria-label='"+travelDate+"']")).click();
String rday="Thu";
String rmonth="Jun";
String rdate="15";
String ryear="2023";
String returndate=rday+" "+rmonth+" "+rdate+" "+ryear;
//giving infinity loop to select the futuredate
for(;;) {
	try{
		driver.findElement(By.xpath("//div[@aria-label='"+returndate+"']")).click();
		break;
	}catch(Exception e) {
		//clicking on forward arrow function
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	}
	
}
driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom5']")).click();
driver.findElement(By.xpath("//li[@data-cy='adults-6']")).click();
driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']")).click();
driver.findElement(By.xpath("//a[.='Search']")).click();
	}

}
