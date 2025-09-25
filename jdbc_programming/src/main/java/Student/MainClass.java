package Student;

import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {
public static void main(String[] args) throws SQLException {
	Scanner sc = new Scanner(System.in);
	System.out.println("******************************************************");
	System.out.println("1: Insert the Values in to Student table");
	System.out.println("2: Update the name of the Student Based up on the id");
	System.out.println("3: Fetch the Details of the Student Based up on the id");
	System.out.println("4: Find the Student with more than specified marks");
	System.out.println("5: Find the student who lives in specified city");
	System.out.println("6: Student who is studying in a specific school");
	System.out.println("******************************************************");
	StudentClass stu = new StudentClass();
	System.out.println("Select the operation (1/2/3/4/5/6)");
	int input=sc.nextInt();
	stu.Operation(input);
}
}
