package com.Test;

import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.Pom.ClientInformationPage;
import com.Pom.EditPage;
import com.Pom.Homepage;

public class EditClient extends BaseClass {

	@Test(groups="regression")
 public void editclient() {
		// TODO Auto-generated method stub
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		WebdriverUtility web=new WebdriverUtility();
		web.maximizeWindow(driver);
		web.waitForPageLoad(driver);
		FileUtility file=new FileUtility();
		//driver.manage().window().maximize();
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
	   i.editdata(driver,"1667565155");
	   EditPage e=new EditPage(driver);
	    e.setpolicyid("134");
	    e.submitedit();
	}

}
