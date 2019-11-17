package dbinit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Creates database table
 * 
 * @author Edna
 *
 */

public class CreateTableFlat {
	
	public static void main(String[] args) {
		try {
			Connection connec = DriverManager.getConnection("jdbc:h2:" + ".\\src\\main\\resources\\database\\database", "root", "pw");
			Statement statement = connec.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS flat "
					+ "(id INTEGER AUTO_INCREMENT, "
					+ "description VARCHAR(100), "
					+ "tenant VARCHAR(100), "
					+ "numResidents INTEGER, "
					+ "space FLOAT, "
					+ "rent FLOAT, "
					+ "movingDate DATE, "
					+ "isRented BOOL, "
					+ "PRIMARY KEY (id) );";
			
			statement.executeUpdate(sql);
			System.out.println("Table Flat created.");
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

}
