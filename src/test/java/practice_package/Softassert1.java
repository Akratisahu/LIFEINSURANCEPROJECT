package practice_package;

import static org.testng.Assert.*;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Softassert1{
	@Test
	public void hardassart() {
    SoftAssert s=new SoftAssert();
	System.out.println("Testscrpit-1");
	System.out.println("Testscript-2");
	s.assertEquals("testyantra","yantra");
	System.out.println("testscript-4");
     s.assertAll();
     System.out.println("test");
	}
	@Test
	public void hardasse() {
		System.out.println("testscript-7");
		System.out.println("testscript-9");
	}
}
