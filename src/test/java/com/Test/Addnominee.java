package com.Test;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.ExcelUtitlity;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.GenericUtilities.WebdriverUtility;
import com.Pom.Clientpage;
import com.Pom.Homepage;
import com.Pom.LoginPage;
import com.Pom.NomineePage;
import com.Pom.NomineeinformationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Addnominee extends BaseClass {
	//@Test(retryAnalyzer=com.GenericUtilities.RetryImpClass1.class)
//@Test(groups="regression")
	public void payment() throws Throwable{
		// TODO Auto-generated method stub
		//WebdriverUtility web=new WebdriverUtility();
		//ExcelUtitlity ex=new ExcelUtitlity();
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
	    h.nominee();
	    NomineeinformationPage i=new NomineeinformationPage(driver);
	    i.addnominee();
	    NomineePage n=new NomineePage(driver);
	    HashMap<String,String> map=elib.readMultipledata("Sheet2");
	      n.createnominee(elib,driver);
	     // Assert.fail();
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


