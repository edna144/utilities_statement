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

public class InsertIntoFlat {
	
	public static void main(String[] args) {
		try {
			Connection connec = DriverManager.getConnection("jdbc:h2:" + ".\\src\\main\\resources\\database\\database", "root", "pw");
			Statement statement = connec.createStatement();
			String sql = "INSERT INTO Flat(description, tenant, numResidents, space, rent, movingDate, isRented) values"
					+ "('Geschaeftsraum klein',	'tenant1',	1,	15.0, 200.0, '2011-01-01', TRUE), "
					+ "('Geschaeftsraum gross',	'tenant2',	2,	40.0, 400.0, '2011-01-01', TRUE), "
					+ "('Seitenfluegel unten',	'tenant3',	1, 	40.0, 400.0, '2016-01-01', TRUE), "
					+ "('Seitenfluegel oben',	'tenant4',	1, 	30.0, 300.0, '2011-01-01', TRUE), "
					+ "('Wohnung OG1',			'tenant5',	1, 	120.0, 1000.0, '2013-01-01', TRUE), "
					+ "('Wohnung OG2 klein',	'tenant6',	1, 	30.0, 370.0, '2011-01-01', TRUE), "
					+ "('Wohnung OG2 gross',	'tenant7',	1, 	60.0, 700.0, '2011-01-01', TRUE)";
			
			statement.executeUpdate(sql);
			System.out.println("Table flat: new entries inserted.");
		}
		catch(Exception ex) {
			System.err.println( ex.getMessage() );
		}
	}
	
}
