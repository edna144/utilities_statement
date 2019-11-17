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

public class InsertIntoBillItem {
	
	public static void main(String[] args) {
		try {
			Connection connec = DriverManager.getConnection("jdbc:h2:" + ".\\src\\main\\resources\\database\\database", "root", "pw");
			Statement statement = connec.createStatement();
			String sql = "INSERT INTO billitem(article, value, unit, year) "
					+ "values('WASTE', 1222.54, 'FLAT', '2018-01-01'), "
					+ "('GAS', 1200.0, 'NUMRESIDENTS', '2018-01-01'), "
					+ "('CHIMNEY_SWEEPER', 227.33, 'NUMRESIDENTS', '2018-01-01'), "
					+ "('CHIMNEY_SWEEPER', 230.0, 'NUMRESIDENTS', '2019-01-01')";
			
			statement.executeUpdate(sql);
			System.out.println("Table BillItem: new entries inserted.");
		}
		catch(Exception ex) {
			System.err.println( ex.getMessage() );
		}
	}
	
}
