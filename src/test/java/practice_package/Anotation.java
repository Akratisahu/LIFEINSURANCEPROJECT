package practice_package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Anotation {

	@BeforeSuite
	public void connectdatabase(){
		System.out.println("connect to database");
	}
	@BeforeClass
	public void launch() {
		System.out.println("launch the browser");
	}
	@BeforeMethod
	public void login() {
		System.out.println("login the browser");
	}
	@Test
	public void test() {
		System.out.println("testone is completed");
	}
	@Test
	public void testmethod() {
		System.out.println("testtwo is completed");
	}
	@AfterMethod
	public void logout() {
		System.out.println("logout the browser");
	}
	
	@AfterClass
	public void close(){
		System.out.println("close the browser");
	}
	
   @AfterSuite
   public void disconnect() {
	   System.out.println("disconnect the database");
   }
}
