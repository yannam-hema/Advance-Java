package Student;

import java.sql.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class StudentClass {
    private static Connection con;
    private static PreparedStatement ps;
    private static ResultSet rs;

    StudentClass() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Student", 
                    "root", 
                    "Yannam@300323");

        } catch (Exception e) {
            // Show error in Swing popup instead of crashing
            JOptionPane.showMessageDialog(null, 
                    "❌ Failed to connect to MySQL.\n" +
                    "Check if MySQL is running and credentials are correct.\n\n" +
                    e.getMessage(),
                    "Database Error", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Operation(int input) throws SQLException {
        // 🚨 Check if connection failed
        if (con == null) {
            JOptionPane.showMessageDialog(null, 
                    "❌ No database connection.\nStart MySQL server and try again.", 
                    "Connection Error", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Scanner sc = new Scanner(System.in);

        switch (input) {
            case 1:
                String str = "insert into student values(?,?,?,?,?)";
                ps = con.prepareStatement(str);

                System.out.println("Enter the ID :");
                int id = sc.nextInt();
                ps.setInt(1, id);

                System.out.println("Enter the Name :");
                String name = sc.next();
                ps.setString(2, name);

                System.out.println("Enter the School :");
                String school = sc.next();
                ps.setString(3, school);

                System.out.println("Enter the City :");
                String city = sc.next();
                ps.setString(4, city);

                System.out.println("Enter the marks:");
                int marks = sc.nextInt();
                ps.setInt(5, marks);

                int inserted = ps.executeUpdate();
                JOptionPane.showMessageDialog(null,
                        inserted >= 1 ? "✅ Added successfully" : "❌ Insert failed");
                break;

            case 2:
                String str2 = "update student set name=? where id=?";
                System.out.println("Enter the id of a Student you need to change :");
                int id2 = sc.nextInt();
                System.out.println("Enter the name you need to update :");
                String updateName = sc.next();

                ps = con.prepareStatement(str2);
                ps.setString(1, updateName);
                ps.setInt(2, id2);

                int newName = ps.executeUpdate();
                JOptionPane.showMessageDialog(null,
                        newName >= 1 ? "✅ Updated successfully" : "❌ Update failed");
                break;

            case 3:
                String str3 = "select * from student where id=?";
                System.out.println("Enter the id you need fetch :");
                int id3 = sc.nextInt();
                ps = con.prepareStatement(str3);
                ps.setInt(1, id3);
                rs = ps.executeQuery();

                StringBuilder sb3 = new StringBuilder();
                while (rs.next()) {
                    sb3.append(rs.getInt(1)).append(" | ")
                       .append(rs.getString(2)).append(" | ")
                       .append(rs.getString(3)).append(" | ")
                       .append(rs.getString(4)).append(" | ")
                       .append(rs.getInt(5)).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb3.length() > 0 ? sb3.toString() : "❌ No record found");
                break;

            case 4:
                String str4 = "select * from student where marks>?";
                System.out.println("Enter the marks :");
                int marksLimit = sc.nextInt();
                ps = con.prepareStatement(str4);
                ps.setInt(1, marksLimit);
                rs = ps.executeQuery();

                StringBuilder sb4 = new StringBuilder();
                while (rs.next()) {
                    sb4.append(rs.getInt(1)).append(" | ")
                       .append(rs.getString(2)).append(" | ")
                       .append(rs.getString(3)).append(" | ")
                       .append(rs.getString(4)).append(" | ")
                       .append(rs.getInt(5)).append("\n------------------\n");
                }
                JOptionPane.showMessageDialog(null, sb4.length() > 0 ? sb4.toString() : "❌ No students found");
                break;

            case 5:
                String str5 = "select * from student where city=?";
                System.out.println("Enter the city :");
                String city1 = sc.next();
                ps = con.prepareStatement(str5);
                ps.setString(1, city1);
                rs = ps.executeQuery();

                StringBuilder sb5 = new StringBuilder();
                while (rs.next()) {
                    sb5.append(rs.getInt(1)).append(" | ")
                       .append(rs.getString(2)).append(" | ")
                       .append(rs.getString(3)).append(" | ")
                       .append(rs.getString(4)).append(" | ")
                       .append(rs.getInt(5)).append("\n------------------\n");
                }
                JOptionPane.showMessageDialog(null, sb5.length() > 0 ? sb5.toString() : "❌ No students found");
                break;

            case 6:
                String str6 = "select * from student where school=?";
                System.out.println("Enter the school :");
                String sch = sc.next();
                ps = con.prepareStatement(str6);
                ps.setString(1, sch);
                rs = ps.executeQuery();

                StringBuilder sb6 = new StringBuilder();
                while (rs.next()) {
                    sb6.append(rs.getInt(1)).append(" | ")
                       .append(rs.getString(2)).append(" | ")
                       .append(rs.getString(3)).append(" | ")
                       .append(rs.getString(4)).append(" | ")
                       .append(rs.getInt(5)).append("\n------------------\n");
                }
                JOptionPane.showMessageDialog(null, sb6.length() > 0 ? sb6.toString() : "❌ No students found");
                break;
        }
    }
}
