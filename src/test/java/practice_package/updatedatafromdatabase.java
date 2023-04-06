package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class updatedatafromdatabase {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
Connection con=null;
int result=0;
		try
		{
	
		Driver	driver = new Driver();
		//register the database
		DriverManager.registerDriver(driver);
		//get connection for the database
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet47","root","root");
		//create statement
		Statement state = con.createStatement();
	String query = "insert into job values(9,'raju','sahu',55000,'andhra','javaselenuim2');";
		
		//execute query
	 result = state.executeUpdate(query);
		}
		catch(Exception e) {
			
		}
		finally {
	 if(result==1) {
		 System.out.println("data updated");
	 }
		 else {
			 System.err.println("show error");
		 }
	 con.close();
	 }
	}
}

