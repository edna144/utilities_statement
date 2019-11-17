package dbinit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Delete BillItem Table
 * 
 * @author Edna
 *
 */

public class DeleteTableBillItem {

	public static void main(String[] args) {
		try {
			Connection connec = DriverManager.getConnection("jdbc:h2:" + ".\\src\\main\\resources\\database\\database", "root", "pw");
			Statement statement = connec.createStatement();
			String sql = "DROP TABLE IF EXISTS billitem";
			
			statement.executeUpdate(sql);
			System.out.println("Table BillItem deleted.");
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
}
