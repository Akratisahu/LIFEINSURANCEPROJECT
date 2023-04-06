package com.Test;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.ExcelUtitlity;
import com.GenericUtilities.JavaUtility;
import com.Pom.ClientInformationPage;
import com.Pom.Clientpage;
import com.Pom.Homepage;

//@Listeners(com.GenericUtilities.ListenerImplimentation.class)
public class AddclientTest extends BaseClass {
	@Test(retryAnalyzer=com.GenericUtilities.RetryImpClass1.class)
	//@Test(groups="smoke")
	public void Addclient() throws Throwable{
		// TODO Auto-generated method stub
		//WebdriverUtility web=new WebdriverUtility();
	
		//FileUtility file=new FileUtility();
		//JavaUtility jlib=new JavaUtility();
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		//web.maximizeWindow(driver);
	    //String url=file.readDataFromPropertyFile("url");
		//String username = file.readDataFromPropertyFile("username");
		//String password = file.readDataFromPropertyFile("password");
		//driver.get(url);
		//web.waitForPageLoad(driver);
		//LoginPage l=new LoginPage(driver);
		//l.login(username, password);
	    Homepage h=new Homepage(driver);
	    h.client();
	    ClientInformationPage i=new ClientInformationPage(driver);
	    i.Addclient();
	    Clientpage c=new Clientpage(driver);
	  //  c.idvalue();
	    HashMap<String,String> map=elib.readMultipledata("Sheet1");
	      c.createClient( map, driver, jlib, wlib);
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
