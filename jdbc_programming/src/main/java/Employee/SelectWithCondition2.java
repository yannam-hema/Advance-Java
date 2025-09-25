package Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class SelectWithCondition2 {
	private static PreparedStatement ps;
	private static Statement st;
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
			String sql="select * from employeetable where salary > 35000 ";
			st=con.createStatement();
//			System.out.println("enter the name of the person:");
//			String userId=sc.next();
//			ps.setString(1, userId);
			res=st.executeQuery(sql);
			
			while(res.next()==true) {
				System.out.println(res.getInt(1));
				System.out.println(res.getString(2));
				System.out.println(res.getString(3));
				System.out.println(res.getInt(4));
				System.out.println(res.getInt(5));
				System.out.println(res.getString(6));
				System.out.println("-----------");
			}
			
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		sc.close();
		
	}
}
}
