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

public class ShowContentOfTableFlat {

	public static void main(String[] args) {
		try {
			Connection connec = DriverManager.getConnection("jdbc:h2:" + ".\\src\\main\\resources\\database\\database", "root", "pw");
			Statement statement = connec.createStatement();
			String sql = "SELECT * FROM flat";
			ResultSet content = statement.executeQuery(sql);
			
			// print all content columns from table Flat
			while( content.next() ) {
				System.out.println(
						content.getInt(1) + "\t "
						+ content.getString(2) + "\t" 
						+ content.getString(3) + "\t" 
						+ content.getInt(4) + "\t" 
						+ content.getFloat(5) + " " 
						+ content.getFloat(6) + "\t"
						+ content.getDate(7) + "\t"
						+ content.getBoolean(8));
			}
			
		}
		catch(Exception ex) {
			System.err.println( ex.getMessage() );
		}
	}
	
}
