package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddDetailsInEmployeeTable {
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
				String sql="insert into employeetable(id,name,phone,age) values"+
				"(05, 'ravi','9876543210',52)," + 
                "(06 ,'yannam','8787878787',42)";
				//convert sql query in to java statement
				Statement st = con.createStatement();
				//execute the statement
				int x=st.executeUpdate(sql);
				//capturing the results
				if(x>=0) {
					System.out.println("Data  is added in to the table ");
				}
				else {
					System.out.println("can't add Data into the table");
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
