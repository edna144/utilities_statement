package dbinit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Fill database
 * 
 * @author Edna
 *
 */

public class InsertIntoWaterMeter {
	
	public static void main(String[] args) {
		try {
			Connection connec = DriverManager.getConnection("jdbc:h2:" + ".\\src\\main\\resources\\database\\database", "root", "pw");
			Statement statement = connec.createStatement();
			// TODO reference to correct id
			String sql = "INSERT INTO WaterMeter(flatID, date, cold, warm, addcon) values"
					+ "((SELECT id FROM flat WHERE id = 0), '2018-01-01', 23.0, 75.0, 5.0), "
					+ "((SELECT id FROM flat WHERE id = 1), '2018-01-01', 55.0, 102.0, 5.0), "
					+ "((SELECT id FROM flat WHERE id = 0), '2019-01-01', 34.0, 98.0, 5.0), "
					+ "((SELECT id FROM flat WHERE id = 1), '2019-01-01', 61.0, 115.0, 5.0)";
			
			statement.executeUpdate(sql);
			System.out.println("Table WaterMeter: new entries inserted.");
		}
		catch(Exception ex) {
			System.err.println( ex.getMessage() );
		}
	}
	
}
