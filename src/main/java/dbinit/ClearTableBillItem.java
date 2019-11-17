package dbinit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Clear Flat table
 * 
 * @author Edna
 *
 */

public class ClearTableBillItem {

	public static void main(String[] args) {
		try {
			Connection connec = DriverManager.getConnection("jdbc:h2:" + ".\\src\\main\\resources\\database\\database", "root", "pw");
			Statement statement = connec.createStatement();
			String sql = "TRUNCATE TABLE billitem";
			
			statement.executeUpdate(sql);
			System.out.println("Table Flat cleared.");
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
}
