package practice_package;

import org.testng.annotations.Test;

public class testngmethod {
	


	@Test(invocationCount = 0)
	public void testone() {
		System.out.println("testone is executed");
	}
	@Test(priority = -2,dependsOnMethods = "testone",invocationCount = 2)
	public void testtwo() {
		System.out.println("testtwo is executed");
	}
	@Test()
	public void testthree() {
		System.out.println("testthree is executed");
	}
}
