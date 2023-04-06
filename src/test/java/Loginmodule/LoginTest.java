package Loginmodule;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;

public class LoginTest extends BaseClass {


	
		// TODO Auto-generated method stub
		//FileUtility file=new FileUtility();
		//WebdriverUtility web=new WebdriverUtility();
		//String url=file.readDataFromPropertyFile("url");
		//String username = file.readDataFromPropertyFile("username");
		//String password = file.readDataFromPropertyFile("password");
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		//web.maximizeWindow(driver);
		//driver.get(url);
		//web.waitForPageLoad(driver);
		//LoginPage l=new LoginPage(driver);
		//l.login(username, password);
		
@Test(dataProvider = "setdata")
	public void getdata(String loc,String add) {
			System.out.println("from  "+loc+"to  "+add);
		}
		
	@DataProvider
public Object[][] setdata() throws Throwable {
Object[][] value = elib.readMultipleSetOfData("Sheet4");
return value;
		}
	}



