package practice_package;

import org.testng.annotations.Test;

public class Dataprovid{
	@Test(dataProviderClass = Datapro.class,dataProvider = "data")
	public void getdata(String src,String dest,String address) {
		System.out.println("from "+src+" "+"to "+dest+"address"+address);
	}
	

}
