package TrasactionManagement;

import java.sql.SQLException;

public class Mainclass {
public static void main(String[] args) throws SQLException {
//	TransactionCode1 tc = new TransactionCode1();
//	tc.Updateoperations();
//	tc.closeConnection();
	BatchCommit bc = new BatchCommit();
	bc.updateOperations();
}
}
