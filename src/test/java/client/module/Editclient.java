package client.module;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.GenericUtilities.FileUtility;
import com.GenericUtilities.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Editclient {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		/*driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/Life_Insurance_Management_System/index.php");
		driver.findElement(By.name("username")).sendKeys("555");
		driver.findElement(By.name("password")).sendKeys("666");*/
		WebdriverUtility web=new WebdriverUtility();
		web.maximizeWindow(driver);
		web.waitForPageLoad(driver);
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
		List<WebElement> id= driver.findElements(By.xpath("//tbody/tr/td[1]"));
		int countid = id.size();
		 String a="1667565155";
		 boolean flag = false;
		for(int i=1;i<countid;i++) {
		       String b = id.get(i).getText();
		if(a.equals(b)) {
			driver.findElement(By.xpath("//td[.='"+b+"']/parent::tr//a[.='Client Status']")).click();
			driver.findElement(By.linkText("Edit Client")).click();
		     String textfield="name";
		     WebElement tf = driver.findElement(By.xpath("//input[@name='"+textfield+"']"));
			tf.clear();
			tf.sendKeys("ammu");
			driver.findElement(By.xpath("//input[@value='UPDATE']")).click();
			flag=true;
			break;
		}
		}
		if(!flag) {
			System.out.println("client is edited");
		}
		}
		}
