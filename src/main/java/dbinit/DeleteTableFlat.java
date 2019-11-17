package dbinit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Delete Flat Table
 * 
 * @author Edna
 *
 */

public class DeleteTableFlat {

	public static void main(String[] args) {
		try {
			Connection connec = DriverManager.getConnection("jdbc:h2:" + ".\\src\\main\\resources\\database\\database", "root", "pw");
			Statement statement = connec.createStatement();
			String sql = "DROP TABLE IF EXISTS flat";
			
			statement.executeUpdate(sql);
			System.out.println("Table Flat deleted.");
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
}
