package practice_package;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class Assertionmethod {

	@Test
	public void hardassart() {
	System.out.println("Testscrpit-1");
	System.out.println("Testscript-2");
	assertEquals("testyantra","yantra");
	System.out.println("testscript-4");
	}
	@Test
	public void hardasse() {
		int a=4;
		System.out.println("testscript-7");
		assertNull(a);
		System.out.println("testscript-9");
	}
}
