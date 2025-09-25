package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Employee {
public static void main(String[] args) {
	try {
		// Load MySQL JDBC Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is loaded");

		// Connect to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DB", "root",
				"Yannam@300323");

		if (con == null) {
			System.out.println("Connection failed");
		} else {
			System.out.println("Connection established");
            //creating sql query
			String sql="create database Employee";
			//convert sql query in to java statement
			Statement st = con.createStatement();
			//execute the statement
			int x=st.executeUpdate(sql);
			//capturing the results
			if(x>=1) {
				System.out.println("database created");
			}
			else {
				System.out.println("database creation failed");
			}
			//closing the connections
			st.close();
		}
		con.close();
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
}
