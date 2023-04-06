package com.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Pom.Homepage;
import com.Pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	public JavaUtility jlib=new JavaUtility();
	public ExcelUtitlity elib=new ExcelUtitlity();
	public FileUtility flib=new FileUtility();
	public DatabaseUtility dblib=new DatabaseUtility();
	public WebdriverUtility wlib=new WebdriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(alwaysRun = true)
	public void congifBS() throws Throwable {
	     dblib.connectToDb();
		System.out.println("connect to db");
	}
    // @Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configdc() throws Throwable{
	//public void  configdc(String Browser) throws Throwable {
		String Browser = flib.readDataFromPropertyFile("browser");
		String url=flib.readDataFromPropertyFile("url");
		if(Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		
		wlib.maximizeWindow(driver);
		sdriver=driver;
		driver.get(url);
		wlib.waitForPageLoad(driver);
	
	}
	@BeforeMethod(alwaysRun = true)
	public void configDM() throws Throwable {
		String username = flib.readDataFromPropertyFile("username");
		String password=flib.readDataFromPropertyFile("password");
		LoginPage l=new LoginPage(driver);
		l.login(username, password);
	}
	@AfterMethod(alwaysRun = true)
	public void configAM() {
		Homepage h= new Homepage(driver);
		h.logout();
	}
	@AfterClass(alwaysRun = true)
	public void configAc() {
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void dbclose() throws Throwable {
		dblib.closedb();
	}
}
