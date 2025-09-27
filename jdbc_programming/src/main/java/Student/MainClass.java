package Student;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

public class MainClass extends JFrame {
    private StudentClass stu;
    private JTextArea output;

    public MainClass() {
        super("Student Database App");
        stu = new StudentClass();
        output = new JTextArea(20, 50);
        output.setEditable(false);

        // Buttons for operations
        JButton insertBtn = new JButton("Insert Student");
        JButton updateBtn = new JButton("Update Student");
        JButton fetchBtn = new JButton("Fetch by ID");
        JButton marksBtn = new JButton("Find by Marks");
        JButton cityBtn = new JButton("Find by City");
        JButton schoolBtn = new JButton("Find by School");

        // Panel with buttons
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.add(insertBtn);
        panel.add(updateBtn);
        panel.add(fetchBtn);
        panel.add(marksBtn);
        panel.add(cityBtn);
        panel.add(schoolBtn);

        // Scrollable output area
        JScrollPane scroll = new JScrollPane(output);
        add(panel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // Button listeners
        insertBtn.addActionListener(e -> runOperation(1));
        updateBtn.addActionListener(e -> runOperation(2));
        fetchBtn.addActionListener(e -> runOperation(3));
        marksBtn.addActionListener(e -> runOperation(4));
        cityBtn.addActionListener(e -> runOperation(5));
        schoolBtn.addActionListener(e -> runOperation(6));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void runOperation(int op) {
        try {
            // Build input string for Scanner based on operation
            StringBuilder sb = new StringBuilder();

            switch (op) {
                case 1: // Insert
                    sb.append(JOptionPane.showInputDialog("Enter ID:")).append("\n");
                    sb.append(JOptionPane.showInputDialog("Enter Name:")).append("\n");
                    sb.append(JOptionPane.showInputDialog("Enter School:")).append("\n");
                    sb.append(JOptionPane.showInputDialog("Enter City:")).append("\n");
                    sb.append(JOptionPane.showInputDialog("Enter Marks:")).append("\n");
                    break;

                case 2: // Update
                    sb.append(JOptionPane.showInputDialog("Enter ID:")).append("\n");
                    sb.append(JOptionPane.showInputDialog("Enter New Name:")).append("\n");
                    break;

                case 3: // Fetch by ID
                    sb.append(JOptionPane.showInputDialog("Enter ID:")).append("\n");
                    break;

                case 4: // Find by Marks
                    sb.append(JOptionPane.showInputDialog("Enter Marks:")).append("\n");
                    break;

                case 5: // Find by City
                    sb.append(JOptionPane.showInputDialog("Enter City:")).append("\n");
                    break;

                case 6: // Find by School
                    sb.append(JOptionPane.showInputDialog("Enter School:")).append("\n");
                    break;
            }

            // Redirect input to Scanner
            ByteArrayInputStream in = new ByteArrayInputStream(sb.toString().getBytes());
            System.setIn(in);

            // Capture console output
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            PrintStream oldOut = System.out;
            System.setOut(ps);

            stu.Operation(op); // call your logic

            System.out.flush();
            System.setOut(oldOut); // restore console output

            // Show results in Swing
            output.append(baos.toString() + "\n");

        } catch (SQLException ex) {
            output.append("Error: " + ex.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
