package Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentClass {
	private static Connection con;
	private static Statement st;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private ResultSet executeQuery;
	
StudentClass(){
	try {
		// Load MySQL JDBC Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
       
		// Connect to database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root",
				"Yannam@300323");
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
}

public void Operation(int input) throws SQLException {
	Scanner sc = new Scanner(System.in);
	switch(input) {
	case 1:
		String str="insert into student values(?,?,?,?,?)";
		ps=con.prepareStatement(str);
		System.out.println("Enter the ID :");
		int id=sc.nextInt();
		ps.setInt(1,id);
		
		System.out.println("Enter the Name :");
		String name=sc.next();
		ps.setString(2,name);
		
		System.out.println("Enter the School :");
		String school=sc.next();
		ps.setString(3,school);
		
		System.out.println("Enter the City :");
		String city=sc.next();
		ps.setString(4,city);
		
		System.out.println("Enter the marks:");
		int marks=sc.nextInt();
		ps.setInt(5,marks);
		
		int inserted = ps.executeUpdate();
		if(inserted>=1) {
			System.out.println("Added successfully");
		}
		else {
			System.out.println("Can't insert you data in to table");
		}
		
		break;
	case 2:
		String str2="update student set name=? where id=?";
		System.out.println("Enter the id of a Student you need to change :");
		int id2=sc.nextInt();
		System.out.println("Enter the name you need to update :");
		String updateName= sc.next();
		ps=con.prepareStatement(str2);
		ps.setInt(2, id2);
		ps.setString(1, updateName);
		int newName = ps.executeUpdate();
		if(newName>=1) {
			System.out.println("Updated name Successfully");
		}
		else {
			System.out.println("Can't update the value");
		}
		break;
	case 3:
		String str3="select * from student where id=?";
		System.out.println("Enter the id you need fetch :");
		int id3=sc.nextInt();
		ps=con.prepareStatement(str3);
		ps.setInt(1, id3);
		rs = ps.executeQuery();
		while(rs.next()==true) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getInt(5));
		}
		break;
	case 4:
		String str4="select * from student where marks>?";
		System.out.println("Enter the marks :");
		int id4=sc.nextInt();
		ps=con.prepareStatement(str4);
		ps.setInt(1, id4);
		rs = ps.executeQuery();
		while(rs.next()==true) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getInt(5));
			System.out.println("-------------------------");
		}
		break;
	case 5:
		String str5="select * from student where city=?";
		System.out.println("Enter the city  :");
		String city1=sc.next();
		ps=con.prepareStatement(str5);
		ps.setString(1, city1);
		rs = ps.executeQuery();
		while(rs.next()==true) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getInt(5));
			System.out.println("---------------------------");
		}
		break;
	case 6:
		String str6="select * from student where school=?";
		System.out.println("Enter the school  :");
		String sch=sc.next();
		ps=con.prepareStatement(str6);
		ps.setString(1, sch);
		rs = ps.executeQuery();
		while(rs.next()==true) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getInt(5));
			System.out.println("---------------------------");
		}
		break;
	}
}

}
