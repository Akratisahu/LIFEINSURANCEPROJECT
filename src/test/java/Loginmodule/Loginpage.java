package Loginmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginpage {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
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
		driver.findElement(By.xpath("//i[@class='fa fa-users ']/ancestor::li")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-life-saver ']/ancestor::li")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o ']/ancestor::li")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-heart ']/ancestor::li")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-credit-card ']/ancestor::li")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-exclamation-circle fa-2x']")).click();
	}

}
