package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaDataOfResultSet {
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
				ResultSetMetaData metaData = res.getMetaData();
				System.out.println(metaData);
				int colCount=metaData.getColumnCount();
				System.out.println("column count : "+colCount);
				for(int i=1;i<=colCount;i++) {
				System.out.println("column number : "+i);
				System.out.println("column name : "+metaData.getColumnName(colCount));
				System.out.println("column type name"+metaData.getColumnClassName(i));
				System.out.println("-------------");
				}
//				while(res.next()==true) {
//					System.out.println(res.getInt(1));
//					System.out.println(res.getString(2));
//					System.out.println(res.getString(3));
//					System.out.println(res.getInt(4));
//					System.out.println("-----------");
//				}
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
}
}
