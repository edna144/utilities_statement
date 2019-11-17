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

public class CreateTableWaterMeter {
	
	public static void main(String[] args) {
		try {
			Connection connec = DriverManager.getConnection("jdbc:h2:" + ".\\src\\main\\resources\\database\\database", "root", "pw");
			Statement statement = connec.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS watermeter "
					+ "(id INTEGER AUTO_INCREMENT, "
					+ "flatID INT, "
					+ "date DATE, "
					+ "cold FLOAT, "
					+ "warm FLOAT, "
					+ "addcon FLOAT, "
					+ "PRIMARY KEY(id), "
					+ "FOREIGN KEY (flatID) REFERENCES Flat(id))";
			
			statement.executeUpdate(sql);
			System.out.println("Table WaterMeter created.");
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

}
