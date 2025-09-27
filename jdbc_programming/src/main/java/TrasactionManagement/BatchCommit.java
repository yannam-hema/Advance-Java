package TrasactionManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BatchCommit {
    private Connection con;
    private PreparedStatement st;

    public BatchCommit() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
            con = DriverManager.getConnection(Credentials.url, Credentials.user, Credentials.pwd);
            if (con == null) {
                System.out.println("Connection failed");
            } else {
                System.out.println("Connection established");
            }
            System.out.println("-------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateOperations() {
        Scanner sc = new Scanner(System.in);
        try {
            con.setAutoCommit(false);

            String sql = "insert into employeetable (id, name, phone, age, salary, company) values (?,?,?,?,?,?)";
            st = con.prepareStatement(sql);

            // First 
            System.out.println("Enter the id:");
            st.setInt(1, sc.nextInt());

            System.out.println("Enter the name:");
            st.setString(2, sc.next());

            System.out.println("Enter the Phone Number:");
            st.setString(3, sc.next());

            System.out.println("Enter the age:");
            st.setInt(4, sc.nextInt());

            System.out.println("Enter the salary:");
            st.setInt(5, sc.nextInt());

            System.out.println("Enter the company name:");
            st.setString(6, sc.next());
            st.addBatch();

            // Second 
            System.out.println("Enter the id:");
            st.setInt(1, sc.nextInt());

            System.out.println("Enter the name:");
            st.setString(2, sc.next());

            System.out.println("Enter the Phone Number:");
            st.setString(3, sc.next());

            System.out.println("Enter the age:");
            st.setInt(4, sc.nextInt());

            System.out.println("Enter the salary:");
            st.setInt(5, sc.nextInt());

            System.out.println("Enter the company name:");
            st.setString(6, sc.next());
            st.addBatch();

            int[] results = st.executeBatch();

            // Validate results
            for (int i =0;i<results.length;i++) {
                if (results[i]==0) {
                    System.out.println("One of the batch queries failed.");
                    System.exit(0);
                }
            }

            con.commit();
            System.out.println("Batch committed successfully!");

        } catch (Exception e) {
 
            e.printStackTrace();
        }
    }
}
