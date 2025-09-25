package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//write a program for  searching the details of the employee
//who has the salary > specified salary and is working for specified company

public class SelectWithCondition3 {
	private static PreparedStatement ps;
	private static ResultSet res;
public static void main(String[] args) throws SQLException {
	Scanner sc = new Scanner(System.in);
	try {
		// Load MySQL JDBC Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is loaded");

		// Connect to database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root",
				"Yannam@300323");

		if (con == null) {
			System.out.println("Connection failed");
		} else {
			System.out.println("Connection established");
            //creating sql query
			//To get the data using salary
			System.out.println("enter the id:");
			int salary=sc.nextInt();
			//using company name
			System.out.println("enter the name of the person:");
			String company=sc.next();
			String sql="select * from employeetable where salary";
			ps=con.prepareStatement(sql);
			ps.setInt(1, salary);
			ps.setString(1, company);
			res=ps.executeQuery();
			
			while(res.next()==true) {
				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
				System.out.println(res.getString(3));
				System.out.println(res.getInt(4));
				System.out.println("-----------");
			}
			
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		sc.close();
		ps.close();
		
	}
}
}
