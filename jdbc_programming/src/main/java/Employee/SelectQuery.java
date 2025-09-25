package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectQuery {
	private static Statement statement;
	private static ResultSet res;
	public static void main(String[] args) {
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
				String sql="select * from employeetable";
				statement=con.createStatement();
				res=statement.executeQuery(sql);
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
}
}


