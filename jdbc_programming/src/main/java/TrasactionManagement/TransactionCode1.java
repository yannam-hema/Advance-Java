package TrasactionManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TransactionCode1 {
private Connection con;
private PreparedStatement st;
public TransactionCode1() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		con = DriverManager.getConnection(Credentials.url,Credentials.user,Credentials.pwd);
		if(con==null) {
			System.out.println("connection failed");
		}
		else {
			System.out.println("Connection established");
			
		}
		System.out.println("-------------");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
}

public void Updateoperations() {
	try {
		//It stops updating the database until we explicitly mentioned
		con.setAutoCommit(false);
		String sql="update employeetable  set name=? where id =?";
		Scanner sc = new Scanner(System.in);
		st = con.prepareStatement(sql);
		System.out.println("Enter the name :");
		st.setString(1, sc.next());
		System.out.println("Enter the ID :");
		st.setInt(2, sc.nextInt());
		st.executeUpdate();
		System.out.println("-------------");
		System.out.println("Enter the name :");
		st.setString(1, sc.next());
		System.out.println("Enter the ID :");
		st.setInt(2, sc.nextInt());
		System.out.println("-------------");
		st.executeUpdate();
		con.commit();
	}
	catch (Exception e) {
	  e.printStackTrace();
	}
}
public void insertOperations() {
	
}
// If close the connections in the above method we can't make operations after one operations method call as connection will be closed 
// so we are closing connection in other method
public void closeConnection() throws SQLException {
	try {
		
	}
	finally {
		con.close();
		st.close();
	}
}
}
