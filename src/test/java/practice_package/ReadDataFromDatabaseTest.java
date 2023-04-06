package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {

	public static void main(String[] args) throws Throwable {
		
		//STEP-1=create object from driver
		Connection con=null;
		
		try {
		Driver	driver = new Driver();
		
		
		
		//register the database
		DriverManager.registerDriver(driver);
		//get connection for the database
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet47","root","root");
		//create statement
		Statement state = con.createStatement();
		//String query1 = "insert into job values(9,'abhi','sahu',55000,'west','javaselenuim');";
		//String query2="select * from job;";
		String query = "select * from job;";
		//execute query
	 ResultSet result = state.executeQuery(query);
	 while(result.next())
	 {
		 
		//System.out.println(result.getString(2));
		 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5)+" "+result.getString(6));
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
