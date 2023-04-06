package client.module;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Deleteclientpage {
	public static void main(String args[]) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/index.php");
	driver.findElement(By.name("username")).sendKeys("555");
	driver.findElement(By.name("password")).sendKeys("666");
	driver.findElement(By.xpath("//button[.='login']")).click();
	driver.findElement(By.xpath("//i[@class='fa fa-users ']/ancestor::li")).click();
	String id="";
	driver.findElement(By.xpath("//td[.='"+id+"']/parent::tr//a[.='Client Status']")).click();
	driver.findElement(By.xpath("//a[.='Edit Client']")).click();
	driver.findElement(By.xpath("//a[.='Delete Client']")).click();
	driver.findElement(By.xpath("//a[.='CLIENTS']")).click();
	String a=id;
	List<WebElement> id1= driver.findElements(By.xpath("//tbody/tr/td[1]"));
	int count= id1.size();
	boolean flag=false;
	for(int i=0;i<count;i++) {
		String b = id1.get(i).getText();
	
		//System.out.println(b);
	if(a.equals(b)) {
		System.out.println("client is not deleted");
		flag=true;
	}
	}
  if(!flag) {
	  System.out.println("client is deleted");
  }
	  //bElement expect = driver.findElement(By.xpath("//td[.='"+id+"']"));
	//JavascriptExecutor j=(JavascriptExecutor)driver;
	//j.executeScript("window.scrollBy(0,3000)");
	//int id=1666072831;
	//driver.findElement(By.xpath("	")).click();
	//JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("window.scrollBy(0,3000)");
	//driver.findElement(By.xpath("//a[.='Delete Client']")).click();
	//String expected = "CLIENT STATUS";
	//String actual = driver.findElement(By.xpath("//h1[@class='page-head-line']")).getText();
	//System.out.println(actual);
	
	
}
}
