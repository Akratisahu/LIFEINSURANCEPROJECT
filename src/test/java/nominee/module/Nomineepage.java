package nominee.module;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.ExcelUtitlity;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nomineepage {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/index.php");
		//driver.findElement(By.name("username")).sendKeys("555");
		//driver.findElement(By.name("password")).sendKeys("666");
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
		driver.findElement(By.xpath("//i[@class='fa fa-heart ']/ancestor::li")).click();
		driver.findElement(By.xpath("//a[.='Add Nominee']")).click();
		//driver.findElement(By.name("client_id")).sendKeys("11111");
		//driver.findElement(By.name("name")).sendKeys("Anushree");
		//driver.findElement(By.name("sex")).sendKeys("Female");
		//driver.findElement(By.name("birth_date")).sendKeys("12/09/90");
		//driver.findElement(By.name("nid")).sendKeys("12890");
		//driver.findElement(By.name("relationship")).sendKeys("Sister");
		//driver.findElement(By.name("priority")).sendKeys("2");
		//driver.findElement(By.name("phone")).sendKeys("7890980089");
		ExcelUtitlity ex=new ExcelUtitlity();
		HashMap<String, String> map = ex.readMultipledata("Sheet2");
		for(Entry<String,String> set:map.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());	
		}
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String expected = "INSERT NOMINEE";
		String actual = driver.findElement(By.xpath("//h1[@class='page-head-line']")).getText();
		if(actual.contains(expected)) {
		System.out.println("nominee is  inserted");
		}
		else {
		System.out.println("nominee is not inserted ");
		}
	}

}
