package SimpleOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DBCreationByUser {
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
				Scanner sc = new Scanner(System.in);
				String db_name=sc.next();
                //creating sql query
				String sql="create database "+db_name;
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
				//closing connection
				st.close();
			}
			con.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
