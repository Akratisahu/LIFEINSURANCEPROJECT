package ClientAddmodule;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.GenericUtilities.JavaUtility;
import com.Pom.ClientInformationPage;
import com.Pom.Homepage;
import com.Test.AddclientTest;

public class client extends BaseClass{
	@Test(groups = "smoke")
	public void addClient() throws Throwable
	{
		JavaUtility jlib=new JavaUtility();
		Homepage h=new Homepage(driver);
		h.client();
		ClientInformationPage c=new ClientInformationPage(driver);
		c.Addclient();
		String clientID = driver.findElement(By.xpath("//input[@name='client_id']")).getAttribute("value");
		//elib.writeDataIntoExcel("EditClient", 0, 0, clientID);
		System.out.println(clientID);
		//Assert.fail();
		clientAdd add=new clientAdd(driver);
		add.addClient(driver, elib, jlib);
		
	}
}
