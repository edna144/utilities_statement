package dbinit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.utilities_statement.persistent.DatabaseController;

/**
 * Creates database table BillItem
 * 
 * @author Edna
 *
 */

public class CreateTableBillItem extends DatabaseController{
	
	public static void main(String[] args) {
		try {
			Connection connec = DriverManager.getConnection("jdbc:h2:" + ".\\src\\main\\resources\\database\\database", "root", "pw");
			Statement statement = connec.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS billitem "
					+ "(id INTEGER AUTO_INCREMENT, "
					+ "article VARCHAR(100), "
					+ "value FLOAT, "
					+ "unit VARCHAR(100), "
					+ "year DATE, "
					+ "PRIMARY KEY (id) );";
		
			statement.executeUpdate(sql);
			System.out.println("Table BillItem created.");
		}
		catch(Exception ex) {
			System.err.println( ex.getMessage() );
		}
	}

}
