package com.GenericUtilities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int random() {
		Random ran=new Random();
		int randon=ran.nextInt();
		return randon;
	}
	public String getSystemDate() {
		Date d=new Date();
		String date=d.toString();
		return date;
	}
	public String formatSystemDate() {
		SimpleDateFormat dateformat=new SimpleDateFormat("dd-MM-YYYY hh:mm:ss");
		Date dt=new Date();
		String getdateandtime=dateformat.format(dt);
		getdateandtime.replace(":", "-");
		return getdateandtime;
	}
}
