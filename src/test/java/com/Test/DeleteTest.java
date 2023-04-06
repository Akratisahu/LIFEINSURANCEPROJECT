package com.Test;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.Pom.ClientInformationPage;
import com.Pom.EditPage;
import com.Pom.Homepage;

public class DeleteTest extends BaseClass {
@Test(groups="smoke")
	public void deleteclient() {
		// TODO Auto-generated method stub
		/*WebdriverUtility web=new WebdriverUtility();
		ExcelUtitlity ex=new ExcelUtitlity();
		FileUtility file=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		web.maximizeWindow(driver);
	    String url=file.readDataFromPropertyFile("url");
		String username = file.readDataFromPropertyFile("username");
		String password = file.readDataFromPropertyFile("password");
		driver.get(url);
		web.waitForPageLoad(driver);
		LoginPage l=new LoginPage(driver);
		l.login(username, password);*/
		Homepage h=new Homepage(driver);
	    h.client();
	    ClientInformationPage i=new ClientInformationPage(driver);
	   i.editdata(driver,"1511989270");
	   EditPage e=new EditPage(driver);
	   e.deleteclient();
	}

}
