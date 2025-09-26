package Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class procedure {
 private static CallableStatement call;
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
				String sql="{call employee_proce(?,?,?,?,?,?)}";
				con.prepareCall(sql);
				call=con.prepareCall(sql);
				call.setInt(1, 7);
				call.setString(2,"hemaTwo");
				call.setString(3,"999999999");
				call.setInt(4, 28);
				call.setInt(5,47000);
				call.setString(6,"Company_two");
				call.execute();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
}
}
