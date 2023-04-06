package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rmgyantraproject {

	public static void main(String[] args) throws Throwable {
		Connection con=null;
		String expproj="LIC124";
		ResultSet result=null;
		try {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver =new ChromeDriver();
driver.get("http://rmgtestingserver:8084/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
driver.findElement(By.xpath("//button[.='Sign in']")).click();
driver.findElement(By.xpath("//a[text()='Projects']")).click();
driver.findElement(By.xpath("//span[.='Create Project']")).click();
driver.findElement(By.name("projectName")).sendKeys("LIC124");
driver.findElement(By.name("createdBy")).sendKeys("deepa");
WebElement status = driver.findElement(By.name("status"));
Select s=new Select(status);
s.selectByVisibleText("On Gogin");
driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	
	Driver	driver1 = new Driver();
	DriverManager.registerDriver(driver1);
	System.out.println("register");
	 con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
	System.out.println("connection");
	 Statement state = con.createStatement();
	String query = "select * from project;";
 result = state.executeQuery(query);
 boolean flag=false;
 while(result.next())
 {
	 
	String actproj = result.getString(4);
	System.out.println(actproj);
	if(actproj.equalsIgnoreCase(expproj)) {
		flag=true;
		break;
	}
 }
 if(flag) {
	 System.out.println("project is created");
 }
 else {
	 System.out.println("project is not created");
 }
		}
catch (Exception e) {
		// TODO Auto-generated catch block
	
	}
	finally {
		con.close();
	}
	
}
	}

