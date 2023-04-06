package practice_package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class readdatafromexcel {
	public static void main(String args[]) throws IOException {
 
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
	Properties prop= new Properties();
	prop.load(fis);
	  String browser = prop.getProperty("browser");
	  String url = prop.getProperty("url");
	  String username = prop.getProperty("username");
	  String password = prop.getProperty("password");
	  System.out.println(browser);
	  System.out.println(url);
	  System.out.println(username);
	  System.out.println(password);
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get(url);
	 driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	 driver.findElement(By.name("username")).sendKeys(username);
	 driver.findElement(By.name("password")).sendKeys(password);
	 driver.findElement(By.xpath("//button[text()='login']")).click();
	 driver.close();
}
}
