package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {

	Connection con=null;
	public void connectToDb() throws Throwable {
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		con=DriverManager.getConnection(IpathConstants.DBURL,IpathConstants.DBUSERNAME,IpathConstants.DBPASSWORD);
	}
public String executeQueryAndGetDate(String query,String expData,int columnIndex) throws Throwable {
	ResultSet result=con.createStatement().executeQuery(query);
	boolean flag=false;
	while(result.next()) {
		String data=result.getString(columnIndex);
		if(data.equalsIgnoreCase(expData)){
			flag=true;
			break;
			}
		}
	if(flag) {
		System.out.println("data is verified");
		return expData;
	}
	else {
		System.out.println("data is not verified");
		return "";
	}
}
public void closedb() throws Throwable  {
	con.close();
	System.out.println("database connection closed");
}
}