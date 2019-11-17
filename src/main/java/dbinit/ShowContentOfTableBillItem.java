package dbinit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * Display content of table Flat.
 * 
 * @author Edna
 *
 */

public class ShowContentOfTableBillItem {

	public static void main(String[] args) {
		try {
			Connection connec = DriverManager.getConnection("jdbc:h2:" + ".\\src\\main\\resources\\database\\database", "root", "pw");
			Statement statement = connec.createStatement();
			String sql = "SELECT * FROM billitem";
			ResultSet content = statement.executeQuery(sql);
			
			// print all content columns from table
			while( content.next() ) {
				System.out.println(
						content.getInt(1) + "\t "
						+ content.getString(2) + "\t " 
						+ content.getFloat(3) + "\t " 
						+ content.getString(4) + "\t " 
						+ content.getDate(5) );
			}
			
		}
		catch(Exception ex) {
			System.err.println( ex.getMessage() );
		}
	}
	
}
