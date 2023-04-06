package payment.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtitlity;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaymentPage {
public static void main(String args[]) throws Throwable {
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
	driver.findElement(By.name("username")).sendKeys(username);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.xpath("//button[.='login']")).click();
	driver.findElement(By.xpath("//a[.='PAYMENTS']")).click();
	driver.findElement(By.xpath("//a[.='Add Payment']")).click();
	String actual = driver.findElement(By.xpath("//input[@name='client_id']")).getAttribute("value");
	System.out.println(actual);
	
	//driver.findElement(By.name("client_id")).sendKeys("1678780996");
	//driver.findElement(By.name("month")).sendKeys("may");
	//driver.findElement(By.name("amount")).sendKeys("3000");
	//driver.findElement(By.name("due")).sendKeys("150");
	//driver.findElement(By.name("fine")).sendKeys("200");
	ExcelUtitlity ex=new ExcelUtitlity();
	HashMap<String, String> map = ex.readMultipledata("Sheet3");
	for(Entry<String,String> set:map.entrySet()) {
		driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
	}
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	driver.findElement(By.xpath("//a[.='PAYMENTS']")).click();
	/*WebElement t = driver.findElement(By.xpath("//tbody"));
	List<WebElement> row = t.findElements(By.tagName("tr"));
	int rowcount=row.size();
	boolean flag=false;
	for(int i=0;i<rowcount;i++) {
		List<WebElement> cols = row.get(i).findElements(By.tagName("td"));
		int colcount=cols.size();
		for(int j=0;j<colcount;j++) {
			String id="1678943112";
			String c=cols.get(j).getText();
			if(c.equals(id)) {
				System.out.println("payment is inserted");
				flag=true;
				break;
			}
		}
	}
			if(!flag)
			{
				System.out.println("not added");
			}
		}*/
	
	//String expected = "INSERT PAYMENT";
	//String actual = driver.findElement(By.xpath("//h1[@class='page-head-line']")).getText();
	//if(actual.contains(expected)) {
	//System.out.println("payment is  inserted");
	//}
	//else {
	//System.out.println("payment is not inserted ");
	//}
	
	boolean flag=false;
	List<WebElement> value = driver.findElements(By.xpath("//tr"));
	//int total = value.size();
	for(WebElement t:value) {
		String res=t.getText();
		if(res.equals(actual))
		{
			System.out.println("payment added succesfully");
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


