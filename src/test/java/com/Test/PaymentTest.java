package com.Test;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.ExcelUtitlity;
import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebdriverUtility;
import com.Pom.Homepage;
import com.Pom.PaymentPage;
import com.Pom.paymentInformationPage;

public class PaymentTest extends BaseClass {
 
	@Test(groups="smoke")
	public void payment() throws Throwable {
		//ExcelUtitlity ex=new ExcelUtitlity();
		//FileUtility file=new FileUtility();
		//WebdriverUtility web=new WebdriverUtility();
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		
		//web.maximizeWindow(driver);
		//String url=file.readDataFromPropertyFile("url");
		//String username = file.readDataFromPropertyFile("username");
		//String password = file.readDataFromPropertyFile("password");
		//driver.get(url);
		//LoginPage l=new LoginPage(driver);
		//l.login(username, password);
	    Homepage h=new Homepage(driver);
	    h.payment();
	    paymentInformationPage p=new paymentInformationPage(driver);
	    p.Addpayment();
	    PaymentPage pa=new PaymentPage(driver);
		HashMap<String, String> map = elib.readMultipledata("Sheet3");
		pa.createpayment(map, driver);
		
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
	
	}


}